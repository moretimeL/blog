package com.liu.contoller;

import com.liu.dao.DiaryMapper;
import com.liu.entity.Diary;
import com.liu.pojo.Result;
import com.liu.pojo.Role;
import com.liu.pojo.RolePermission;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    public synchronized Result uploadimg(MultipartFile file){
        return userService.uploadimg(file,String.valueOf(System.currentTimeMillis())+".jpg");
    }

    @RolePermission(value = Role.ADMIN)
    @PostMapping(value = "updataPwdById")
    public Result updataPwdById(String oldpwd,String newpwd,HttpSession session){
        return  userService.updataPwd(newpwd,oldpwd,session);
    }

}
