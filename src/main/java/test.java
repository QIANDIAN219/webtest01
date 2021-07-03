import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.impl.LoginDaoImpl;
import cn.edu.guet.filter.ConnectionFilter;
import cn.edu.guet.mvc.Configuration;
import cn.edu.guet.service.impl.LoginServiceImpl;
import com.google.gson.Gson;

import java.io.File;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class test {
    public static void main(String[] args) throws URISyntaxException {

        /*LoginServiceImpl loginService = new LoginServiceImpl();
//        User user = loginService.getUser("lgl", "lgl1234");
//        List<Tree> list = user.getRoleList().get(0).getTreeList();
        List<Tree> list = loginService.getTrees("u1002");

        Gson gson = new Gson();
        System.out.println(gson.toJson(list));*/
/*        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        String controllerPackageName = resourceBundle.getString("controller.package");

        String path = controllerPackageName.replace(".", "/");
        URI uri = Configuration.class.getResource("/" + path).toURI();

        File controllerDirectory = new File(uri);
        String[] controllerFileName = controllerDirectory.list();
        for(String className : controllerFileName) {
            if(className.endsWith(".class")) {
                String fullClassName = controllerPackageName + "." + className.substring(0, className.lastIndexOf(".class"));
                System.out.println(fullClassName);
            }
        }*/
    }


}
