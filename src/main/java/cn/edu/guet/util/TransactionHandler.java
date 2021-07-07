package cn.edu.guet.util;

import cn.edu.guet.bean.Log;
import cn.edu.guet.dao.ILogDao;
import cn.edu.guet.dao.impl.LogDao;
import cn.edu.guet.filter.ConnectionFilter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.Timestamp;

public class TransactionHandler implements InvocationHandler {

    private Object targetObject;

    public Object createProxyObject(Object targetObject) {
        this.targetObject = targetObject;
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
        Object retVal = null;
        try {
            if(method.getName().startsWith("insert")) {
                connection.setAutoCommit(false);  // 关闭自动提交
                retVal = method.invoke(targetObject, args);  // 目标方法
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
