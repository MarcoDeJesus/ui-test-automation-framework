package com.qalabs.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static final Logger logger = LogManager.getLogger(PropertyReader.class);
    private static final String rootPath = "src/main/resources/";

    public static String getProperty(String fileName, String name){
        Properties properties = new Properties();
        InputStream input = null;
        String propertyValue = null;

        try{
            input = new FileInputStream(rootPath + fileName);
            properties.load(input);
            propertyValue = properties.getProperty(name);
        }catch (IOException exception){
            logger.debug(exception.toString());
        }finally {
            closeInput(input);
            return propertyValue;
        }
    }

    private static void closeInput(InputStream input){
        try {
            input.close();
        } catch (IOException e) {
            logger.debug(e.getMessage());
            e.printStackTrace();
        }
    }
}
