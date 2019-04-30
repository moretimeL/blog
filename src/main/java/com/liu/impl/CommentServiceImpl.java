package com.liu.impl;

import com.liu.dao.CommentMapper;
import com.liu.entity.Comment;
import com.liu.pojo.Result;
import com.liu.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-04-01 15:43
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Override
    public Result insertToArt(Comment comment) {
        Result result = new Result();
        Date time = new Date();
        if (commentMapper.insertToArticle(comment)==1){
            result.setCode(200);
            comment.setcDate(time);
            result.setData(comment);
        }else {
            result.setCode(0);
            result.setMsg("留言失败了！快想想办法啊!!");
        }
        return result;
    }

    @Override
    public Result selectArcComById(Integer curr, Integer limit, Integer a_id) {
        Result result = new Result();
        result.setDatas(commentMapper.selectArcComById(limit*(curr-1),limit,a_id));
        return result;
    }

    @Override
    public Result selectDiaComById(Integer curr, Integer limit, Integer d_id) {
        Result result = new Result();
        result.setDatas(commentMapper.selectDiaComById(limit*(curr-1),limit,d_id));
        return result;
    }

    @Override
    public Result selectCom(Integer curr,Integer limit) {
        Result result = new Result();
        result.setDatas(commentMapper.selectCom(limit*(curr-1),limit));
        return result;
    }

    @Override
    public Result selecteComCount() {
        Result result = new Result();
        result.setData(commentMapper.selecteComCount());
        return result;
    }
}
