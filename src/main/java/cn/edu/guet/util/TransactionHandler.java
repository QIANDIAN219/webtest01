package cn.edu.guet.util;

import cn.edu.guet.bean.Log;
import cn.edu.guet.filter.ConnectionFilter;
import cn.edu.guet.service.ILogService;
import cn.edu.guet.service.impl.LogServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class TransactionHandler implements InvocationHandler {

    private Object targetObject;
    private Log log;

    public Object createProxyObject(Object targetObject, Log log) {
        this.targetObject = targetObject;
        this.log = log;
        /**
         *  getClassLoader:类加载器 getInterfaces:接口
         *  代理对象的接口必须和目标对象的接口一致
         *  拿到目标对象接口，好让代理对象也实现同样的接口
         */
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Connection connection = ConnectionFilter.getConnection();
        ILogService logService = new LogServiceImpl();
        Object retVal = null;
        try {
            if(method.getName().startsWith("insert")) {
                connection.setAutoCommit(false);  // 关闭自动提交
                retVal = method.invoke(targetObject, args);  // 目标方法
                logService.insertLog(log);
                connection.commit();
            } else {
                retVal = method.invoke(targetObject, args);  // 目标方法
            }
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        }
        return retVal;
    }
}
