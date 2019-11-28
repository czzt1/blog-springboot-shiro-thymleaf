package com.czzt1.blog.mapper;

import com.czzt1.blog.pojo.Article;
import com.czzt1.blog.pojo.Comment;
import com.czzt1.blog.pojo.Label;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author czzt1
 * @Date 2019-06-19- 17:53
 */
public interface ArticleMapper {
    Article select(@Param(value = "id") int id);

    List<Article> getListByLable(int articleType);

    List<Label> getArticleLabel(String id);

    List<Comment> getCommentById(int id);

    List<Article> getListByHeat();

    int countArticle();

    List<Article> getListByCrtTime();

    List<Article> searchByKeyWord(String keyWord);
}
