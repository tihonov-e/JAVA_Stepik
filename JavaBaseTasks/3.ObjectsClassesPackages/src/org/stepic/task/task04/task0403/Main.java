package org.stepic.task.task04.task0403;

public class Main {
 //stacktrace

    public static void main(String[] args) {
/*      тесты
        System.out.println(getCallerClassAndMethodName());
        m1();    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());    }
*/

        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }



        public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String message = "";
        if (stackTraceElements.length == 3)
            return null;
        else {
            StackTraceElement element = stackTraceElements[2];
            String className = element.getClassName();
            String methodName = stackTraceElements[stackTraceElements.length - 1].getMethodName();
            return className + "#" + methodName;

        }

    }

}


