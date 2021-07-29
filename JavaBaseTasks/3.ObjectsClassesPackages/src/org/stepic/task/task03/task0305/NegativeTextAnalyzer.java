package org.stepic.task.task03.task0305;

//Негативное содержание будем определять по наличию одного из трех смайликов – :( =( :|
class NegativeTextAnalyzer extends KeywordAnalyzer {

    @Override
    protected String[] getKeywords() {
        String[] negativeSymbols = new String[] {":(", "=(", ":|"};
        return negativeSymbols;
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }

}
