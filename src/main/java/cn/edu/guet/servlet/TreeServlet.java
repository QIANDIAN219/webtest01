package cn.edu.guet.servlet;

import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.service.impl.LoginServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TreeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginServiceImpl loginService = new LoginServiceImpl();
        User user = loginService.login(username, password);
        List<Tree> list = user.getRoleList().get(0).getTreeList();
        request.setAttribute("list", list);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServiceImpl loginService = new LoginServiceImpl();
        User user = loginService.login("lzh", "lzh1234");
        List<Tree> list = user.getRoleList().get(0).getTreeList();

        Gson gson = new Gson();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(gson.toJson(list));
        out.flush();
        out.close();
    }
}
