package com.liu.contoller;

import com.liu.entity.Article;
import com.liu.entity.Comment;
import com.liu.entity.Diary;
import com.liu.pojo.Result;
import com.liu.service.CommentService;
import com.liu.utile.FileUtile;
import com.liu.utile.IpUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-04-01 16:14
 **/
@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("insertToArt")
    public Result insertToArt(HttpServletRequest request, Comment comment,Integer aid,Integer did){
        comment.setcIp(IpUtile.getIp(request));
        Article article = new Article();
        Diary diary = new Diary();
        diary.setId(did);
        article.setId(aid);
        comment.setdId(diary);
        comment.setaId(article);
        return commentService.insertToArt(comment);
    }

    @PostMapping("selectArcComById")
    public Result selectArcComById(Integer curr,Integer limit,Integer a_id){
        return commentService.selectArcComById(curr,limit,a_id);
    }

    @PostMapping("selectDiaComById")
    public Result selectDiaComById(Integer curr,Integer limit,Integer d_id){
        return commentService.selectDiaComById(curr,limit,d_id);
    }

    @GetMapping("selecteComCount")
    public Result selecteComCount(){
        return commentService.selecteComCount();
    }
    @GetMapping("selectCom")
    public Result selectCom(Integer limit,Integer curr){
        return commentService.selectCom(curr,limit);
    }

    @GetMapping("selectAllCom")
    public Result selectAllCom(Integer limit,Integer page){
        return commentService.selectAllCom(page,limit);
    }

    @PostMapping("deleteComById")
    public  Result deleteCommById(Integer id){return commentService.deleteByPrimaryKey(id);}

    @GetMapping("selectAllArtCom")
    public Result selectAllArtCom(Integer limit,Integer page,Integer a_id){
        return commentService.selectAllArtCom(page,limit,a_id);
    }

    @GetMapping("selectAllDiaCom")
    public Result selectAllDiaCom(Integer limit,Integer page,Integer d_id){
        return commentService.selectAllDiaCom(page,limit,d_id);
    }

}
