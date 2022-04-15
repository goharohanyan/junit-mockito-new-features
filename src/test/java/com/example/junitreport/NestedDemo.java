package com.example.junitreport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class NestedDemo {

    List<String> list1;

    @Test
    @DisplayName("list is null")
    void isInstantiatedWithNew(){
        assertNull(list1);
    }

    @Nested
    @DisplayName("list is empty")
    class WhenNew {

        @BeforeEach
        void createNew(){
            list1 = new ArrayList<>();
        }

        @Test
        void getNonExistingElement() {
            assertThrows(IndexOutOfBoundsException.class, () -> list1.get(0));
        }

        @Nested
        @DisplayName("list is not empty")
        class AfterFillingData {

            String e = "first element";

            @BeforeEach
            void addAnElement(){
                list1.add(0, e);
            }

            @Test
            @DisplayName("is no longer empty")
            void checkIsEmpty() {
                assertFalse(list1.isEmpty());
            }

            @Test
            void checkSomeActions() {
                assertEquals(e,list1.get(0));
                list1.remove(0);
                assertTrue(list1.isEmpty());
            }
        }
    }

}
