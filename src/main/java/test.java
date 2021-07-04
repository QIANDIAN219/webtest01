import cn.edu.guet.bean.User;
import cn.edu.guet.service.impl.LoginServiceImpl;

import java.net.URISyntaxException;

public class test {
    public static void main(String[] args) throws URISyntaxException {
        LoginServiceImpl loginService = new LoginServiceImpl();
        User user = loginService.login("lzh", "lzh1234");
        System.out.println("userid:" + user.getUserId());

    }


}
