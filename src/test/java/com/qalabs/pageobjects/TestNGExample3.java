package com.qalabs.pageobjects;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGExample3 {

    @Test(groups = {"brokenTests"})
    public void brokenTest(){
        Assert.assertTrue(false);
    }

    @Test
    public void testMethod(){
        Assert.assertTrue(true);
    }
}
