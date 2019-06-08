package by.javatr.task2.parser;

import by.javatr.task2.entity.Composite;
import by.javatr.task2.entity.TypeOfComposite;

import java.util.regex.Pattern;

public class LexemParser extends Parser {
    public static final Pattern LEXEM_DELIMETER = Pattern.compile("[, ]+");
    @Override
    public Composite parse( String sentence) {
        Composite sentenceList=new Composite(TypeOfComposite.SENTENSE);
        String lexem;
        String[] strings = sentence.trim().split(LEXEM_DELIMETER.pattern());
        for(int i=0;i<strings.length;i++){
            lexem = strings[i];
            Composite lexemList = nextParser.parse(lexem);
            sentenceList.add(lexemList);
        }
        return sentenceList;
    }
}
