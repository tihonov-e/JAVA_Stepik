/**
 * Flips one bit of the given <code>value</code>.
 * @author Tikhonov Eugene
 * @version 1.0
 * 09.09.2020
 */
public class Main {
    public static void main (String[] args) {

        /**
         * Bit invertion operation
         */

        int a = -1, //исходное число
                b = 1, //номер бита для инвертироавния
                result = 0; //результат

        //сдвигаем 1 влево на число бит, равное b
        // применяем операцию XOR
        result = a ^ (1 << b);

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(result));

    }
}