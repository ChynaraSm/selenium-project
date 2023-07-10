package com.cydeo.tests.day09_review_javafaker_driverUtils;

public class Singleton {

    //#1-create private constructor

    private Singleton(){}


    //#2-private static String
    private static String word;//by default word is null


    //#3-utility method return the private String we just created
    public static String getWord(){
        if (word==null){
            System.out.println("First time call . word object is null");
            System.out.println("Assigning value to it now");
            word="something";
        }else{
            System.out.println("Word already has a value");
        }
        return word;

    }



}
