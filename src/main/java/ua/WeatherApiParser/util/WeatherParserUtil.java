package ua.WeatherApiParser.util;


import java.io.*;
import java.util.Properties;

public class WeatherParserUtil {

    String urlBeforeCity = "http://api.openweathermap.org/data/2.5/weather?q=";
    String urlAfterCity = "&mode=xml&units=metric";
    String city;


    public WeatherParserUtil() {
    }

    public String createUrl(String cityInUALenguage){

        Properties properties = new Properties();
        try {
            InputStream inputStream =	this.getClass().getResourceAsStream("/WeatherParserProperties/citiesVocabulary.properties");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            properties.load(new InputStreamReader(bufferedInputStream, "UTF8"));

//            properties.load(new InputStreamReader(new FileInputStream("src\\main\\resources\\WeatherParserProperties\\citiesVocabulary.properties"), "UTF8"));

            city = properties.getProperty(cityInUALenguage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuilder sb = new StringBuilder(64);
        sb.append(urlBeforeCity).append(city).append(urlAfterCity);
        return sb.toString();
    }

}
