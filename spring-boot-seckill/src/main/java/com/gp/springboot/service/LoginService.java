package com.gp.springboot.service;

import com.gp.springboot.dao.LoginDao;
import com.gp.springboot.dto.LoginResult;

/**
 * @author Gp
 * @create 2020/6/4 13:45
 */
public interface LoginService {

    /**
     * 登录验证
     * @param userName
     * @param passWord
     * @return
     */
    LoginResult login(String userName, String passWord);

}
