package com.liu.contoller;

import com.liu.entity.Diary;
import com.liu.pojo.Result;
import com.liu.pojo.Role;
import com.liu.pojo.RolePermission;
import com.liu.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-04-16 14:44
 **/
@RestController
public class DiaryController {
    @Autowired
    DiaryService diaryService;

    @RolePermission(Role.ADMIN)
    @PostMapping("insertDiary")
    public Result insertDiary(Diary diary){
        return diaryService.insertDiary(diary);
    }

    @PostMapping("selectDiary")
    public Result selectDiary(Integer page){return diaryService.selectDiary(page);}

    @PostMapping("updateLikeN")
    public Result updateLikeN(String off,Integer num,Integer id){return diaryService.updateLikeN(off,num,id);}

    @RolePermission(Role.ADMIN)
    @GetMapping("selectDiaByName")
    public  Result selectDiaByName(Integer limit,Integer page){return diaryService.selectDiaByName(limit, page);}

    @RolePermission(Role.ADMIN)
    @PostMapping("deleteDiaById")
    public Result deleteDiaById(Integer id){return diaryService.deleteDiaById(id);}
}
