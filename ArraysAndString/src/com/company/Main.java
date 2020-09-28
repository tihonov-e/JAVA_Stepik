/**
 * Tasks of the String and Arrays topics
 * @autor Tikhonov Eugene
 * 16/09/2020
 */
package com.company;

import java.util.Arrays;

public class Main {
/*
    Реализуйте метод, проверяющий, является ли заданная строка палиндромом. Палиндромом называется строка,
    которая читается одинаково слева направо и справа налево (в том числе пустая).
    При определении "палиндромности" строки должны учитываться только буквы и цифры.
    А пробелы, знаки препинания, а также регистр символов должны игнорироваться.
    Гарантируется, что в метод попадают только строки, состоящие из символов ASCII
    (цифры, латинские буквы, знаки препинания). Т.е. русских, китайских и прочих экзотических символов в строке не будет.

    Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main
    и обработку ввода-вывода добавит проверяющая система.

    Подсказки (не читайте, если хотите решить сами):

    для удаления из строки всех символов, не являющихся буквами и цифрами, можно воспользоваться
    регулярным выражением "[^a-zA-Z0-9]"; найдите в классе String метод, выполняющий замену по регулярному выражению;
    для перестановки символов строки в обратном порядке можно воспользоваться методом reverse(), который
    находится в классе StringBuilder;
    в классе String есть методы для преобразования всей строки в верхний и нижний регистр.

*/
    public static void main(String[] args) {
        String s1 = "Madam, I'm Adam!"; //string for cheking
        System.out.println(isPalindrome(s1)); //call function and print result

    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        //убираем все символы, кроме цифр и букв
        String s1 = text.replaceAll("[^a-zA-Z0-9]","");

        //убираем верхний регистр
        String s2 = s1.toLowerCase();

        //создаем новый объект класса StringBuilder
        StringBuilder reverseString = new StringBuilder();

        //конвертируем объект типа String в StringBuilder
        reverseString.append(s2);

        //переворачиваем строку
        reverseString.reverse();

        //если перевернутая строка равна исходной, то true
        return s2.equals(reverseString.toString());
    }
}
