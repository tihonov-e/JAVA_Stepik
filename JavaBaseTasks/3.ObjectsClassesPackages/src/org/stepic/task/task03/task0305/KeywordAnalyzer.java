package org.stepic.task.task03.task0305;

    abstract class KeywordAnalyzer implements TextAnalyzer {
        //возвращает набор ключевых слов
        protected abstract String[] getKeywords();
        /*Возвращает метку, которой необходимо пометить
        *положительные срабатывания.
        * */
        protected abstract Label getLabel();

        @Override
        /*Реализация метода анализа текста*/
        public Label processText(String text) {
            //Получаем ключевые слова
            String[] keyWords = this.getKeywords();
            //проверяем текст на наличие keyWords
            for (String keyWord : keyWords) {
                if (text.contains(keyWord))
                    return getLabel();
            }
            return Label.OK;
        }
    }