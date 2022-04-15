package com.example.junitreport;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class Assertions {

    List list;
    @Test
    void test2() {
        assertFalse(Math.PI == 3.14);
        assertTrue(Math.PI > 3.14);

        assertNull(list);

        list = Arrays.asList(1, 5, 6);
        assertNotNull(list);

        assertEquals(3, Math.floor(Math.PI));
        assertEquals("true", (Math.floor(Math.PI) == 3) + "");
//        assertEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}); //will throw exception

        assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        assertIterableEquals(list, Arrays.asList(1, 5, 6));
        assertIterableEquals(Arrays.asList("1", "5", "6"), Arrays.asList("1", "5", "6"));

        assertLinesMatch(Arrays.asList("1\n asd", "5", "6"), Arrays.asList("1\n asd", "5", "6"), "boooom!!!");

        assertNotEquals("1\r", "1");
        assertNotEquals(15 / 3, 5.3);

        List l = list;
        assertSame(l, list);

        assertNotSame(list, Arrays.asList(1, 5, 6));

        assertAll(
                () -> assertNotEquals(4, 6),
                () -> assertEquals(3, Math.ceil(Math.E)),
                () -> assertArrayEquals(new int[]{1, 2}, new int[]{1, 2})
        );

        assertThrowsExactly(ArithmeticException.class, () -> dummyMethod(0));
//        assertThrowsExactly(IOException.class, () -> dummyMethod(1)); //wil throw exception

        assertThrows(IOException.class, () -> dummyMethod(1));
        assertThrows(FileNotFoundException.class, () -> dummyMethod(1));

        assertDoesNotThrow(() -> dummyMethod(156));

        assertTimeout(Duration.ofHours(1), () -> dummyMethod(2));
//        assertTimeout(Duration.ofNanos(1), () -> dummyMethod(2)); //will throw exception

        assertTimeoutPreemptively(Duration.ofHours(1), () -> dummyMethod(2));

        assertInstanceOf(Object.class, "asd");
        assertInstanceOf(IOException.class, new FileNotFoundException());
        assertInstanceOf(FileNotFoundException.class, new FileNotFoundException());
    }

    private void dummyMethod(int num) throws Exception {
        if (num == 0) {
            throw new ArithmeticException("for some reason");
        }
        if (num == 1) {
            throw new FileNotFoundException("for some reason");
        }
        if (num == 2) {
            int sum = 0;
            for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
                sum += i;
            }
        }
    }

}
