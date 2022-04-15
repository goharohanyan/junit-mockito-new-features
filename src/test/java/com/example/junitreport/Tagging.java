package com.example.junitreport;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class Tagging {

    @Test
    @Tag("excluded")
    void test14() {
        System.out.println("DemoTest.test14");
    }

    @Test
    @Tag("some-other-tag")
    void test15() {
        System.out.println("DemoTest.test15");
    }

    @Nested
    @Tag("excluded")
    class T2 {
        @Test
        void test151() {
            System.out.println("DemoTest.test151");
        }
    }
}
