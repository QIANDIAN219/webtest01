package cn.edu.guet.dao;

import cn.edu.guet.bean.User;

public interface ILoginDao {
    User login(String username, String password);
}
