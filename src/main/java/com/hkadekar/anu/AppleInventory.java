package com.hkadekar.anu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppleInventory {
    private List<Apple> appleInventory;

    public AppleInventory() {
        appleInventory = new ArrayList<>();
    }

    public void addApple(Apple apple){
        appleInventory.add(apple);
    }

    public List<Apple> filterApples(ApplePredicate applePredicate){
        List<Apple> apples = new ArrayList<>();

        for(Apple ap: appleInventory){
            if(applePredicate.test(ap)){
                apples.add(ap);
            }
        }

        return apples;
    }

    public List<String> printAppleInventory(ApplePrintFunction applePrintFunction){
        List<String> apples = new ArrayList<>();

        for(Apple apple: appleInventory){
            apples.add(applePrintFunction.displayInfo(apple));
        }
        return apples;
    }

    public List<Apple> sortedApples(Comparator<Apple> appleComparator){
        List<Apple> apples = new ArrayList<>(appleInventory);
         apples.sort(appleComparator);
        return apples;
    }





    public List<Apple> getAppleInventory() {
        return appleInventory;
    }

    public void setAppleInventory(List<Apple> appleInventory) {
        this.appleInventory = appleInventory;
    }
}
