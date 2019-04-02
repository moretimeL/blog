package com.liu.dao;

import com.liu.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertToArticle(Comment comment);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    int selectArtCountById(Integer id);

    List<Comment> selectArcComById(@Param("curr") Integer curr, @Param("limit") Integer limit, @Param("a_id")Integer a_id);
}