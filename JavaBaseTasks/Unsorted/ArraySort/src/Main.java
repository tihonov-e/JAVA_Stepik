/**
 * Пример сортировки массива пузырьком
 *
 */

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int [] arr = {4,3,2,1,0};
        bubleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubleSort(int[] intArray) {
        int last = intArray.length;

        for (boolean sorted = last == 0; !sorted; --last) {
            //верхняя граница массива постоянно уменьшается по мере того,
            // как наибольший элемент в под-массиве занимает крайне правую позицию
//            сортировка прекращается, как только обнаружено, что перестановок соседних
//            элементов не было, то есть что массив уже является отсортированным.
            sorted = true;
            for (int i = 1; i < last; ++i) {
                if (intArray[i - 1] >= intArray[i]) {
                    sorted = false;

                    int tmp = intArray[i - 1];
                    intArray[i - 1] = intArray[i];
                    intArray[i] = tmp;
                }
            }
        }
    }
}

