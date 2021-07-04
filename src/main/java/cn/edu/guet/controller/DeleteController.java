package cn.edu.guet.controller;

import cn.edu.guet.mvc.annotation.Controller;
import cn.edu.guet.mvc.annotation.RequestMapping;

@Controller
public class DeleteController {
    @RequestMapping("deleteTest.do")
    public void deleteTest() {
        System.out.println("Delete");
    }
}
