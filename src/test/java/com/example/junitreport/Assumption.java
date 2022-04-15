package com.example.junitreport;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class Assumption {

    @Test
    void test3() {
        assumeTrue(Math.round(Math.E) == Math.round(Math.PI));

        assumeFalse("test string".equals("some other string"));

        assumingThat(Math.E < 2.7, () -> {
            System.out.println("This will not print.");
        });
        assumingThat(Math.E < 2.8, () -> {
            System.out.println("This will be printed.");
        });
        assumingThat(
                () -> Math.E < 2.8,
                () -> System.out.println("This will be printed at second time.")
        );
    }

    @Test
    void test4() {
        assumeFalse(4 < 9);
    }  //will ignored

    @Test
    void test5() {
        assumeTrue(true);
    }

    @Test
    void test6() {
        assertTrue(4 > 9);
    } //will failed

    @Test
    void test7() {
        assertTrue(true);
    }
}
