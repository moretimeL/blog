package com.liu.dao;

import com.liu.entity.Diary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insertDiary(Diary record);

    Diary selectByPrimaryKey(Integer id);

    List<Diary> selectAll(Integer page);

    Integer selectCount();

    int updateByPrimaryKey(Diary record);


}