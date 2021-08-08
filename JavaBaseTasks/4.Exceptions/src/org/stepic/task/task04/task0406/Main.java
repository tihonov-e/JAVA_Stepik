package org.stepic.task.task04.task0406;

//учимся настраивать параметры логирования
//https://stepik.org/lesson/12774/step/8

import java.util.logging.*;


public class Main {

    //- инициализируем переменную для логгера класса А и  устанавливаем ему заданный уровень
    static Logger LOGGER_A = Logger.getLogger(org.stepic.java.logging.ClassA.class.getName());
}
