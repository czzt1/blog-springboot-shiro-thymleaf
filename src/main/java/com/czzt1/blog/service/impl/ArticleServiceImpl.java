package com.czzt1.blog.service.impl;

import com.czzt1.blog.mapper.ArticleMapper;
import com.czzt1.blog.pojo.Article;
import com.czzt1.blog.pojo.Comment;
import com.czzt1.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Override
    public Article getDetailById(int articleId) {
        return articleMapper.select(articleId);
    }

    @Override
    public List<Comment> getCommentListByArticleId(int articleId) {
        return articleMapper.getCommentById(articleId);
    }


    @Override
    public List<Article> getList(int articleType) {
        return articleMapper.getListByLable(articleType);
    }

    @Override
    public List<Article> getHotArticle() {
        return articleMapper.getListByHeat();
    }

    @Override
    public int getTotalPageNum(int pageSize) {
        int count=articleMapper.countArticle();
        return (int) Math.ceil((double) count / (double) pageSize);
    }

    @Override
    public List<Article> getNewestArticle() {
        return articleMapper.getListByCrtTime();
    }
}
