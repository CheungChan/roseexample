package com.chen.controllers.myforum;

import com.chen.bean.Topic;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.var.Flash;
import net.paoding.rose.web.var.Model;


@Path("")
public class ForumController {

    @Get("topic")
    public String getTopics(){
        // 显示主贴列表
        return "topicList";
    }
    @Get("topic/{topicId:[0-9]+}")
    public String showTopic(@Param("topicId") int topicId){
        // 显示主贴和他的跟帖
        return "topic";
    }
    @Get("topic/{topicId:[0-9]+}/comment/{commentId:[0-9]+}")
    public String showComment(Model model, @Param("topicId") int topicId, @Param("commentId") int commentId){
        // 显示单个回帖
        model.add("name", "郭德纲");
        model.add("commentContent", "今天来人不少，我很欣慰啊");
        return "comment";
    }
    @Post("topic")
    public String createTopic(Topic topic){
        // 创建一个回帖
        return "@topic" + topic.getId() + ": level.id=" + topic.getLevel().getId();
    }
    @Post("topic/{topicId:[0-9]+}/comment")
    public String createComment(@Param("topicId") int topicId){
        // 创建一个跟帖
        return "comment";
    }

}
