package ua.WeatherApiParser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    @RequestMapping(value = "/")
    public String indexPage() {
        System.out.println("WeatherApiParser.controller!!!!!!!!!!!!!!!!!!");
        return "index";
    }

    @RequestMapping(value = "dateForWeatherParser", method = {RequestMethod.GET}, produces = "text/plain; charset=UTF-8" )
    public @ResponseBody String getDateForWeatherParser(
            @RequestParam(value = "city", required = true) String city) {
        System.out.println(city);
        return city;
    }
}
