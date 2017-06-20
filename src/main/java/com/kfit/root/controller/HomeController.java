package com.kfit.root.controller;

import com.kfit.config.shiro.MyShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @Resource(name = "aaa")
    private MyShiroRealm myShiroRealm;

    @RequestMapping({"/"})
    public String root() {
        if (getSub().isAuthenticated() || getSub().getPrincipals() != null) {
            return "/index";
        }
        return "/login";
    }

    @RequestMapping({"/index"})
    public String index() {
        return "/index";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        if (getSub().isAuthenticated())
            return "/index";
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map, NativeWebRequest nwr, SessionStatus s,
                        UsernamePasswordToken token) throws Exception {
        MyShiroRealm myShiroRealm=this.myShiroRealm;
        try {
            doLogin(token);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("异常测试");
        }
        if (!getSub().isAuthenticated() || getSub().getPrincipals() == null) {

            return "/login";
        }

        return "/index";

    }

    private Subject getSub() {
        return SecurityUtils.getSubject();
    }

    private void doLogin(UsernamePasswordToken token) {
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

    private void afterLogin(SessionStatus status) {
        status.setComplete();
    }
}
