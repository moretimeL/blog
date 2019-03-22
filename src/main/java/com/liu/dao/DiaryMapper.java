package com.liu.dao;

import com.liu.entity.Diary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Diary record);

    Diary selectByPrimaryKey(Integer id);

    List<Diary> selectAll();

    int updateByPrimaryKey(Diary record);
}