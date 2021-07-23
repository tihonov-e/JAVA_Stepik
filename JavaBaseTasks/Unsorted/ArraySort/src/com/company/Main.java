package com.company;

/*Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один отсортированный
        в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.

        Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность: он будет идти
        по двум исходным массивам и сразу формировать отсортированный результирующий массив. Так, чтобы
        сортировка полученного массива при помощи Arrays.sort() уже не требовалась. К сожалению,
        втоматически это не проверить, так что это остается на вашей совести :)

        Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода
        добавит проверяющая система.

        Пример

        Если на вход подаются массивы {0, 2, 2} и {1, 3}, то на выходе должен получиться массив {0, 1, 2, 2, 3}*/

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //original arrays
        int [] arr1 = {0, 2, 2};
        int [] arr2 = {1, 3};

        //print original arrays
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));

        //print modified array
        System.out.println("result: " + Arrays.toString(mergeArrays(arr1, arr2)));
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays (int[] a1, int[] a2) {
        //create merge array
        int[] a3 = new int[a1.length + a2.length];
        int [] buf = new int[2]; //buffer array

        //используем сортировку слиянием
        //https://habr.com/ru/post/281675/


    }
}
