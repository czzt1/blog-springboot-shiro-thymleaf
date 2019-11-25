package com.czzt1.blog.controller;

import com.czzt1.blog.pojo.Comment;
import com.czzt1.blog.service.ArticleService;
import com.czzt1.blog.service.CommentService;
import com.czzt1.blog.service.DateService;
import com.czzt1.blog.service.IpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    @Value("${pageSize}")
    private int pageSize;
    @Resource
    private ArticleService articleService;

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

    @ResponseBody
    @GetMapping(value = "/comment/{articleId}/{pageNum}")
    public Map<String,Object> getCommentPage(@PathVariable int articleId, @PathVariable int pageNum){
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> commentList=articleService.getCommentListByArticleId(articleId);
        PageInfo<Comment> pageInfo=new PageInfo<>(commentList);
        Map<String,Object> result=new HashMap<>(2);
        result.put("page",pageInfo);
        result.put("commentList",commentList);
        return result;
    }
}
