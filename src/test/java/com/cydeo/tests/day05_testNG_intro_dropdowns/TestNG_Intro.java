package com.cydeo.tests.day05_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
    @BeforeClass
    public void setupClass(){
        System.out.println("----Before class is running!!!");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("----->After class is running !!! ");
    }

    @BeforeMethod
    public void setupMethod(){
        System.out.println("Before method is running..");
    }

    @Test (priority=2)
    public void test1(){
        String actual="apple";
        String expected="apple";

        System.out.println("Test 1 is running....................");
        Assert.assertEquals(actual,expected);

    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Method is running");
    }

    @Test (priority=1)
    public void test2(){

        System.out.println("Test 2 is running........");
        String actual="white";
        String expected="white";
        Assert.assertTrue(actual.equals(expected));
    }




}
