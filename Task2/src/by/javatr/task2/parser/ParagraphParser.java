package by.javatr.task2.parser;

import by.javatr.task2.entity.Composite;
import by.javatr.task2.entity.TypeOfComposite;

import java.util.regex.Pattern;

public  class ParagraphParser extends Parser {
    public static final Pattern PARAGRAPH_DELIMETER = Pattern.compile("[ ]{3,}");
    @Override
    public Composite parse(String textstr) {
        Composite text=new Composite(TypeOfComposite.TEXT);
        String paragraph;
        String[] strings = textstr.trim().split(PARAGRAPH_DELIMETER.pattern());
        for(int i=0;i<strings.length;i++){
            paragraph = strings[i];
            Composite paragraphList =nextParser.parse(paragraph);
            text.add(paragraphList);
        }
        return text;
    }
}
