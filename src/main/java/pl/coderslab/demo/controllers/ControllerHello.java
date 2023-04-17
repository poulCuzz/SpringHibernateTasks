package pl.coderslab.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHello {
    @RequestMapping(value = "/")
    public String hello() {
        return "hello";
    }
}
