package com.liu.dao;

import com.liu.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer id);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}