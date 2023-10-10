package com.work.vladimirs.validate_xmlschema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLUtils {

    /**
     * This method validate XML by input XML as String and XSD path to File.
     *
     * @param xml input XML as String
     * @param xsdPath input XSD File Path
     * @return true or false, valid or not
     */
    public static boolean validateXMLByXSD(String xml, String xsdPath) throws SAXException, IOException {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(new File(xsdPath))
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method validate XML by input XML as String and XSD File.
     *
     * @param xml input XML as String
     * @param xsd input XSD File
     * @return true or false, valid or not
     */
    public static boolean validateXMLByXSD(String xml, File xsd) throws SAXException, IOException {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method validate XML by XML File and XSD File.
     *
     * @param xml input XML File
     * @param xsd input XSD File
     * @return true or false, valid or not
     */
    public static boolean validateXMLByXSD(File xml, File xsd) throws SAXException, IOException {
        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator()
                    .validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method validate XML by input XML as String and XSD path to File.
     * You'll get full list of exceptions, but if one fatal error occurs, the parsing stops
     *
     * @param xml input XML as String
     * @param xsdPath input XSD File Path
     * @return error list
     */
    public static List<Exception> validateXMLByXSDAndGetErrors(String xml, String xsdPath) throws SAXException, IOException {
        List<Exception> exceptions = new ArrayList<Exception>();
        try {
            Validator validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(new File(xsdPath))
                    .newValidator();
            validator.setErrorHandler(new XSDValidatorErrorHandler(exceptions));
            validator.validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exceptions;
    }

    /**
     * This method validate XML by input XML as String and XSD File.
     * You'll get full list of exceptions, but if one fatal error occurs, the parsing stops
     *
     * @param xml input XML as String
     * @param xsd input XSD File
     * @return error list
     */
    public static List<Exception> validateXMLByXSDAndGetErrors(String xml, File xsd) throws SAXException, IOException {
        List<Exception> exceptions = new ArrayList<Exception>();
        try {
            Validator validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator();
            validator.setErrorHandler(new XSDValidatorErrorHandler(exceptions));
            validator.validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exceptions;
    }

    /**
     * This method validate XML by XML File and XSD File.
     * You'll get full list of exceptions, but if one fatal error occurs, the parsing stops
     *
     * @param xml input XML File
     * @param xsd input XSD File
     * @return error list
     */
    public static List<Exception> validateXMLByXSDAndGetErrors(File xml, File xsd) throws SAXException, IOException {
        List<Exception> exceptions = new ArrayList<Exception>();
        try {
            Validator validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI)
                    .newSchema(xsd)
                    .newValidator();
            validator.setErrorHandler(new XSDValidatorErrorHandler(exceptions));
            validator.validate(new StreamSource(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exceptions;
    }
}
