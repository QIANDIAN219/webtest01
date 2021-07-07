package cn.edu.guet.service.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.impl.InsertUserImpl;
import cn.edu.guet.service.IInsertService;

public class InsertServiceImpl implements IInsertService {
    @Override
    public void insertUser(User user) {
        InsertUserImpl insertUser = new InsertUserImpl();
        insertUser.insertUser(user);
    }
}
