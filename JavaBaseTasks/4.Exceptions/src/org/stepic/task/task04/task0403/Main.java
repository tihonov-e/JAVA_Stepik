package org.stepic.task.task04.task0403;

public class Main {
 //stacktrace

    public static void main(String[] args) {
        //тесты
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
/*
        out:
        null
        org.stepic.java.example.Test#main
*/
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }



        public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        if (stackTraceElements.length < 4)
            return null;
        else {
            StackTraceElement element = stackTraceElements[3];
            String className = element.getClassName();
            String methodName = element.getMethodName();
            return className + "#" + methodName;

        }

    }

}


