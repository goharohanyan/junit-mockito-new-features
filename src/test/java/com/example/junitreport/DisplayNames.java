package com.example.junitreport;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
 @IndicativeSentencesGeneration(separator = " -> ", generator = DisplayNameGenerator.ReplaceUnderscores.class)
public class DisplayNames {

    @Nested
//    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
//    @DisplayNameGeneration(DisplayNameGenerator.Standard.class)
//    @DisplayNameGeneration(DisplayNameGenerator.Simple.class)
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {
        }

        @DisplayName("A negative value for year is not supported by the leap year computation\uD83D\uDE31.")
        @ParameterizedTest(name = "For example, year {0} is not supported ╯°□°）╯.")
        @ValueSource(ints = {1, -4})
        void if_it_is_negative(int year) {
            assertTrue(year > 0);
        }
    }

}
