package com.work.vladimirs.validate_xmlschema;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainValidation {

    public static void main(String[] args) throws IOException, SAXException {
        List<Exception> exceptions = XMLUtils.validateXMLByXSDAndGetErrors(
                new File("src/main/java/com/work/vladimirs/validate_xmlschema/user.xml"),
                new File("src/main/java/com/work/vladimirs/validate_xmlschema/user.xsd"));
        String xmlErrors = "\n";
        for (Exception e : exceptions) {
            xmlErrors += "XML Error: " + e.getMessage() + "\n";
        }

        System.out.println(xmlErrors);
    }
}
