package com.company;

public class Car {
    static int count;
    int count1;


    public static void invokeCounter (){
        int k = 0;
        count++;
        System.out.println ("Program counter = " + count);
    }

    public void invokeCounter1 (){
        count1++;
        System.out.println ("Program counter1 = " + count1);
    }
}
