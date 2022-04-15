package com.example.junitreport;

import org.junit.jupiter.api.*;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
//@TestClassOrder(ClassOrderer.ClassName.class)
//@TestClassOrder(ClassOrderer.DisplayName.class)
@TestClassOrder(ClassOrderer.Random.class)
//@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class ClassExecutionOrder {

    @Nested
    @DisplayName("display-name-order2")
    @Order(2)
    class T {

        @Test
        void test121(){}

        @Test
        void test123(){}
    }

    @Nested
    @DisplayName("display-name-order3")
    @Order(3)
    class T1 {

        @Test
        void test1211(){}
    }

    @Nested
    @Order(1)
    class T0 {

        @Test
        void test1211(){}
    }
}
