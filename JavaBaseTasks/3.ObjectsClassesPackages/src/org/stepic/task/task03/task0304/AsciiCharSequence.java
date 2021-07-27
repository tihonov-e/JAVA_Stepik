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

    @Override
    public CharSequence subSequence(int start, int end) {
        int length = end - start;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = charSequence[start + i];
        }
        return new AsciiCharSequence (bytes);
    }

    @Override
    public String toString() {
        return new String(charSequence);
    }
}
