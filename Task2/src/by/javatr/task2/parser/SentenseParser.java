package by.javatr.task2.parser;

import by.javatr.task2.entity.Composite;
import by.javatr.task2.entity.TypeOfComposite;

import java.util.regex.Pattern;

public class SentenseParser extends Parser{
    public static final Pattern SENTENCE_DELIMETER = Pattern.compile("[.!?]");
    @Override
    public Composite parse(String paragraph) {
        Composite paragraphList=new Composite(TypeOfComposite.PARAGRAPH);
        String sentence;
        String[] strings = paragraph.trim().split(SENTENCE_DELIMETER.pattern());
        for(int i=0;i<strings.length;i++){
            sentence = strings[i];
            Composite sentenceList = nextParser.parse(sentence);
            paragraphList.add(sentenceList);
        }
        return paragraphList;
    }
 }
