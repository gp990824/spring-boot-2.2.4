package com.gp.springboot.dao;

import com.gp.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Gp
 * @create 2020/6/4 13:38
 */
@Mapper
public interface LoginDao {
    /**
     * 根据用户名查出用户信息, 登录验证
     * @param userName
     * @return
     */
    User queryPasswordByUserName(String userName);
}
