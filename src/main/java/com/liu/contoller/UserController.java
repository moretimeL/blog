package com.liu.contoller;

import com.liu.dao.DiaryMapper;
import com.liu.entity.Diary;
import com.liu.pojo.Result;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: blog
 * @author: smile liu
 * @description: 关于User的Controller
 * @create: 2019-02-22 10:24
 **/
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    DiaryMapper diaryMapper;
    @RequestMapping(value = "gotologin")
    public Result gotologin(String username, String password, HttpSession session){
        return userService.selectToLogin(username,password,session);
    }

    @RequestMapping(value = "uploadimg")
    public Result uploadimg(MultipartFile file){
        return userService.uploadimg(file,String.valueOf(System.currentTimeMillis())+".jpg");
    }

    @RequestMapping(value = "test")
    public List<Diary> test(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Diary> diaries = diaryMapper.selectAll();
        System.out.println(sdf.format(diaries.get(0).getD_date()));
        return diaries;
    }
}
