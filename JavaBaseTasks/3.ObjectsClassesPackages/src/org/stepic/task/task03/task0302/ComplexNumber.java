package org.stepic.task.task03.task0302;
/*Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode() так, чтобы equals() сравнивал экземпляры
ComplexNumber по содержимому полей re и im, а hashCode() был бы согласованным с реализацией equals().
Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет*/

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
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        if (this == obj)
            return true;

        Double im = this.getIm();
        Double re = this.getRe();
        ComplexNumber that = (ComplexNumber) obj;
        return  (im.equals((Double) that.getIm()) && re.equals((Double) that.getRe()));
    }

    @Override
    public int hashCode () {
        Double im = this.getIm();
        Double re = this.getRe();
        return 31*im.hashCode() + 31*re.hashCode();
    }
}
