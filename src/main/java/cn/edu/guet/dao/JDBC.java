package cn.edu.guet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static Connection ConnectionOfOracle() {
        Connection connection = null;
        String url = "jdbc:oracle:thin:@192.168.235.129:1521:orcl";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, "lzh", "lzh1234");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public static Connection ConnectionOfMySQL() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/myweb?useUnicode=true&characterEncoding=gbk";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, "lzh", "lzh1234");
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
