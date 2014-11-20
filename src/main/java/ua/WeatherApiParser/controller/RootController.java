package ua.WeatherApiParser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.WeatherApiParser.parser.WeatherParser;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RootController {

    @RequestMapping(value = "/")
    public String indexPage() {
        System.out.println("WeatherApiParser.controller!!!!!!!!!!!!!!!!!!");
        return "index";
    }

    @RequestMapping(value = "dateForWeatherParser", method = {RequestMethod.GET})
    public @ResponseBody Map<String,String> getDateForWeatherParser(
            @RequestParam(value = "city", required = true) String city) {

        WeatherParser weatherParser = new WeatherParser();
        return weatherParser.parse(city);
    }
}
