package cn.edu.guet.service.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.ILoginDao;
import cn.edu.guet.dao.impl.LoginDaoImpl;
import cn.edu.guet.service.ILoginService;


public class LoginServiceImpl implements ILoginService {

    @Override
    public User login(String username, String password) {
        ILoginDao loginDao = new LoginDaoImpl();
        return loginDao.login(username, password);
    }
}
