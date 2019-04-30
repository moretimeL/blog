package com.liu.interceptor;

import com.liu.entity.User;
import com.liu.pojo.Role;
import com.liu.pojo.RolePermission;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: vms
 * @author: smile liu
 * @description: 权限拦截器
 * @create: 2019-02-18 11:31
 **/

public class SecurityInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        RolePermission rolePermission = handlerMethod.getMethod().getAnnotation(RolePermission.class);
        User user = (User)session.getAttribute("user" );
        if (rolePermission == null) {
            rolePermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RolePermission.class);
        }

        if (rolePermission != null && StringUtils.isNotBlank(rolePermission.value())){
            if (user != null){
              /*  if (rolePermission.value().equals(Role.ALL)){
                    return true;
                }
                if (Integer.parseInt(rolePermission.value()) == user.getU_role()){
//                    System.out.println("角色认证成功");
                    return true;
                }else {
//                    System.out.println("角色认证失败");
                    return false;
                }*/
                return true;
            }else {
                response.sendRedirect(request.getContextPath()+"/static/html/login.html");
//                System.out.println("session为空");
                return false;
            }
        }else{
//            System.out.println("没有找到注解！");
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
