package com.liu.impl;

import com.liu.dao.DiaryMapper;
import com.liu.entity.Diary;
import com.liu.pojo.Result;
import com.liu.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-04-16 14:41
 **/
@Service
public class DiaryServiceImpl implements DiaryService {
    @Autowired
    DiaryMapper diaryMapper;

    @Override
    public Result insertDiary(Diary diary) {
        Result result = new Result();
        if (diaryMapper.insertDiary(diary)==1){
            result.setCode(200);
            result.setMsg("上传成功！");
        }else {
            result.setCode(0);
            result.setMsg("上传失败！");
        }
        return result;
    }

    @Override
    public Result selectDiary(Integer page) {
        Result result = new Result();
        result.setDatas(diaryMapper.selectAll(5*(page-1)));
        result.setCode(diaryMapper.selectCount());
        return result;
    }

    @Override
    public Result updateLikeN(String off, Integer num, Integer id) {
        Result result = new Result();
        if (diaryMapper.updateLikeN(off,num,id)==1){
            result.setCode(200);
        }else {
            result.setMsg("出了一点问题！请重试！");
        }
        return result;
    }
}
