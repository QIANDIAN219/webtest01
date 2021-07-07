package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Log;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.dao.ILogDao;
import cn.edu.guet.filter.ConnectionFilter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LogDao implements ILogDao {
    @Override
    public void insertLog(Log log) {
        Connection connection = ConnectionFilter.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = null;
        try {
            sql = "INSERT INTO sys_log VALUES(?, ?, ?, ? ,? ,?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, log.getId());
            preparedStatement.setString(2, log.getUser_name());
            preparedStatement.setString(3, log.getOperation());
            preparedStatement.setString(4, log.getMethod());
            preparedStatement.setString(5, log.getParams());
            preparedStatement.setInt(6, log.getTime());
            preparedStatement.setString(7, log.getIp());
            preparedStatement.setString(8, log.getCreate_by());
            preparedStatement.setTimestamp(9, log.getCreate_time());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
