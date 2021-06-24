package cn.edu.guet.service;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;

import java.util.List;

public interface ILoginService {
    User login(String username, String password);
    User getUser(String username, String password);
    List<Tree> getTrees(String userid);
}
