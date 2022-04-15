package com.example.junitreport.package2;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Gohar Ohanyan. Created on 4/14/2022.
 */
public class TestClass2 {

    @Test
    public void testCase2() {
        assertTrue(Math.round(Math.E) == 3);
        System.out.println("TestClass2.testCase2");
    }
}
