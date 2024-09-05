package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FibTest {

private Fib fib;

    @Test
    public void testGetFibSeriesWhenRange_1_ThenResult_notNull(){
        // Arrange
        Fib fib = new Fib(1);
        List<Integer> fibList = fib.getFibSeries();

        //Act
        boolean result = fibList.isEmpty();

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetFibSeriesWhenRange_1_ThenResult_ListContain_0(){
        // Arrange
        Fib fib = new Fib(1);
        List<Integer> fibList = fib.getFibSeries();
        boolean result = false;


        //Act
        if (fibList.size() == 1 && fibList.get(0) == 0) {
            result = true;
        }

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetFibSeriesWhenRange_6_ThenResult_ListContain_3(){
        // Arrange
        Fib fib = new Fib(6);
        List<Integer> fibList = fib.getFibSeries();


        //Act
       boolean result = fibList.contains(3);

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetFibSeriesWhenRange_6_ThenResult_ListSize_6(){
        // Arrange
        Fib fib = new Fib(6);
        List<Integer> fibList = fib.getFibSeries();
        boolean result = false;


        //Act
        if (fibList.size() == 6) {
            result = true;
        }

        //Assert
        Assertions.assertTrue(result);
    }

    @Test
    public void testGetFibSeriesWhenRange_6_ThenResult_ListNotContain_4(){
        // Arrange
        Fib fib = new Fib(6);
        List<Integer> fibList = fib.getFibSeries();


        //Act
        boolean result = fibList.contains(4);

        //Assert
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetFibSeriesWhenRange_6_ThenResult_ListContain_011235(){
        // Arrange
        Fib fib = new Fib(6);
        List<Integer> fibList = fib.getFibSeries();
        List<Integer> resultAwait = new ArrayList<>();
        resultAwait.add(0);
        resultAwait.add(1);
        resultAwait.add(1);
        resultAwait.add(2);
        resultAwait.add(3);
        resultAwait.add(5);
        boolean result = false;

        //Act
        if (fibList.equals(resultAwait)) {
            result = true;
        }

        //Assert
        Assertions.assertTrue(result);
    }
}
