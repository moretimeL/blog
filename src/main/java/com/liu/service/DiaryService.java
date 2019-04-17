package com.liu.service;

import com.liu.entity.Diary;
import com.liu.pojo.Result;

/**
 * @program: blog
 * @author: smile liu
 * @description:日志Service
 * @create: 2019-04-16 14:38
 **/

public interface DiaryService {
    Result insertDiary(Diary diary);

    Result selectDiary(Integer page);

}
