package by.javatr.task2.parser;

import by.javatr.task2.entity.Composite;

public class CompositeText {
    public static Composite getTextComposite(String strText){
        Parser parserParagraph=new ParagraphParser();
        SentenseParser sentenseParser=new SentenseParser();
        parserParagraph.setNextParser(sentenseParser);
        LexemParser lexemParser=new LexemParser();
        sentenseParser.setNextParser(lexemParser);
        lexemParser.setNextParser(new WordParser());
        return parserParagraph.parseText(strText);
    }

}
