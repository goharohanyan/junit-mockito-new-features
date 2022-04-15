package com.example.junitreport;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class Timeout {

    @Test
    @org.junit.jupiter.api.Timeout(5)//seconds by default
//    @Timeout(value = 5, unit = TimeUnit.NANOSECONDS) //will throw exception
//    @Timeout(value = 5, unit = TimeUnit.DAYS)
    void test33() {
        long sum = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
    }

    @Test
    @org.junit.jupiter.api.Timeout(5)
    void test34() throws InterruptedException {
        Thread.sleep(1000);
    }

}
