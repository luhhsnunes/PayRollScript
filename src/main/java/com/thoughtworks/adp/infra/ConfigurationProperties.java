package com.thoughtworks.adp.infra;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationProperties {

    private final Properties configuration;

    public ConfigurationProperties(){
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("configuration.properties");
        configuration = new Properties();
        readFile(inputStream);
    }

    private void readFile(InputStream inputStream) {
        try {
            configuration.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read configuration file");
        }
    }

    public String getUser(){
        return configuration.getProperty("user");
    }

    public String getPassword(){
        return configuration.getProperty("password");
    }
}
