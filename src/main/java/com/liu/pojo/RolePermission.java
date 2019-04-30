package com.liu.pojo;

import java.lang.annotation.*;

/**
 * @program: vms
 * @author: smile liu
 * @description: 角色注解类
 * @create: 2019-02-18 11:17
 **/
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RolePermission {
    String value();
}
