package com.liu.dao;

import com.liu.entity.Record;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Record record);

    Record selectByPrimaryKey(Integer id);

    List<Record> selectAll();

    int updateByPrimaryKey(Record record);
}