package com.liu.service;

import com.liu.entity.Comment;
import com.liu.pojo.Result;
import org.omg.PortableInterceptor.INACTIVE;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-04-01 15:42
 **/

public interface CommentService {
    Result insertToArt(Comment comment);

    Result selectArcComById(Integer curr, Integer limit,Integer a_id);

    Result selectDiaComById(Integer curr, Integer limit,Integer d_id);

    Result selectCom(Integer curr, Integer limit);

    Result selecteComCount();
}
