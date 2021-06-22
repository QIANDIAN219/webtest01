import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.impl.LoginDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        LoginDaoImpl loginDao = new LoginDaoImpl();
        User user = loginDao.login("lgl", "lgl1234");
        System.out.println(loginDao.getTrees("u1002").get(0).getTitle());

    }


}
