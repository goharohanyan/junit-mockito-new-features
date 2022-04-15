package com.example.junitreport;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class ConditionalExecution {

    @Test
//    @EnabledOnOs(OS.WINDOWS)
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_18)
//    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_18)
//    @EnabledIf("internalCustomCondition")
//    @DisabledIf("internalCustomCondition")
//    @EnabledIf("com.example.java8springbootdemo.ExternalCustomCondition#customCondition")
    void test13(){}

    private boolean internalCustomCondition(){
        return false;
    }

}
