package cn.edu.guet.service.impl;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.ILoginDao;
import cn.edu.guet.dao.impl.LoginDaoImpl;
import cn.edu.guet.service.ILoginService;

import java.util.List;


public class LoginServiceImpl implements ILoginService {

    @Override
    public User login(String username, String password) {
        ILoginDao loginDao = new LoginDaoImpl();
        return loginDao.login(username, password);
    }

    @Override
    public User getUser(String username, String password) {
        ILoginDao loginDao = new LoginDaoImpl();
        return loginDao.getUser(username, password);
    }

    @Override
    public List<Tree> getTrees(String userid) {
        ILoginDao loginDao = new LoginDaoImpl();
        return loginDao.getTrees(userid);
    }
}
