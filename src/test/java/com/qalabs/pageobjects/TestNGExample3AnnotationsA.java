package com.qalabs.pageobjects;

import org.testng.annotations.*;

public class TestNGExample3AnnotationsA extends TestNGExample3AnnotationsParent{
    @BeforeClass
    public void beforeClassA(){
        System.out.println("Before Class - 3_A");
    }

    @AfterClass
    public void afterClassA(){
        System.out.println("After Class - 3_A");
    }

    @Test(groups = {"3_A"}, priority=0)
    public void test1A(){
        System.out.println("TEST1 - 3_A");
    }

    @Test(groups = {"3_A"}, priority=1)
    public void test2A(){
        System.out.println("TEST2 - 3_A");
    }

    @Test(groups = {"3_A"}, priority=2)
    public void test3A(){
        System.out.println("TEST3 - 3_A");
    }

}