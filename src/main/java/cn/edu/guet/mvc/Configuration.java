package cn.edu.guet.mvc;

import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class Configuration {
    public Map<String, ControllerMapping> config() throws URISyntaxException {
        Map<String, ControllerMapping> controllerMappingMap = new HashMap<String, ControllerMapping>();

        ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
        String controllerPackageName = resourceBundle.getString("controller.package");

        String path = controllerPackageName.replace(".", "/");
        URI uri = Configuration.class.getResource("/" + path).toURI();

        File controllerDirectory = new File(uri);
        String[] controllerFileName = controllerDirectory.list();

        for (String className : controllerFileName) {
            if (className.endsWith(".class")) {
                // 将包名与文件名结合形成路径(顺带删掉.class文件的文件后缀)
                String fullClassName = controllerPackageName + "." + StringUtils.substringBefore(className, ".class");
                try {
                    Class controllerClass = Class.forName(fullClassName);
                    // 找出哪些类上使用了Controller注解
                    if (controllerClass.isAnnotationPresent(Controller.class)) {
                        // 找出哪些方法使用了RequestMapping注解
                        Method methods[] = MethodUtils.getMethodsWithAnnotation(controllerClass, RequestMapping.class);
                        for (Method method : methods) {
                            // 获取到RequestMapping注解的值：值就是url，相当于原来的web.xml中的url-pattern中的内容
                            RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                            // ControllerMaping存储类和方法的Map
                            ControllerMapping mapping = new ControllerMapping(controllerClass, method);
                            // 将RequestMapping注解值(url)与ControllerMapping关联起来
                            controllerMappingMap.put(annotation.value(), mapping);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return controllerMappingMap;
    }

}

