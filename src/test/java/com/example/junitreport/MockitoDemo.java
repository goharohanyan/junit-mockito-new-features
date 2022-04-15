package com.example.junitreport;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Gohar Ohanyan. Created on 4/12/2022.
 */

public class MockitoDemo {

    @Test
    void test35() {
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        assertEquals("first", mockedList.get(0));
        assertThrowsExactly(RuntimeException.class, () -> mockedList.get(1));
        assertNull(mockedList.get(999));

        //verifying behaviour
        verify(mockedList).get(0);

        //argument matchers
        when(mockedList.get(anyInt())).thenReturn("element");

        assertTrue(mockedList.get(1000).equals("element"));
        verify(mockedList).get(eq(1000));

        //verifying exact number of invocations
        //verify(mockedList).get(156); //will throw exception
        verify(mockedList, times(4)).get(anyInt());
        verify(mockedList, times(0)).get(156);
        verify(mockedList, atLeast(3)).get(anyInt());
        verify(mockedList, atMost(4)).get(156);
        verify(mockedList, never()).add("test");

        //stubbing void methods with exceptions
        doThrow(new IllegalArgumentException("dummy reason")).when(mockedList).add(true);

        try {
            mockedList.add(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //finding redundant invocations
        List mock = mock(List.class);
        mock.add(123);
        verify(mock).add(123);
        verifyNoMoreInteractions(mock);
//        verifyNoInteractions(mockedList); //will throw exception

        //stubbing consecutive calls
        when(mock.get(0))
                .thenReturn(666, 777, 888);

        System.out.println(mock.get(0));
        System.out.println(mock.get(0));
        System.out.println(mock.get(0));
        System.out.println(mock.get(0));
        System.out.println(mock.get(0));

        //stubbing with callbacks
        when(mock.remove(anyInt())).thenAnswer(
                new Answer() {
                    @Override
                    public Object answer(InvocationOnMock invocation) throws Throwable {
                        return "called with arg: " + Arrays.toString(invocation.getArguments());
                    }
                }
        );
        System.out.println(mock.remove(456));

        //capturing argument
        DummyService dummyMock = mock(DummyService.class);
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        dummyMock.isNumberPositive(15);
        verify(dummyMock).isNumberPositive(captor.capture());
        assertEquals(15, captor.getValue());


        //real partial mocks
        System.out.println(mock(Person.class));
        System.out.println(spy(Person.class));

        List mockList = mock(ArrayList.class);
        assertEquals(0, mockList.size());
        mockList.add(4);
        assertEquals(0, mockList.size());
        when(mockList.size()).thenReturn(6);
        assertEquals(6, mockList.size());

        List spyList = spy(ArrayList.class);
        assertEquals(0, spyList.size());
        spyList.add(4);
        assertEquals(1, spyList.size());
        when(spyList.size()).thenReturn(7);
        assertNotEquals(1, spyList.size());
        assertEquals(7, spyList.size());

        //resetting mocks
        verify(mockList).add(eq(4));
        reset(mockList);
        verifyNoInteractions(mockList);
        verifyNoMoreInteractions(mockList);
        verify(mockList, never()).add(anyInt());

        //verification with timeout
        verify(mockList, timeout(1000).atLeast(0)).add(eq(4));
        verify(mockList, timeout(1000).times(0)).add(eq(4));

    }

}
