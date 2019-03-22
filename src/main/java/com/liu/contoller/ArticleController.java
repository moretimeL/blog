package com.liu.contoller;

import com.liu.entity.Article;
import com.liu.pojo.Result;
import com.liu.service.ArticleService;
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
        Result result = new Result();
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");

            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");

            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");

            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");

            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();

            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        System.out.println(ip);
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
