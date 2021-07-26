package org.stepic.task.task03.task0304;

public class AsciiCharSequence implements  java.lang.CharSequence{

    private byte[] charSequence;

    //constructor
    public AsciiCharSequence (byte[] charSequence) {
        this.charSequence = charSequence.clone();
    }

    @Override
    public int length () {
        return charSequence.length;
    }

    @Override
    public char charAt(int index) {
        return (char) charSequence[index];
    }

    //реализовать
    @Override
    public CharSequence subSequence(int start, int end) {
         return null;
    }
}
