package org.stepic.task.task03.task0305;

//Слишком длинные комментарии будем определять исходя из данного числа – максимальной длины комментария.

class TooLongTextAnalyzer implements TextAnalyzer{
    //макс. длина комментария
    private int maxLength = 0;

    //constructor
    TooLongTextAnalyzer (int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    /*Реализация метода анализа текста*/
    public Label processText(String text) {
        if (text.length() > maxLength)
            return Label.TOO_LONG;
        else
            return Label.OK;
    }
}
