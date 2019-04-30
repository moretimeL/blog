package com.liu.service;

import com.liu.pojo.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * @program: blog
 * @author: smile liu
 * @description:
 * @create: 2019-02-22 10:46
 **/

public interface UserService {
    Result selectToLogin(String username, String password, HttpSession session);

    Result uploadimg(MultipartFile file,String filename);

    Result updataPwd(String newpwd,String oldpwd,HttpSession session);

}
