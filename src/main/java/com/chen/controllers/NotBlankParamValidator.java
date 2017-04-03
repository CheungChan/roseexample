package com.chen.controllers;

import com.chen.annotation.NotBlank;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.ParamValidator;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;



public class NotBlankParamValidator implements ParamValidator {

    @Override
    public boolean supports(ParamMetaData metaData) {
        System.out.println("执行了NotBlankParamValidator.supports  method: " + metaData.getMethod());
        return metaData.getAnnotation(NotBlank.class) != null;
    }

    @Override
    public Object validate(ParamMetaData metaData, Invocation inv, Object target, Errors errors) {
        System.out.println("执行了NotBlankParamValidator.validate  method: " + metaData.getMethod());
        if(StringUtils.isBlank(inv.getParameter(metaData.getParamName()))){
            return "@参数不能为空";
        }
        return null;
    }
}
