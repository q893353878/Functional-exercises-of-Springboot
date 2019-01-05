package com.st.beetl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * @ClassName BeetlController
 * @Description TODO
 * @Author administrator
 * @Date 2019/1/4 0004 上午 10:38
 * @Version 1.0
 **/
@Controller
public class BeetlController {

    @GetMapping("/beetl/test")
    public ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/view/ceshi.html");
        modelAndView.addObject("list",Arrays.asList("Oh ","My ","God"));
        return modelAndView;
    }

    @GetMapping("/beetl/login")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/view/ceshi.html");
        modelAndView.addObject("list",Arrays.asList("a","b","c"));
        return modelAndView;
    }
}
