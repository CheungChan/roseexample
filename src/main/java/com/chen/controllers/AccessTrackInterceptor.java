package com.chen.controllers;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2017/3/31.
 */
public class AccessTrackInterceptor extends ControllerInterceptorAdapter {
    public AccessTrackInterceptor() {
        setPriority(29600);
    }

    @Override
    protected Object before(Invocation inv) throws Exception {
        return super.before(inv);
    }

    @Override
    public void afterCompletion(Invocation inv, Throwable ex) throws Exception {
        super.afterCompletion(inv, ex);
    }

    @Override
    protected Class<? extends Annotation> getRequiredAnnotationClass() {
        return super.getRequiredAnnotationClass();
//        return PriCheckRequired.class; // 这是一个注解，只有标过的controller才会接受这个拦截器的洗礼
    }
}
