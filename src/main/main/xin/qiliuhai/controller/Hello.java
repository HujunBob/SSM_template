package xin.qiliuhai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {
    @RequestMapping("/list")
    public ModelAndView say(){
        System.out.println("helloaaa");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("index");
        return  mv;
    }

}
