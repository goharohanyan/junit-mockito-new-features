package com.example.junitreport;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class RepeatedTestDemo {

    @org.junit.jupiter.api.RepeatedTest(12)
    void test17(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println(String.format("%s : %d / %d", testInfo.getDisplayName(), repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions()));
    }
}
