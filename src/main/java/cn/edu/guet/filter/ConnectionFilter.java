package cn.edu.guet.filter;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFilter implements Filter {
    public static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);  // 访问目标资源
        /*// 访问目标资源前
        Connection connection = threadLocal.get();
        try {
            //String url = "jdbc:oracle:thin:@192.168.235.129:1521:orcl";
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=gbk";
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null) {
                connection = DriverManager.getConnection(url, "lzh", "lzh1234");
                threadLocal.set(connection);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        chain.doFilter(req, resp);  // 访问目标资源

        // 访问目标资源后
        threadLocal.remove();
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public static Connection getConnection() {
        return ConnectionFilter.threadLocal.get();
    }
}
