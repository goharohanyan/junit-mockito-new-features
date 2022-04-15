package com.example.junitreport.paskage1;


import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

/**
 * @author Gohar Ohanyan. Created on 4/14/2022.
 */
public class TestClass1 {

    @Test
    @DisplayName(value = "test case 1")
    public void testCase1() {
        assertEquals(45, 5 * 9);
        System.out.println("TestClass1.testCase1");
    }
}
