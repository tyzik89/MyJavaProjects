package com.work.vladimirs.generation_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class GenerationExample {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = f.newDocumentBuilder();

        Document d = builder.newDocument();
        Element root = d.createElement("root");
        Element child = d.createElement("child");
        Text tn = d.createTextNode("someText");

        d.appendChild(root);
        root.appendChild(child);
        child.appendChild(tn);
        child.setAttribute("myattr", "myValue");

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.transform(new DOMSource(d), new StreamResult(new FileOutputStream(new File("src/main/java/com/work/vladimirs/generation_xml/result.xml"))));
    }
}
