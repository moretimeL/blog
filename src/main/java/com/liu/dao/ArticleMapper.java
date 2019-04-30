package com.liu.dao;

import com.liu.entity.Article;
import com.liu.pojo.Limit;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectAll(@Param("curr") Integer curr,@Param("limit") Integer limit,@Param("type")String type);

    int updateByPrimaryKey(Article record);

    int selectCount(@Param("type")String type);

    int selectAllCount();

    int selectSum();

    Integer addArticle(Article article);

    Integer selectShowView(Integer a_id);

    Integer updateSW(@Param("a_id")Integer a_id,@Param("newV")Integer newV);

    Integer selectNext(Integer last_id);

    Integer selectLest(Integer next_id);

    List<Article> selectAllByName(@Param("limit") Integer limit,@Param("curr") Integer curr,@Param("title") String title);

    Integer selectCountByName(@Param("title") String title);

}