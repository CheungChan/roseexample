package com.chen.controllers;


import com.chen.annotation.NotBlank;
import com.chen.bean.Bean;
import com.chen.bean.Chen;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.var.Flash;
import net.paoding.rose.web.var.Model;

@Path("/hello/")
public class HelloController {

    @Get("world")
    public String index(){
        return "@你好世界，这是rose的一个例子";
    }
    @Get("test")
    public String test(Model model){
        Bean bean = new Bean();
        bean.setBeanValue("这是一个bean");
        model.add("mybean", bean);
        return "beanTest";
    }
    @Get("testArray")
    public String testArray(Model model){
        String[] array = {"111", "222", "333"};
        model.add("array", array);
        return "testArray";
    }
    @Get("json")
    public String returnJson(){
        String json = "{\"hello\":\"HELLO\",\"world\":\"World\"}";
        return "@json:" + json;
    }
    @Get("error")
    public String returnError() throws Exception{
        throw new RuntimeException("出错了");
    }
    @Get("param")
    public String param(Chen chen){
        return "@hello,world " + chen.getChen1() + chen.getChen2();
    }
    @Get("notBlank")
    public String notBlank(@NotBlank @Param("messages") String messages){
        return "@得到了messages " + messages;
    }
    @Get("/flash1")
    public  String flashStep1(Flash flash){
        flash.add("msg", "修改成功");
        return "r:flash2";//文档说是302可是实测是301
    }
    @Get("/flash2")
    public String flashStep2(Invocation inv, Flash flash){
        inv.addModel("info",flash.get("msg"));
        return "flash";
    }
}
