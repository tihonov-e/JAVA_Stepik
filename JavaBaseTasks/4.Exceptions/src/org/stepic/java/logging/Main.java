package org.stepic.java.logging;

/** учимся настраивать параметры логирования
https://stepik.org/lesson/12774/step/8
help URL: https://examples.javacodegeeks.com/core-java/util/logging/java-util-logging-example/

 */

import java.util.logging.*;


public class Main {

    //- инициализируем переменную для логгера класса А и  устанавливаем ему заданный уровень
    static Logger LOGGER_A = Logger.getLogger(org.stepic.java.logging.ClassA.class.getName());
    static Logger LOGGER_B = Logger.getLogger(org.stepic.java.logging.ClassB.class.getName());

}
