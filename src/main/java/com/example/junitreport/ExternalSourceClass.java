package com.example.junitreport;

import java.util.stream.Stream;

/**
 * @author Gohar Ohanyan. Created on 4/14/2022.
 */
public class ExternalSourceClass {
    static Stream<String> externalSource() {
        return Stream.of(".", "o.o", "oo", "...");
    }
}
