package com.czzt1.blog.service;

import com.czzt1.blog.pojo.Article;
import com.czzt1.blog.pojo.Comment;

import java.util.List;

public interface ArticleService {
    /**
     * 返回文章内容明细
     * @return 文章内容明细
     */
    public Article getDetailById(int articleId);

    /**
     * 返回文章评论
     * @return 文章评论列表
     */
    public List<Comment> getCommentListByArticleId(int articleId);

    /**
     * 返回文章列表
     * @return 文章列表
     */
    public List<Article> getList(int articleType);

    /**
     * 返回热门文章列表
     * @return 热门文章列表
     */
    public List<Article> getHotArticle();

    /**
     * 返回文章总页数
     * @param pageSize 每页条数
     * @return
     */
    public int getTotalPageNum(int pageSize);

    /**
     * 返回最新文章列表
     * @return 最新文章列表
     */
    public List<Article> getNewestArticle();

    /**
     * 用关键词查询
     * @param keyWord 关键词
     * @return  查询结果
     */
    public List<Article> searchByKeyWord(String keyWord);
}
