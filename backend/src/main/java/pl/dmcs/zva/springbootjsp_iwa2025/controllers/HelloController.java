package pl.dmcs.zva.springbootjsp_iwa2025.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller

public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "hello";
    }
}
