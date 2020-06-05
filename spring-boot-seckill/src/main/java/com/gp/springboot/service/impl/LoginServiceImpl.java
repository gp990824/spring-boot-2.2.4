package com.gp.springboot.service.impl;

import com.gp.springboot.dao.LoginDao;
import com.gp.springboot.dto.LoginResult;
import com.gp.springboot.entity.User;
import com.gp.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gp
 * @create 2020/6/4 13:48
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public LoginResult<User> login(String userName, String passWord) {
        LoginResult<User> loginResult = null;
        if (userName == null || "".equals(userName)) {
            loginResult = new LoginResult(false, "没有用户名!");
            return loginResult;
        }
        if (passWord == null || "".equals(passWord)) {
            loginResult = new LoginResult(false, "没有密码!");
            return loginResult;
        }
        User user = loginDao.queryPasswordByUserName(userName);
        if (user != null) {
            //如果密码匹配
            if (userName.equals(user.getName()) && passWord.equals(user.getPassWord())) {
                loginResult = new LoginResult<>(true, user);
                return loginResult;
            }
            loginResult = new LoginResult<>(false, "密码不匹配!");
            return loginResult;
        } else {
            //否则用户不存在
            loginResult = new LoginResult<>(false, "用户不存在, 请重试!");
            return loginResult;
        }
    }
}
