package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /*
    In this class, we will be creating the re-usable logic to read from configuration. properties file
     */

    //1-Create properties object
        //make it private so it is not accessible from outside of the class
        //static is to make sure its created and loaded before everything else
    private static Properties properties=new Properties();

    static{



        try {
            //2-Open file using FileInputStream
            FileInputStream file=new FileInputStream("configuration.properties");

            //3-Load the properties object with file
            properties.load(file);

            //CLOSE THE FILE IN THE MEMORY
            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!");
            e.printStackTrace();

        }

    }
    //create utility method to use the object to read
    //4-Use "properties' object to read from the file (read properties)

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }




}