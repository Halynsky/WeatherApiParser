package ua.WeatherApiParser.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class OpenWeatherMapHandlerToConsole extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException{
        System.out.println("start parsing...output to console");
    }

    @Override
    public void endDocument() throws SAXException{
        System.out.println("\n"+"end parsing...");
    }

    @Override
    public void startElement(String nameSpaceURI, String localName, String qName, Attributes attr) throws SAXException{
        String str ="<" + qName ;

        for (int i = 0; i <attr.getLength() ; i++) {
            str+=" " + attr.getQName(i) + "=" + attr.getValue(i);
        }
        str+=">";
        System.out.print(str);

    }

    @Override
    public void endElement(String nameSpaceURI, String localName, String qName) throws SAXException{
        System.out.print("</" + qName +">");

    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        System.out.print(str);
    }
}
