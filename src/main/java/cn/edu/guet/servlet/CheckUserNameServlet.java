package cn.edu.guet.servlet;

import cn.edu.guet.bean.Result;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CheckUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        Gson gson=new Gson();
        if(username.equals("test")) {
            Result result=new Result("disable");
            System.out.println(gson.toJson(result));
            out.write(gson.toJson(result));
        }else{
            Result result=new Result("enable");
            System.out.println(gson.toJson(result));
            out.write(gson.toJson(result));
        }
        out.flush();
        out.close();


        /*response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        System.out.println(username);
        if(username.equals("test")) {

            out.write("用户名可用");
        } else {
            out.write("用户名不可用");    //把结果发送给客户端
        }
        out.flush();
        out.close();*/
    }
}
