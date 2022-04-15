package com.example.junitreport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
@Tag("class-tag")
@Tag("xxxTag")
@DisplayName("Class display name")
public class DependencyInjection {

    DependencyInjection(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        if (testInfo.getTestMethod().isPresent() ){
            System.out.println(testInfo.getTestMethod().get());
        }
        if (testInfo.getTestClass().isPresent() ){
            System.out.println(testInfo.getTestClass().get());
        }
        System.out.println(testInfo.getTags());
    }

    @Test
    @Tag("method-tag")
    @DisplayName("method display name")
    void test16(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
        if (testInfo.getTestMethod().isPresent() ){
            System.out.println(testInfo.getTestMethod().get());
        }
        if (testInfo.getTestClass().isPresent() ){
            System.out.println(testInfo.getTestClass().get());
        }
        System.out.println(testInfo.getTags());
    }

}
