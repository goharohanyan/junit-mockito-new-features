package com.example.junitreport;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class Disable {

    @Test
    @Disabled
    void test8(){
        System.out.println("test will ignored");
    }
}
