package cn.edu.guet.service;

import cn.edu.guet.bean.User;

public interface ILoginService {
    User login(String username, String password);
}
