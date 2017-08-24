package com.kfit.crypto;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davi on 2017/8/23.
 */
@Service
public class SmsService {

    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;
    @Autowired
    private RestTemplate restTemplate;


    static {
        URL = "http://120.25.58.127:8080/httpapi.action";
//        GETURL="http://120.25.58.127:8080/httpapi.action?action={ac}";
//        map.put("ac","sendsms");
        USERNAME = "1";
        PASSWORD = "2";
    }

    public void sendSmsVerifyCode() {
        Map<String, Object> map = new HashMap<>();
        final String message = "";
        String mobile = "123";
        String extCode = "";
        map.put("action", "sendsms");
        map.put("userId", USERNAME);
        map.put("md5password", PASSWORD);
        map.put("content", message);
        map.put("mobile", mobile);
        map.put("extCode", extCode);




        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.APPLICATION_JSON;
        headers.add("Accept", MediaType.ALL_VALUE);


        MultiValueMap<String, Object> parametersMap = new LinkedMultiValueMap<String, Object>();
        parametersMap.add("action", "sendsms");
        parametersMap.add("userId", USERNAME);
        parametersMap.add("md5password", PASSWORD);
        parametersMap.add("content", message);
        parametersMap.add("mobile", mobile);
        parametersMap.add("extCode", extCode);

        HttpEntity<MultiValueMap<String, Object>> httpEntity=new HttpEntity(parametersMap,headers);

//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//        messageConverters.add(new StringHttpMessageConverter());
//        messageConverters.add(new FormHttpMessageConverter());
//        messageConverters.add(new MappingJackson2HttpMessageConverter());
//        messageConverters.add(new FastJsonHttpMessageConverter());
//        restTemplate.getMessageConverters().addAll(messageConverters);

        String result = restTemplate.postForObject(URL, httpEntity, String.class);

      try {
          System.out.println(JSON.toJSONString(new String(result.getBytes("iso-8859-1"),"utf-8")));
      }catch (Exception e){}
    }
}
