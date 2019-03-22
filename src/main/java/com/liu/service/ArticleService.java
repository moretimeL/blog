package com.liu.service;

import com.liu.entity.Article;
import com.liu.pojo.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: blog
 * @author: smile liu
 * @description: 文章的service
 * @create: 2018-12-20 15:54
 **/

public interface ArticleService {
    List<Article> getAll(Integer limit,Integer curr,String type);

    Integer getCount(String type);

    Integer getAllCount();

    Integer getSum();

    Result AddArticle(Article article);

    Result selectArticleById(Integer id);

    void updataView(Integer a_id);

    Result selectNext(Integer last_id);

    Result selectLest(Integer next_id);
}
