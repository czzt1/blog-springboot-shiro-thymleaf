package com.czzt1.blog.controller;

import com.czzt1.blog.mapper.UserInfoMapper;
import com.czzt1.blog.pojo.Article;
import com.czzt1.blog.pojo.Comment;
import com.czzt1.blog.pojo.Pagination;
import com.czzt1.blog.pojo.UserInfo;
import com.czzt1.blog.service.ArticleService;
import com.czzt1.blog.service.LabelService;
import com.czzt1.blog.service.impl.DailySentenceServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author czzt1
 * @Date 2019-06-18- 19:24
 */
@Controller
public class MainController {

    @Resource
    private DailySentenceServiceImpl dailySentenceService;

    @Resource
    private ArticleService articleService;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private LabelService labelService;

    @Value("${pageSize}")
    private int pageSize;

    @RequestMapping("/")
    public ModelAndView defaultIndex(HttpSession session){
        return indexAction(session);
    }

    @RequestMapping(value = {"", "/index"})
    public ModelAndView index(HttpSession session){
        Subject curUser = SecurityUtils.getSubject();
        return indexAction(session);
    }

    /*@RequestMapping("/logout")
    public void logout(HttpServletResponse response,HttpSession session) throws IOException {
        session.invalidate();
        response.sendRedirect("/");
    }*/

    private ModelAndView indexAction(HttpSession session){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");

        UserInfo userInfo= null;
        try {
            userInfo = (UserInfo) session.getAttribute("userInfo");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(userInfo!=null){
            userInfo=userInfoMapper.selectUserByName(userInfo.getUsername());
            userInfo.setStatus("S");
            modelAndView.addObject("userinfo",userInfo);
        }
        //每日一句
        modelAndView.addObject("dailySentence",dailySentenceService.getDailySentence());
        //热门文章
        modelAndView.addObject("hotArticleList",articleService.getHotArticle());
        //热门文章
        modelAndView.addObject("newestArticleList",articleService.getNewestArticle());
        return modelAndView;
    }

    @RequestMapping(value = "/category/{articleType}/{pageNum}",method = RequestMethod.GET)
    public ModelAndView category(@PathVariable int pageNum,@PathVariable int articleType){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("category");
        PageHelper.startPage(pageNum,pageSize);
        List<Article> articleList=articleService.getList(articleType);
        PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);
        modelAndView.addObject("pageLabel",labelService.getLabelById(articleType));
        modelAndView.addObject("articleList",articleList);
        modelAndView.addObject("page",new Pagination(pageInfo.getPages(),pageNum));
        //每日一句
        modelAndView.addObject("dailySentence",dailySentenceService.getDailySentence());
        //热门文章
        modelAndView.addObject("hotArticleList",articleService.getHotArticle());
        return modelAndView;
    }

    @RequestMapping(value = "/article/{articleNum}",method = RequestMethod.GET)
    public ModelAndView article(@PathVariable int articleNum){
        ModelAndView modelAndView=new ModelAndView();
        //获取文章内容
        Article article=articleService.getDetailById(articleNum);
        modelAndView.setViewName("article");
        modelAndView.addObject("article",article);
        //评论
        PageHelper.startPage(1,pageSize);
        List<Comment> commentList=articleService.getCommentListByArticleId(articleNum);
        PageInfo<Comment> pageInfo = new PageInfo<Comment>(commentList);
        modelAndView.addObject("commentPage",new Pagination(pageInfo.getPages(),1));
        modelAndView.addObject("commentList",commentList);
        //每日一句
        modelAndView.addObject("dailySentence",dailySentenceService.getDailySentence());
        //热门文章
        modelAndView.addObject("hotArticleList",articleService.getHotArticle());
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public ModelAndView search(String keyword){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("search");
        PageHelper.startPage(1,pageSize);
        List<Article> articleList=articleService.searchByKeyWord(keyword);
        PageInfo<Article> pageInfo = new PageInfo<Article>(articleList);
        modelAndView.addObject("articleList",articleList);
        modelAndView.addObject("page",new Pagination(pageInfo.getPages(),1));
        //每日一句
        modelAndView.addObject("dailySentence",dailySentenceService.getDailySentence());
        //热门文章
        modelAndView.addObject("hotArticleList",articleService.getHotArticle());
        return modelAndView;
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("admin");
        return modelAndView;
    }

    @RequestMapping(value = "/tags",method = RequestMethod.GET)
    public ModelAndView tags() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("tags");
        return modelAndView;
    }

    @RequestMapping(value = "/readers",method = RequestMethod.GET)
    public ModelAndView readers() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("readers");
        return modelAndView;
    }

    @RequestMapping(value = "/links",method = RequestMethod.GET)
    public ModelAndView links() {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("links");
        return modelAndView;
    }

}
