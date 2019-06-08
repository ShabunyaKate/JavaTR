package by.javatr.task2.parser;

import by.javatr.task2.entity.Composite;
import by.javatr.task2.entity.LeafWord;
import by.javatr.task2.entity.TypeOfComposite;

import javax.management.openmbean.CompositeType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parser {
    public static final Pattern WORD_DELIMETER=Pattern.compile("[a-zA-Z0-9]+");
    @Override
    public Composite parse(String wordstr) {
        Composite wordList=new Composite(TypeOfComposite.LEXEM);
        String word= "";
        LeafWord wordLeaf;
        Matcher matcher = WORD_DELIMETER.matcher(wordstr);
        while (matcher.find()) {
            word = matcher.group();
            wordLeaf = new LeafWord(word);
            wordList.add(wordLeaf);
        }
        return wordList;
    }
}
