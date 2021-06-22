package cn.edu.guet.servlet;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.impl.LoginDaoImpl;
import cn.edu.guet.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginServiceImpl loginService = new LoginServiceImpl();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String uri = request.getRequestURI();
        if(uri.contains("login1")) {
            User user = loginService.login(username, password);
            request.setAttribute("usernaem", username);
            response.sendRedirect("leftMenu?userid=" + user.getUserId());
        } else if(uri.contains("login2")) {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
