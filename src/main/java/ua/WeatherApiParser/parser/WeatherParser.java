package ua.WeatherApiParser.parser;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import ua.WeatherApiParser.util.WeatherParserUtil;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.URL;
import java.util.Map;


public class WeatherParser {

    public Map<String, String> parse(String city) {

        Map<String, String> result;

        WeatherParserUtil weatherParserUtil = new WeatherParserUtil();
        String url = weatherParserUtil.createUrl(city);
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        OpenWeatherMapHandlerToConsole handlerToConsole = new OpenWeatherMapHandlerToConsole();
        OpenWeatherMapHandlerToUI handlerToUI = new OpenWeatherMapHandlerToUI();

        try {
            SAXParser saxParser = parserFactory.newSAXParser();
//            saxParser.parse(new InputSource(new URL(url).openStream()), handlerToConsole);
            System.out.println("==========================================================================================");
            saxParser.parse(new InputSource(new URL(url).openStream()), handlerToUI);
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return handlerToUI.getDate();
    }


    // TEST!
    public static void main(String[] args) {

        WeatherParser weatherParser = new WeatherParser();
        weatherParser.parse("Київ");
    }
}
