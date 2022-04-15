package com.example.junitreport;

import org.junit.jupiter.api.*;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
//Test method execution order
//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodExecutionOrder {

    @Test
    @DisplayName("(:/)")
    @Order(3)
    void test9() {
    }

    @Test
    @Order(2)
    void test10() {
    }

    @Test
    @Order(1)
    void test11() {
    }

    @Test
    @DisplayName("*_*")
    @Order(4)
    void test12() {
    }
}
