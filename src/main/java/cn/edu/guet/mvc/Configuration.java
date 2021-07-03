package cn.edu.guet.mvc;

import cn.edu.guet.mvc.annotation.Controller;

import java.io.File;
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
        for(String className : controllerFileName) {
            if(className.endsWith(".class")) {
                String fullClassName = controllerPackageName + "." + className.substring(0, className.lastIndexOf(".class"));
                try {
                    Class controllerClass = Class.forName(fullClassName);
                    if(controllerClass.isAnnotationPresent(Controller.class)) {

                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return controllerMappingMap;
    }

}

