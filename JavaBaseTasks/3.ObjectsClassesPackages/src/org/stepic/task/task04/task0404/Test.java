package org.stepic.task.task04.task0404;

// класс массива ошибок, 27 вариантов размещений из 2 ошибок в 3 классах программы
class Test {
    static RuntimeException[] ExceptionArray = {null, new RobotConnectionException(), new MyException()};
    static RuntimeException getTest(int args){
        int i = 0;
        RuntimeException[][] testArray = new RuntimeException[27][3];
        for (RuntimeException k : ExceptionArray){
            for (RuntimeException t : ExceptionArray){
                for (RuntimeException s : ExceptionArray){
                    testArray[i][0] = k != null ? (RuntimeException) ((Dublicated) k).dublic():null;
                    testArray[i][1] = t != null ? (RuntimeException) ((Dublicated) t).dublic():null;
                    testArray[i][2] = s != null ? (RuntimeException) ((Dublicated) s).dublic():null;
                    i++;
                }
            }
        }
        return testArray[Main.getRepeatNumber()][args];
    }
}

