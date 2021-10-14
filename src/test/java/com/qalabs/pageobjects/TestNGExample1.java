package com.qalabs.pageobjects;

import org.testng.annotations.Test;
import org.testng.Assert;

public class TestNGExample1 {
    @Test
    public static void passTC(){
        Assert.assertEquals("Test", "Test");
    }

    @Test
    public static void failTC(){
        Assert.assertEquals("Test", "Fail");
    }
}
