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

    int selectDiCountById(Integer id);

    List<Comment> selectDiaComById(@Param("curr") Integer curr, @Param("limit") Integer limit, @Param("d_id")Integer d_id);

    Integer selecteComCount();

    List<Comment> selectCom(@Param("curr") Integer curr, @Param("limit") Integer limit);

    Integer deleteByAid(Integer id);

    Integer deleteByDid(Integer id);
}