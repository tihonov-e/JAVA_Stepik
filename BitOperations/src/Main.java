/**
 * Tests of Bit operations
 * @author Tikhonov Eugene
 * @version 1.0
 * 09.09.2020
 */
public class Main {
    public static void main (String[] args) {

        /**
         * Bit invertion operation
         */

        int a = 0x0F, //исходное число
                b = 4, //номер бита для инвертироавния
                result = 0; //результат

        //находим знач. нужного бита и ставим его в условие if
        if ( (a & (1<<b)) != 0 ) result = a & ~(1<<b); //меняем бит на 0
        else result = a | (1<<b); //меняем на еденицу

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(result));

    }
}