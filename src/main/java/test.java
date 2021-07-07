import cn.edu.guet.bean.User;
import cn.edu.guet.service.impl.InsertServiceImpl;

import java.net.URISyntaxException;
import java.sql.Timestamp;

public class test {
    public static void main(String[] args) throws URISyntaxException {
        /*ILogDao logDao = new LogDao();
        Log log = new Log();
        log.setId(1111);
        log.setUser_name("蓝振洪");
        log.setOperation("添加用户");
        log.setMethod("insertUser");
        log.setParams("U1001 王五");
        log.setTime(1);
        log.setIp("192.168.1.121");
        log.setCreate_by("lzh");
        log.setCreate_time(new Timestamp(System.currentTimeMillis()));
        logDao.insertLog(log);*/
        User user  = new User();
        user.setUserId("u1005");
        user.setUserName("ww");
        user.setPassword("ww1234");
        user.setRealName("王五");
        user.setEmail("test@qq.com");
        user.setState("0");
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        InsertServiceImpl insertService = new InsertServiceImpl();
        insertService.insertUser(user);

    }


}
