package com.example.junitreport.package3;


import com.example.junitreport.package2.TestClass2;
import com.example.junitreport.paskage1.TestClass1;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Gohar Ohanyan. Created on 4/14/2022.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestClass1.class,
        TestClass2.class
})
public class ThirdPartyTestClass {
//    @Test
//    void test() {
//        System.out.println("ThirdPartyTestClass.test");
//    }
}
