package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.ILoginDao;
import cn.edu.guet.dao.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements ILoginDao {
    @Override
    public User login(String username, String password) {
        Connection connection = JDBC.ConnectionOfMySQL();
        String sql = "SELECT * FROM tb_user WHERE username=? AND password=?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getString("USERID"));
                user.setUserName(resultSet.getString("USERNAME"));
                user.setRealName(resultSet.getString("REALNAME"));

                sql = "SELECT r.* FROM tb_role r, tb_user_role ur WHERE ur.roleid=r.roleid AND ur.userid=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getUserId());
                preparedStatement.execute();
                resultSet = preparedStatement.getResultSet();
                while(resultSet.next()) {
                    Role role = new Role();
                    role.setRoleId(resultSet.getString("ROLEID"));
                    role.setRoleName(resultSet.getString("ROLENAME"));
                    user.getRoleList().add(role);
                }

                sql = "SELECT tree.* FROM tb_role_permission rp, tb_tree tree WHERE tree.treeid=rp.treeid AND rp.roleid=?";
                preparedStatement = connection.prepareStatement(sql);
                for(Role role : user.getRoleList()) {
                    preparedStatement.setString(1, role.getRoleId());
                    preparedStatement.execute();
                    resultSet = preparedStatement.getResultSet();
                    while(resultSet.next()) {
                        Tree tree = new Tree();
                        tree.setTreeId(resultSet.getString("TREEID"));
                        tree.setParentId(resultSet.getString("PARENTID"));
                        tree.setTitle(resultSet.getString("TITLE"));
                        tree.setUrl(resultSet.getString("URL"));
                        tree.setIsParent(resultSet.getString("ISPARENT"));
                        role.getTreeList().add(tree);
                    }
                }
                return user;
            } else {

            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
