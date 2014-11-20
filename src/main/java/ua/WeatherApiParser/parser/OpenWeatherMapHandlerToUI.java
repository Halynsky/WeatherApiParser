package ua.WeatherApiParser.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class OpenWeatherMapHandlerToUI extends DefaultHandler {

    Map<String, String> date = new HashMap<String, String>();
    String text = "";

    public Map<String, String> getDate() {
        return date;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.print("start parsing..." + "\n");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.print(date);
        System.out.println("\n" + "end parsing...");
    }

    @Override
    public void startElement(String nameSpaceURI, String localName, String qName, Attributes attr) throws SAXException {
        if (attr.getLength() != 0) {
            for (int i = 0; i < attr.getLength(); i++) {
                date.put(qName + "_" + attr.getQName(i), attr.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String nameSpaceURI, String localName, String qName) throws SAXException {
        text = text.replaceAll("\\n", "").replaceAll(" ", "");
        if (text == "") {
            date.put(qName, text);
        }
        text = "";
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        text = new String(ch, start, length);
    }
}
