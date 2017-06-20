package com.kfit.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码登录处理
 *
 * @author Pyramid
 */
public class BaseFormAuthenticationFilter extends FormAuthenticationFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String captchaParam = "captcha";

    public String getCaptchaParam() {
        return captchaParam;
    }

    protected String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    @Override
    protected CaptchaUsernamePasswordToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String captcha = getCaptcha(request);
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);
        return new CaptchaUsernamePasswordToken(username, password, rememberMe, host, captcha);
    }

    /**
     * 验证码校验 doCaptchaValidate 方法中，验证码校验使用了框架 KAPTCHA 所提供的 API。
     *
     * @param token
     */
    protected void doCaptchaValidate(CaptchaUsernamePasswordToken token) {

        String captcha = (String) SecurityUtils.getSubject().getSession().getAttribute("DEFAULT_CAPTCHA_PARAM");
        if (captcha == null || captcha.trim().equals("")) {
            throw new IncorrectCaptchaException("请输入验证码");//验证码错误
        }
        if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
            throw new IncorrectCaptchaException("验证码错误");//验证码错误
        }
    }

    /**
     * 认证
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        CaptchaUsernamePasswordToken token = createToken(request, response);
        String username = token.getUsername();
        try {
//            doCaptchaValidate(token);
            Subject currentUser = getSubject(request, response);
            currentUser.login(token);
            logger.info("对用户[" + username + "]进行登录验证..验证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return onLoginSuccess(token, currentUser, request, response);
        } catch (IncorrectCaptchaException uae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,验证码错误");
            return onLoginFailure(token, uae, request, response);
        } catch (UnknownAccountException uae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            return onLoginFailure(token, uae, request, response);
        } catch (UnauthorizedException ue) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,没有相应的授权");
            return onAccessDenied(request, response);
        } catch (ExpiredCredentialsException ece) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,帐号已过期");
            return onLoginFailure(token, ece, request, response);
        } catch (IncorrectCredentialsException ice) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            return onLoginFailure(token, ice, request, response);
        } catch (LockedAccountException lae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            return onLoginFailure(token, lae, request, response);
        } catch (DisabledAccountException dae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,帐号已被禁用");
            return onLoginFailure(token, dae, request, response);
        } catch (ExcessiveAttemptsException eae) {
            logger.error("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            return onLoginFailure(token, eae, request, response);
        } catch (AuthenticationException ae) {
            logger.info("对用户[" + username + "]进行登录验证..验证失败..尝试重新登录,堆栈轨迹如下", ae);
            ae.printStackTrace();
            return onLoginFailure(token, ae, request, response);
        }

    }

    /**
     * 覆盖默认实现，用sendRedirect直接跳出框架，以免造成js框架重复加载js出错。
     *
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
                                     ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (!isAjaxRequest(httpServletRequest)) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + this.getSuccessUrl());
            //  issueSuccessRedirect(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.getRequestDispatcher("/login/success").forward(httpServletRequest, httpServletResponse);
        }
        return false;
    }

    /**
     * 判断是否异步请求.
     *
     * @return true异步.
     */

    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("X-Requested-With");
        return header != null && "XMLHttpRequest".equals(header);
    }
}
