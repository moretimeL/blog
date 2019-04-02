package com.liu.contoller;

import com.liu.entity.Article;
import com.liu.pojo.Result;
import com.liu.service.ArticleService;
import com.liu.utile.IpUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: blog
 * @author: smile liu
 * @description: 文章controller
 * @create: 2018-12-20 15:26
 **/
@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @PostMapping("getArticle")
    public Result getArticle(Integer limit,Integer curr,String type,HttpServletRequest request){
        Result result = new Result();
        String count = String.valueOf(articleService.getCount(type));
        String allcount = String.valueOf(articleService.getAllCount());
        String sum = String.valueOf(articleService.getSum());
        result.setState(sum);
        result.setCode(Integer.valueOf(allcount));
        result.setMsg(count);
        result.setData(articleService.getAll(limit,curr,type));
        return result;
    }

    @GetMapping("getIp")
    public String getIp(HttpServletRequest request){
        String ip = IpUtile.getIp(request);
        return ip;
    }

    @PostMapping(value = "addArticle")
    public Result addArticle(Article article){
        return articleService.AddArticle(article);
    }

    @PostMapping(value = "selectArticleById")
    public Result selectArticleById(HttpSession session){
        return articleService.selectArticleById((Integer) session.getAttribute("a_id"));
    }

    @GetMapping(value = "selectNext")
    public Result selectNext(Integer last_id){
        return articleService.selectNext(last_id);
    }

    @GetMapping(value = "selectLest")
    public Result selectLest(Integer next_id){
        return articleService.selectLest(next_id);
    }
}
