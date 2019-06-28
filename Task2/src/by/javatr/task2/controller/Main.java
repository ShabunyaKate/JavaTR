package by.javatr.task2.controller;

import by.javatr.task2.entity.Composite;
import by.javatr.task2.exception.GeneralException;
import by.javatr.task2.parser.*;
import by.javatr.task2.reader.FileReader;
import by.javatr.task2.service.Sorter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger log= LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        String s = FileReader.readFromFile("data/text");
        Composite text=CompositeText.getTextComposite(s);
        log.info(text.toString());
        try {
            log.info(Sorter.sortSentense(text, "a").toString());
        }
        catch(GeneralException e){
          log.error(e);
        }
    }}
