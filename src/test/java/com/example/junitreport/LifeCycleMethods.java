package com.example.junitreport;

import org.junit.jupiter.api.*;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class LifeCycleMethods {

    @BeforeAll
    public static void initAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void init() {
        System.out.println("@BeforeEach");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("@AfterAll");
    }

    @Test
    void test0() {
        System.out.println("test0 is running...");
    }

    @Test
    void test1() {
        System.out.println("test1 is running...");
    }

}
