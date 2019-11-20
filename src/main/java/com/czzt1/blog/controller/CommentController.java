package com.czzt1.blog.controller;

import com.czzt1.blog.pojo.Comment;
import com.czzt1.blog.service.CommentService;
import com.czzt1.blog.service.DateService;
import com.czzt1.blog.service.IpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author breeze1
 */
@RestController
public class CommentController {
    @Resource
    CommentService commentService;
    @Resource
    IpService ipService;
    @Resource
    DateService dateService;

    @ResponseBody
    @PostMapping(value = "/comment")
    public String addComment(HttpServletRequest request,Comment comment){
        String userAddr=request.getRemoteAddr();
        String userArea=ipService.getAreaByIpAddr(userAddr);
        comment.setAuthor_area(userArea);
        comment.setAuthor_name(request.getRemoteUser());
        comment.setComment_time(new Date());
        commentService.addComment(comment);
        return "S";
    }
}
