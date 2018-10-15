package com.work.vladimirs.DOM.DOM_1;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DOMExample {
    //List of employees from XML
    private static ArrayList<Employee> employees = new ArrayList<Employee>();

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        //Get factory in order to get docs builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //Get docs builder, which do parce XML and create structure DOCUMENT as hierarchical tree
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Parsed XML, We have an access to all elements
        Document document = builder.parse(new File("src/main/resources/info-in-attributes.xml"));

        //Get list of all elements EMPLOYEE inside root element
        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");

        //enumerations of all elements EMPLOYEE
        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);
            //Get all attributes every element
            NamedNodeMap attributes = employee.getAttributes();
            //Add employee into employees
            employees.add(new Employee(
                    attributes.getNamedItem("name").getNodeValue(),
                    attributes.getNamedItem("job").getNodeValue()));
        }

        for (Employee employee : employees) {
            System.out.println(
                    String.format(
                            "Информация о сотруднике: имя - %s, должность - %s",
                            employee.getName(),
                            employee.getJob()));
        }
    }
}
