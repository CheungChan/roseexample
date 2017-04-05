package com.chen.controllers;


import com.chen.annotation.NotBlank;
import com.chen.bean.Bean;
import com.chen.bean.Chen;
import com.chen.service.KylinUserService;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.portal.Pipe;
import net.paoding.rose.web.portal.Portal;
import net.paoding.rose.web.var.Flash;
import net.paoding.rose.web.var.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;

@Path("/hello/")
public class HelloController {
    @Autowired
    private KylinUserService kylinUserService;

    @Get("world")
    public String index(){
        return "@你好世界，这是rose的一个例子";
    }

    @Get("index")
    public String indexjsp(){
        return "index";
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
    @Get("/3.7")
    public String protal(Portal portal){
        portal.addWindow("p1","/hello/wp1");
        portal.addWindow("p2","/hello/wp2");
        return "portal";
    }
    @Get("/wp1")
    public String protal1(){
        return "@this is p1";
    }
    @Get("/wp2")
    public String portal2(){
        return "@this is p2";
    }
    @Get("/3.8")
    public String pipe(Pipe pipe){
        pipe.addWindow("p1", "/hello/wp1");
        pipe.addWindow("p2", "/hello/wp2");
        return "pipe";//文档说使用pipe会加速，可是示例实测压根不给响应，一直pending
    }
    @Post("/doUpload")
    public String doUpload(@Param("file")MultipartFile file) throws IOException{
        BufferedImage image = ImageIO.read(file.getInputStream());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Thumbnails.of(image)
                .scale(0.5)
                .outputFormat(file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".") + 1))
                .toOutputStream(os);
        byte[] buffer = os.toByteArray();
        //模拟上传
        File f = new File(file.getOriginalFilename());
        PrintStream writer = new PrintStream(f);
        writer.write(buffer);
        writer.flush();
        writer.close();
        return "@upload OK!" + file.getOriginalFilename();
    }
    @Post("doUploads")
    public String doUploads(MultipartFile[] files){
        String s = "";
        for (int i = 0; i < files.length; i++) {
            s += files[i].getOriginalFilename() + "<br>";
        }
        return "@ok!" + s;
    }

    @Get("showUser")
    public String showUser(){
        return "@" + kylinUserService.getUser().toString();
    }

}
