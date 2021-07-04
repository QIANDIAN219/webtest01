package cn.edu.guet.mvc;

import com.google.gson.GsonBuilder;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    Map<String, ControllerMapping> controllerMappingMap;

    @Override
    public void init(ServletConfig config) throws ServletException {
        controllerMappingMap = (Map<String, ControllerMapping>) config.getServletContext().getAttribute("cn.edu.guet.controller");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String uri = request.getRequestURI();
            uri = uri.substring(uri.indexOf("/", 1) + 1);
            ControllerMapping controllerMapping = null;
            if (controllerMapping == null) {
                controllerMapping = controllerMappingMap.get(uri);
            }
            Class controllerMappingClass = controllerMapping.getControllerClass();
            Method controllerMappingMethod = controllerMapping.getHandleMethod();
            Class[] parameterType = controllerMappingMethod.getParameterTypes();  // 参数类型
            Parameter[] parameters = controllerMappingMethod.getParameters();  // 参数
            Object[] parametersValues = new Object[parameterType.length];  // 参数值

            for (int i = 0; i < parameterType.length; i++) {
                if (parameterType[i].isPrimitive()) {
                    if (parameterType[i].getTypeName().equals("int")) {
                        parametersValues[i] = Integer.parseInt(request.getParameter(parameters[i].getName()));
                    } else if(parameterType[i].getTypeName().equals("short")) {

                    }
                } else if (ClassUtils.isAssignable(parameterType[i], String.class)) {
                    parametersValues[i] = request.getParameter(parameters[i].getName());
                } else {
                    // Bean
                    Object pojo = parameterType[i].newInstance();
                    //得到请求里所有的参数：Map<参数名, value>
                    //获取表单里的数据
                    Map<String, String[]> parameterMap = request.getParameterMap();
                    //beanutils会自动将map里的key与bean的属性名进行反射赋值
                    BeanUtils.populate(pojo, parameterMap);
                    parametersValues[i] = pojo;
                }
            }

            Object obj = controllerMappingClass.newInstance();  // 实例化
            Object returnValue = controllerMappingMethod.invoke(obj, parametersValues);//调用方法处理请求即可
            if (returnValue != null && returnValue instanceof String) { //方法返回的是一个字符串类
                String path = returnValue.toString();
                if (((String) returnValue).startsWith("forward:")) {
                    request.getRequestDispatcher(StringUtils.substringAfter(path, "forward:")).forward(request, response);
                } else if (((String) returnValue).startsWith("redirect:")) {
                    response.sendRedirect(StringUtils.substringAfter(path, "redirect:"));
                }
            } else if (returnValue != null && !(returnValue instanceof String)) {
                response.setContentType("application/json; charset=UTF-8");
                //返回的是一个bean，即客户端发送的是ajax请求，并将该bean转换成json
                String json = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .setPrettyPrinting()
                        .create()
                        .toJson(returnValue);
                PrintWriter out = response.getWriter();
                out.write(json);
                out.flush();
                out.close();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
