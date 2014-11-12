package ua.WeatherApiParser.util;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Properties;

public class WeatherParserUtil {

    String urlBeforeCity = "http://api.openweathermap.org/data/2.5/weather?q=";
    String urlAfterCity = "&mode=xml&units=metric";
    String city;


    public WeatherParserUtil() {
    }



    public String createUrl(String cityInUALenguage){

        System.out.println(cityInUALenguage);

        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src\\main\\resources\\WeatherParserProperties\\citiesVocabulary.properties");

            property.load(fis);
            city = property.getProperty("la");
            System.out.println(city);
        } catch (IOException e) {
            System.err.println("Error!!! File not found!");
        }


        StringBuilder sb = new StringBuilder(64);
        sb.append(urlBeforeCity).append(city).append(urlAfterCity);
        return sb.toString();
    }


    public static void main(String[] args) {
        WeatherParserUtil wpu = new WeatherParserUtil();
        System.out.println(wpu.createUrl("la"));
        System.out.println("Київ");

    }

}
