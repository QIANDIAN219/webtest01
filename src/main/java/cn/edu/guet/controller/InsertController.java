package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IInsertService;
import cn.edu.guet.service.impl.InsertServiceImpl;
import cn.edu.guet.util.TransactionHandler;

import java.sql.Timestamp;

@Controller
public class InsertController {
    IInsertService iInsertService = (IInsertService) new TransactionHandler().createProxyObject(new InsertServiceImpl());
    @RequestMapping("insert.do")
    public void inserUser() {
        User user = new User();
        user.setUserId("u1009");
        user.setUserName("test");
        user.setPassword("test1234");
        user.setRealName("测试");
        user.setEmail("test@qq.com");
        user.setState("0");
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        iInsertService.insertUser(user);
    }
}
