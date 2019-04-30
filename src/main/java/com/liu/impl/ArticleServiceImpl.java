package com.liu.impl;

import com.liu.dao.ArticleMapper;
import com.liu.dao.CommentMapper;
import com.liu.entity.Article;
import com.liu.pojo.Limit;
import com.liu.pojo.Result;
import com.liu.service.ArticleService;
import org.apache.ibatis.binding.BindingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    CommentMapper commentMapper;

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
        Integer sum;
        try {
           sum = articleMapper.selectSum();
        }catch (BindingException e){
            return 0;
        }
        return sum;
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
        result.setCode(commentMapper.selectArtCountById(id));
        return result;
    }

    @Override
    public void updataView(Integer a_id) {
        Integer oldV = articleMapper.selectShowView(a_id);
        articleMapper.updateSW(a_id,oldV+1);
    }

    @Override
    public Result selectNext(Integer last_id) {
        Result result = new Result();
        Integer article = articleMapper.selectNext(last_id);
        if (article!=null){
            result.setCode(200);
            result.setData(article);
        }else {
            result.setCode(100);
            result.setMsg("沒有下一篇了哦!");
        }
        return result;
    }

    @Override
    public Result selectLest(Integer next_id) {
        Result result = new Result();
        Integer article = articleMapper.selectLest(next_id);
        if (article!=null){
            result.setCode(200);
            result.setData(article);
        }else {
            result.setCode(100);
            result.setMsg("这是第一篇了哦!");
        }
        return result;
    }

    @Override
    public Result selectAllByName(Integer limit, Integer page, String title) {
        Result result = new Result();
        List<Article> articles = articleMapper.selectAllByName(limit,limit*(page-1),title);
        if (articles != null){
            result.setCode(0);
            result.setCount(articleMapper.selectCountByName(title));
            result.setData(articles);
        }
        return result;
    }

    @Override
    @Transactional
    public Result deleteById(Integer id) {
        Result result = new Result();
        commentMapper.deleteByAid(id);
            if (articleMapper.deleteByPrimaryKey(id) == 1) {
                result.setCode(200);
                result.setMsg("操作成功！");
            } else {
                result.setCode(-1);
                result.setMsg("操作失败！");
            }

        return result;
    }

    @Override
    public Result selectById(Integer id) {
        Result result = new Result();
        result.setData(articleMapper.selectByPrimaryKey(id));
        return result;
    }

    @Override
    public Result updateById(Article article) {
        Result result = new Result();
        if (articleMapper.updateByPrimaryKey(article) == 1){
            result.setMsg("修改成功！");
        }else {
            result.setMsg("出现一点问题，我们这边建议充实一下呢！亲亲！");
        }
        return result;
    }


}
