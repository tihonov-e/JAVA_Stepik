package org.stepic.task.task03.task0305;

import java.util.ArrayList;
import java.util.Collections;

/*Фильтр на спам.
*Будем фильтровать по наличию указанных ключевых слов в тексте.
*/
public class SpamAnalyzer extends KeywordAnalyzer {

    //хранит список ключевых слов
    private String[] keywords;

    //constructor
    public SpamAnalyzer(String[] keyWords){
        keywords = new String[keyWords.length];
        keywords = keyWords.clone();
    }
    @Override
    protected String[] getKeyword {

    }

}
