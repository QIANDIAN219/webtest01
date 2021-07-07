package cn.edu.guet.controller;

import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.impl.LoginServiceImpl;

@Controller
public class LoginController {
    @RequestMapping("login.do")
    public String Login(String username, String password) {
        LoginServiceImpl loginService = new LoginServiceImpl();
        User user = loginService.login(username, password);
        System.out.println("userid:" + user.getUserId());
        return "redirect:leftMenu?userid=" + user.getUserId();
    }
}
