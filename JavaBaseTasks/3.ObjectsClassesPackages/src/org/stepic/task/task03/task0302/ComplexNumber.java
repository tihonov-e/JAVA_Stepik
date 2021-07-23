package org.stepic.task.task03.task0302;
import java.lang.Double;

public class ComplexNumber {
    private final double re;
    private final double im;


    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public  boolean equals (Object obj) {
        if (getClass() != obj.getClass())
            return false;
        if (obj == null)
            return false;
        if (this == obj)
            return true;

        return true;
    }
}
