package com.liu.contoller;

import com.liu.pojo.Result;
import com.liu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @program: blog
 * @author: smile liu
 * @description: 用来跳转的controller
 * @create: 2018-12-19 11:36
 **/
@Controller
public class SkipController {
    @Autowired
    ArticleService articleService;
    @RequestMapping("/toindex")
    public String toIndex(){ return "index"; }
    @RequestMapping("/toabout")
    public String toAbout(){ return "about"; }
    @RequestMapping("/toalbum")
    public String toAlbum(){ return "album"; }

    @RequestMapping("/todetails")
    public String toDetails(Integer id, HttpSession session){
        session.setAttribute("a_id",id);
        articleService.updataView(id);
        return "details"; }
    @RequestMapping("/toleacots")
    public String toLeacots(){ return "leacots"; }
    @RequestMapping("/towhisper")
    public String toWhisper(){ return "whisper"; }

    @GetMapping("/getSession")
    @ResponseBody
    public Result getSession(HttpSession session){
        Result result = new Result();
        if (session.getAttribute("user")==null){
            result.setCode(0);
        }else {
            result.setCode(1);
        }
        return result;
    }
}
