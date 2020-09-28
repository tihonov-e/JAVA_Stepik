/**
 * Working with wrapes calsses
 * Integer, Character etc
 * @autor Tikhonov Eugene
 * 14/09/2020
 */
package com.company;

public class Main {

    public static void main(String[] args) {

        //Тестируем работу ссылочных типов
        int value = 10; //число
        Integer reference = Integer.valueOf(value); //ссылка
        int backToPrimitive = reference.intValue();

        value += 1;

        System.out.println("Работа с ссылочными типами");
        System.out.println("value: " + value);
        System.out.println("ref: " + reference);
        System.out.println("\n");

        //Конвертация в строку и обратно
        int fromString = Integer.parseInt("123");
        String fromInt = Integer.toString(123);

        System.out.println("Работа с конвертацией");
        System.out.println("fromString: " + fromString);
        System.out.println("fromInt: " + fromInt);

        //Полезные методы
        int maxIntValue = Integer.MAX_VALUE;
        int minIntValue = Integer.MIN_VALUE;
        int bitCount = Integer.bitCount(15);
        boolean isLetter = Character.isLetter('a');
        float floatInfinity = Float.NEGATIVE_INFINITY;
        float floatNAN = Float.NaN;
        boolean isNAN = Float.isNaN(floatNAN);

        System.out.println("Полезные методы");
        System.out.println("maxIntValue: " + maxIntValue);
        System.out.println("minIntValue: " + minIntValue);
        System.out.println("bitCount: " + bitCount);
        System.out.println("isLetter: " + isLetter);
        System.out.println("floatInfinity: " + floatInfinity);
        System.out.println("floatNAN: " + floatNAN);
        System.out.println(floatNAN + "isNAN? : " + isNAN);


    }
}
