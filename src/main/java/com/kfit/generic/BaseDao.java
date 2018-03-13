package com.kfit.generic;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by davi on 2018/2/8.
 */
public class BaseDao<T>  extends WebSecurityConfigurerAdapter {
    private HibernateTemplate hibernateTemplate = new HibernateTemplate();
    private Class aClass;

    public BaseDao() {
        Class c=getClass();
        Type type = c.getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        aClass=(Class)types[0];
    }

    public T get(Serializable id){
        return (T)hibernateTemplate.get(aClass,id);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin().loginProcessingUrl("");
    }
}
