package com.liu.impl;

import com.liu.dao.UserMapper;
import com.liu.entity.User;
import com.liu.pojo.Img;
import com.liu.pojo.Result;
import com.liu.service.UserService;
import com.liu.utile.FileUtile;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-02-22 10:48
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public Result selectToLogin(String username, String password, HttpSession session) {
        Result result = new Result();
        User user = userMapper.selectToLogin(username,password);
        if(user != null){
            session.setAttribute("user",user);
            result.setCode(200);
        }else{
            result.setCode(0);
            result.setMsg("账号或者用户名错误！");
        }
        return result;
    }

    @Override
    public Result uploadimg(MultipartFile file,String filename) {
        Result result = new Result();
        FileUtile fileUtile = new FileUtile();
        fileUtile.updataImg(file,filename);
        Img img = new Img(filename,"http://111.230.74.190:8089/"+filename);
        result.setCode(0);
        result.setData(img);
        return result;
    }
}
