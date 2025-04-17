package org.example;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class CommonsConfigurationAttack {

    public static void main(String[] args) throws ConfigurationException {
        Configurations configs = new Configurations();

        Configuration config = configs.properties("config.properties");
        String value = config.getString("property");
        System.out.println("Interpolated property: " + value);
    }
}

