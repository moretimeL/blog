package com.liu.dao;

import com.liu.entity.Album;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AlbumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Album record);

    Album selectByPrimaryKey(Integer id);

    List<Album> selectAll();

    int updateByPrimaryKey(Album record);
}