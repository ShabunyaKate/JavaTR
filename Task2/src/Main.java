import by.javatr.task2.entity.Composite;
import by.javatr.task2.entity.Entity;
import by.javatr.task2.entity.LeafWord;
import by.javatr.task2.parser.*;
import by.javatr.task2.reader.FileReader;
import by.javatr.task2.service.Sorter;


public class Main {
    public static void main(String[] args) {
        String s = FileReader.readFromFile("data/text");
        Composite text=CompositeText.getTextComposite(s);
        System.out.println(text);
       // System.out.println(Sorter.sortSentense(text,"a"));
    }}
