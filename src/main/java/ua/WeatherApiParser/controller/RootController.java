package ua.WeatherApiParser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping(value = "/")
    public String indexPage() {
        System.out.println("WeatherApiParser.controller!!!!!!!!!!!!!!!!!!");
        return "index";
    }

    @RequestMapping(value = "test")
    public String indexPageTest() {
        System.out.println("WeatherApiParser!!!!!!!!!!!!!!!!!!");
        return "index";
    }

}
