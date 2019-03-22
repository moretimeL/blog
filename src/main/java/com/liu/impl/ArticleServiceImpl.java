package com.liu.impl;

import com.liu.dao.ArticleMapper;
import com.liu.entity.Article;
import com.liu.pojo.Limit;
import com.liu.pojo.Result;
import com.liu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @program: blog
 * @author: smile liu
 * @description: ArticleService的实现类
 * @create: 2018-12-20 15:57
 **/

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> getAll(Integer limit,Integer curr,String type) {
        return articleMapper.selectAll(limit*(curr-1),limit,type);
    }

    @Override
    public Integer getCount(String type) {
        return articleMapper.selectCount(type);
    }

    @Override
    public Integer getAllCount() {
        return articleMapper.selectAllCount();
    }

    @Override
    public Integer getSum() {
        return articleMapper.selectSum();
    }

    @Override
    public Result AddArticle(Article article) {
        Result result = new Result();
        System.out.println(article);
        if(articleMapper.addArticle(article)==1){
            result.setCode(200);
            result.setMsg("提交成功！");
        }else{
            result.setMsg("提交失败！");
        }

        return result;
    }

    @Override
    public Result selectArticleById(Integer id) {
        Result result = new Result();
        result.setData(articleMapper.selectByPrimaryKey(id));

        return result;
    }


}
