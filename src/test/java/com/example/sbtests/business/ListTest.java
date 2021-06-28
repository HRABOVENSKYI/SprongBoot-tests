package com.example.sbtests.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void listSize() {

        List list = mock(List.class);
        when(list.size()).thenReturn(2);

        assertEquals(2, list.size());
    }

    @Test
    public void listSizeReturnMultipleValues() {

        List list = mock(List.class);
        when(list.size()).thenReturn(2).thenReturn(3);

        assertEquals(2, list.size());
        assertEquals(3, list.size());
        assertEquals(3, list.size());
    }

    @Test
    public void listGetReturnMultipleValues() {

        List list = mock(List.class);
        when(list.get(0)).thenReturn("String at pos 0");

        assertEquals("String at pos 0", list.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void listGetThrowsAnException() {

        List list = mock(List.class);
        when(list.get(0)).thenThrow(new RuntimeException("Ghost"));

        list.get(0);
    }
}
