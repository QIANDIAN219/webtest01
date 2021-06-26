import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.impl.LoginDaoImpl;
import cn.edu.guet.service.impl.LoginServiceImpl;
import com.google.gson.Gson;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        LoginServiceImpl loginService = new LoginServiceImpl();
//        User user = loginService.getUser("lgl", "lgl1234");
//        List<Tree> list = user.getRoleList().get(0).getTreeList();
        List<Tree> list = loginService.getTrees("u1002");

        Gson gson = new Gson();
        System.out.println(gson.toJson(list));
    }


}
