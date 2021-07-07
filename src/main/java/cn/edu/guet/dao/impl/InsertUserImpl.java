package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IInsertDao;
import cn.edu.guet.filter.ConnectionFilter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUserImpl implements IInsertDao {
    @Override
    public void insertUser(User user) {
        Connection connection = ConnectionFilter.getConnection();

        String sql = null;
        PreparedStatement preparedStatement = null;

        try {
            sql = "INSERT INTO tb_user VALUES(?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserId());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getRealName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getState());
            preparedStatement.setTimestamp(7, user.getCreateTime());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
