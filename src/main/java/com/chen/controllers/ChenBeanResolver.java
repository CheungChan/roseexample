package com.chen.controllers;

import com.chen.bean.Chen;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.paramresolver.ParamMetaData;
import net.paoding.rose.web.paramresolver.ParamResolver;


public class ChenBeanResolver implements ParamResolver {

    @Override
    public boolean supports(ParamMetaData metaData) {
        return Chen.class == metaData.getParamType();
    }

    @Override
    public Object resolve(Invocation inv, ParamMetaData metaData) throws Exception {
        for(String paramName: metaData.getParamNames()){
            if(paramName != null){
                Chen chen = new Chen();
                chen.setChen1(inv.getParameter("chen1"));
                chen.setChen2(inv.getParameter("chen2"));
                return chen;
            }
        }
        return null;
    }
}
