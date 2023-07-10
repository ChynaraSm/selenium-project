package com.cydeo.tests.day09_review_javafaker_driverUtils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {


    @Test
    public void test1(){
    //create Java Faker oblect
        Faker faker =new Faker();
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        //print random last name
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        //print full name
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().city() = " + faker.address().city());


        System.out.println("faker.address().zipCodeByState(\"VA\") = " + faker.address().zipCodeByState("VA"));

        //numerify(0 method is used to generate digits with specific formatting
        //String randomNumber=faker.numerify("###-###-####");
       // System.out.println("randomNumber = " + randomNumber);

        System.out.println("faker.numerify(\"999-###-####\") = " + faker.numerify("999-###-####"));

        System.out.println("faker.letterify(\"???-???-????\") = " + faker.letterify("???-???-????"));

        //print letters and numbers
        System.out.println("faker.bothify(\"##/-???-####\") = " + faker.bothify("##/-???-####"));

        //chuckNorris method is used to create chuckNorris fact
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());

        System.out.println("faker.chuckNorris().fact().replaceAll(\"Chuck Norris\", \"Muhtar\") = " + faker.chuckNorris().fact().replaceAll("Chuck Norris", "Muhtar"));

    }
}
