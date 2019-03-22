package com.liu.dao;

import com.liu.entity.Me;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Me record);

    Me selectByPrimaryKey(Integer id);

    List<Me> selectAll();

    int updateByPrimaryKey(Me record);
}