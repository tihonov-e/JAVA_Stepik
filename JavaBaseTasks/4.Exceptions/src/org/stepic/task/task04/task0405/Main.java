package org.stepic.task.task04.task0405;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

//изучаем логирование java.util.Logger
public class Main {

    static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            //user code

            int a = 0, b = 1;
            LOGGER.log(Level.FINE, "Начало main");
            List<Integer> ints = new ArrayList<Integer>();

            LOGGER.log(Level.WARNING, "добавляем число {0} в List", a);
            ints.add(a);

            LOGGER.log(Level.WARNING, "добавляем число {0}  в List", b);
            ints.add(b);

            LOGGER.log(Level.INFO, "Выводим в консоль ints {0}", ints.toString());
            for (Object anInt : ints)
                System.out.println(anInt);

            LOGGER.log(Level.INFO, "Размер равен " + ints.size());


        } catch (Exception e){
            //some code
            LOGGER.log(Level.WARNING, "Поймали исключение " + e);
            e.printStackTrace();
        }
    }
}
