package cn.edu.guet.controller;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import cn.edu.guet.service.IInsertService;
import cn.edu.guet.service.ILoginService;
import cn.edu.guet.service.impl.InsertServiceImpl;
import cn.edu.guet.service.impl.LoginServiceImpl;
import cn.edu.guet.util.TransactionHandler;

import java.util.List;

@Controller
public class LoginController {
//    ILoginService loginService = (ILoginService) new TransactionHandler().createProxyObject(new LoginServiceImpl());
    @RequestMapping("login.do")
    public String Login(String username, String password) {
        LoginServiceImpl loginService1 = new LoginServiceImpl();
        User user = loginService1.login(username, password);
//        return "redirect:leftMenu2.jsp?userid=" + user.getUserId();
        return "redirect:leftMenu2.jsp?userid=" + user.getUserId();
    }

    @RequestMapping("getTree.do")
    public List<Tree> getTree(String userid) {
        ILoginService loginService = new LoginServiceImpl();
        List<Tree> list = loginService.getTrees(userid);
        return list;
    }
}
