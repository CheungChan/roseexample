package com.chen.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;


public class ErrorHandler implements ControllerErrorHandler {


    @Override
    public Object onError(Invocation inv, Throwable ex) throws Throwable {
        System.out.println("执行了errorHandler");
        if(ex instanceof RuntimeException){
            System.out.println("执行了runtimeHandler");
            return "@runtime";
            //代码确实执行了，可是浏览器还是返回的500 估计是框架的bug
        }
        return "@error";

    }
}
