package com.qalabs.pageobjects;

import org.testng.annotations.*;

public class TestNGExample3AnnotationsParent{
    @BeforeSuite(groups = {"3_A"})
    public void beforeSuiteA(){
        System.out.println("Before Suite - 3_A");
    }

    @BeforeTest(groups = {"3_A"})
    public void beforeTestA(){
        System.out.println("Before Test - 3_A");
    }

    @BeforeMethod(onlyForGroups = {"3_A"}, groups = {"3_A"})
    public void beforeMethodA(){
        System.out.println("Before Method - 3_A");
    }

    @AfterMethod(onlyForGroups = {"3_A"}, groups = {"3_A"})
    public void afterMethodA(){
        System.out.println("After Method - 3_A");
    }

    @AfterTest(groups = {"3_A"})
    public void afterTestA(){
        System.out.println("After Test - 3_A");
    }

    @AfterSuite(groups = {"3_A"})
    public void afterSuiteA(){
        System.out.println("After Suite - 3_A");
    }

    @BeforeSuite(groups = {"3_B"})
    public void beforeSuiteB(){
        System.out.println("Before Suite - 3_B");
    }

    @BeforeTest(groups = {"3_B"})
    public void beforeTestB(){
        System.out.println("Before Test - 3_B");
    }

    @BeforeMethod(onlyForGroups = {"3_B"}, groups = {"3_B"})
    public void beforeMethodB(){
        System.out.println("Before Method - 3_B");
    }

    @AfterMethod(onlyForGroups = {"3_B"}, groups = {"3_B"})
    public void afterMethodB(){
        System.out.println("After Method - 3_B");
    }

    @AfterTest(groups = {"3_B"})
    public void afterTestB(){
        System.out.println("After Test - 3_B");
    }

    @AfterSuite(groups = {"3_B"})
    public void afterSuiteB(){
        System.out.println("After Suite - 3_B");
    }

}
