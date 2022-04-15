package com.example.junitreport;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Gohar Ohanyan. Created on 4/15/2022.
 */
public class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = {"december", "January", "february"}) //shorts, bytes, ints, longs, floats, doubles, chars, booleans
    void test18(String winterMonth) {
        System.out.println(winterMonth);
        assertTrue(checkWinterMonth(winterMonth));
    }

    private boolean checkWinterMonth(String month) {
        if (month.equalsIgnoreCase("December") || month.equalsIgnoreCase("January") || month.equalsIgnoreCase("February")) {
            return true;
        }
        return false;
    }

    @ParameterizedTest
    @NullSource
    void test19(String source) {
        System.out.println(source);
        assertNull(source);
    }

    @ParameterizedTest
    @EmptySource
    void test20(String source) {
        System.out.println(source);
        assertEquals(source, "");
    }

    @ParameterizedTest
    @EmptySource
    void test21(int[] source) {
        System.out.println(source);
        assertEquals(0, source.length);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void test22(String source) {
        System.out.println(source);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"JUnit", "Mockito", "Report"})
    void test23(String source) {
        System.out.println(source);
    }

    @ParameterizedTest
    @EnumSource(Seasons.class)
    void test24(Seasons source) {
        System.out.println(source);
    }

    @ParameterizedTest
    @EnumSource
    void test251(String weekendDay) {
        System.out.println(weekendDay);

    } //will throw exception

    @ParameterizedTest
    @EnumSource
    void test252(Seasons season) {
        System.out.println(season);

    } //will execute normally

    @ParameterizedTest
    @MethodSource("stringProvider")
    void test26(String arg) {
        assertTrue(arg.length() == 6);
    }

    @ParameterizedTest
    @MethodSource
    void test27(int arg) {
        assertFalse(arg < 0);
    }

    @ParameterizedTest
    @MethodSource("com.example.java8springbootdemo.ExternalSourceClass#externalSource")
    void test28(String s) {
        assertTrue(s.length() < 4);
    }

    @ParameterizedTest
    @MethodSource("fruitAvailability")
    void test29(String fruit, int weight, List<String> warehouses) {
        assertNotNull(fruit);
        assertTrue(weight > 150 && weight < 500);
        assertNotEquals(0, warehouses.size());
    }

    @ParameterizedTest
    @ArgumentsSource(ArgumentsProviderImpl.class)
    void test30(String arg) {
        System.out.println(arg);
    }

    @ParameterizedTest
    @CsvSource({
            "grocery,            5400",
            "'drinks, veggies',  15000"
    })
    void test31(String eating, int price) {
        assertNotNull(eating);
        assertNotEquals(0, price);
    }

    @ParameterizedTest
    @CsvSource({
            "Jane, 24, FEMALE",
            "John, 22, MALE",
    })
    void test32(@AggregateWith(PersonAggregator.class) Person person) {
        assertNotNull(person);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getGender());
    }

    private static Stream<String> stringProvider() {
        return Stream.of(
                Seasons.WINTER.toString(),
                Seasons.SPRING.toString(),
                Seasons.SUMMER.toString(),
                Seasons.AUTUMN.toString()
        );
    }

    private static IntStream test27() {
        return IntStream.range(1, 9).skip(2);
    }

    private static Stream<Arguments> fruitAvailability() {
        return Stream.of(
                arguments("banana", 450, Arrays.asList("warehouse1", "warehouse2")),
                arguments("apple", 160, Arrays.asList("warehouse1")),
                arguments("orange", 284, Arrays.asList("warehouse3", "warehouse4", "warehouse6"))
        );
    }
}

class ArgumentsProviderImpl implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of("arg1", "arg2", "arg3").map(Arguments::of);
    }
}

class PersonAggregator implements ArgumentsAggregator {

    @Override
    public Person aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
        return new Person(
                accessor.get(0).toString(),
                Integer.parseInt(accessor.get(1).toString()),
                accessor.get(2, Gender.class)
        );
    }
}
