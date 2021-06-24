package cn.edu.guet.servlet;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.service.ILoginService;
import cn.edu.guet.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class leftMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String username = (String) request.getAttribute("usernaem");
        System.out.println(username);
        System.out.println(userid);
        ILoginService loginService = new LoginServiceImpl();
        List<Tree> treeList = loginService.getTrees(userid);
        request.setAttribute("treeList", treeList);
        request.getRequestDispatcher("leftMenu.jsp").forward(request, response);
    }
}
