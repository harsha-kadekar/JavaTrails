package com.hkadekar.anu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AppleInventoryTest {

    private AppleInventory appleInventory;

    @BeforeEach
    public void testSetup(){
        appleInventory = new AppleInventory();
        appleInventory.addApple( new Apple("green", 140.0, AppleType.FUJI_APPLE));
        appleInventory.addApple( new Apple("red", 155.0, AppleType.HONEYCRISP_APPLE));
        appleInventory.addApple( new Apple("white", 150.0, AppleType.SHIMLA_APPLE));
        appleInventory.addApple( new Apple("green", 121.0, AppleType.HONEYCRISP_APPLE));
        appleInventory.addApple( new Apple("green", 160.0, AppleType.FUJI_APPLE));
        appleInventory.addApple( new Apple("red", 120.0, AppleType.SHIMLA_APPLE));
        appleInventory.addApple( new Apple("red", 154.5, AppleType.SHIMLA_APPLE));

    }

    @Test
    public void getApplesByColorTest(){

        List<Apple> expectedResult = new ArrayList<>();
        expectedResult.add(appleInventory.getAppleInventory().get(0));
        expectedResult.add(appleInventory.getAppleInventory().get(3));
        expectedResult.add( appleInventory.getAppleInventory().get(4));
        List<Apple> greenApples = appleInventory.filterApples((Apple apple) -> "green".equals(apple.getColor()));
        Assertions.assertArrayEquals(expectedResult.toArray(), greenApples.toArray());

        expectedResult.clear();
        expectedResult.add(appleInventory.getAppleInventory().get(1));
        expectedResult.add(appleInventory.getAppleInventory().get(5));
        expectedResult.add(appleInventory.getAppleInventory().get(6));
        List<Apple> redApples = appleInventory.filterApples((Apple apple) -> "red".equals(apple.getColor()));
        Assertions.assertArrayEquals(expectedResult.toArray(), redApples.toArray());

        expectedResult.clear();
        expectedResult.add(appleInventory.getAppleInventory().get(2));
        List<Apple> whiteApples = appleInventory.filterApples((Apple apple) -> "white".equals(apple.getColor()));
        Assertions.assertArrayEquals(expectedResult.toArray(), whiteApples.toArray());

    }

    @Test
    public void getApplesByWeightTest(){
        List<Apple> expectedResult = new ArrayList<>();
        expectedResult.add(appleInventory.getAppleInventory().get(1));
        expectedResult.add(appleInventory.getAppleInventory().get(2));
        expectedResult.add(appleInventory.getAppleInventory().get(4));
        expectedResult.add(appleInventory.getAppleInventory().get(6));

        List<Apple> weightedApples = appleInventory.filterApples((Apple apple) -> apple.getWeight() >= 150.0);

        Assertions.assertArrayEquals(expectedResult.toArray(), weightedApples.toArray());
    }

    @Test
    public void getApplesInfoByColor(){
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("green");
        expectedResult.add("red");
        expectedResult.add("white");
        expectedResult.add("green");
        expectedResult.add("green");
        expectedResult.add("red");
        expectedResult.add("red");

        List<String> colors = appleInventory.printAppleInventory((Apple apple) -> apple.getColor());

        Assertions.assertArrayEquals(expectedResult.toArray(), colors.toArray());;
    }

    @Test
    public void getSortedApples(){
        List<Apple> expectedResults = new ArrayList<>();
        expectedResults.add(appleInventory.getAppleInventory().get(5));
        expectedResults.add(appleInventory.getAppleInventory().get(3));
        expectedResults.add(appleInventory.getAppleInventory().get(0));
        expectedResults.add(appleInventory.getAppleInventory().get(2));
        expectedResults.add(appleInventory.getAppleInventory().get(6));
        expectedResults.add(appleInventory.getAppleInventory().get(1));
        expectedResults.add(appleInventory.getAppleInventory().get(4));

        List<Apple> sortedApples = appleInventory.sortedApples((Apple ap1, Apple ap2) -> ap1.getWeight().compareTo(ap2.getWeight()));

        Assertions.assertArrayEquals(expectedResults.toArray(), sortedApples.toArray());
    }


}
