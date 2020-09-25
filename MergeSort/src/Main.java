import java.util.Arrays;

/**
 * Merge Sort
 * Merge two sorted arrays a1 and a2 to sorted array a3
 * https://habr.com/ru/post/281675/
 * @autor Tikhonov Eugene
 * 26/09/2020
 */
public class Main {

    public static void main(String[] args) {
        //два исходных сортированных по неубыванию массива
        int[] a1 = new int[] {21, 23, 24, 40, 75, 76, 78, 77, 900, 2100, 2200, 2300, 2400, 2500};
        int[] a2 = new int[] {10, 11, 41, 50, 65, 86, 98, 101, 190, 1100, 1200, 3000, 5000};
        //результирующий массив
        int[] a3 = new int[a1.length + a2.length];

        /*i, j - ндексы массива a1 и a2 соответственно
        инкрементируем индекс i, когда добавляем в а3 элемент из а1
        аналогично для j: а2 -> а3
         */

        int i=0, j=0;


        /*
         основной цикл по элементам массива a3
         условие окончания - достижение конца массива
          */

        for (int k=0; k<a3.length; k++) {

            /* проверка достижения конца массива a1
            если достигли конца, то записываем в а3 оставшиеся элементы а2
             */
            if (i > a1.length-1) {
                int a = a2[j];
                a3[k] = a;
                j++;
            }

            //аналогичная проверка для а2
            else if (j > a2.length-1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }


            //сравнениее элементов массивов а1 и а2 по величине

            /*если элемент а1 меньший, то записываем его в а3
            и инкрементируем индекс i
             */
            else if (a1[i] < a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }
            //иначе, пишем в а3 элемент массива а2
            else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }
        }

        //печать исходных и результирующего массивов
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
    }
}
