package com.work.vladimirs.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SAXExample {
    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        //==============================================================================================================
        XMLHandler handler = new XMLHandler();
        parser.parse(new File("src/main/resources/info-in-attributes.xml"), handler);

        for (Employee employee : employees) {
            System.out.println(String.format("Имя сотрудника: %s, должность: %s", employee.getName(), employee.getJob()));
        }
        //==============================================================================================================

        System.out.println("\n -------------Второй файл---------- \n");
        employees.clear();

        //==============================================================================================================
        AdvancedXMLHandler advancedHandler = new AdvancedXMLHandler();
        parser.parse(new File("src/main/resources/info-in-elements.xml"), advancedHandler);

        for (Employee employee : employees) {
            System.out.println(String.format("Имя сотрудника: %s, должность: %s", employee.getName(), employee.getJob()));
        }
        //==============================================================================================================
    }

    private static class XMLHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("employee")) {
                String name = attributes.getValue("name");
                String job = attributes.getValue("job");
                employees.add(new Employee(name, job));
            }
        }
    }

    private static class AdvancedXMLHandler extends DefaultHandler {
        private String name, job, lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String info = new String(ch, start, length);
            info = info.replace("\n", "").trim();

            if(!info.isEmpty()) {
                if (lastElementName.equals("name"))
                    name = info;
                if (lastElementName.equals("job"))
                    job = info;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ((name != null && !name.isEmpty()) && (job != null && !job.isEmpty()) ) {
                employees.add(new Employee(name, job));
                name = null;
                job = null;
            }
        }
    }
}
