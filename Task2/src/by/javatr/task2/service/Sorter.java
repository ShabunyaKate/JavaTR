package by.javatr.task2.service;

import by.javatr.task2.entity.Composite;
import by.javatr.task2.entity.Component;
import by.javatr.task2.entity.TypeOfComposite;
import by.javatr.task2.exception.GeneralException;
import by.javatr.task2.service.comparator.LengthComparator;
import by.javatr.task2.service.comparator.WordComparator;
import by.javatr.task2.service.comparator.WordLengthComparator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class Sorter {
    private static final Logger log = LogManager.getLogger(Sorter.class);

    public static Composite sortParagraph(Composite text) {//абзац по колво предложений
        Composite newText;
        List<Component> partList = text.copyEntity();
        Collections.sort(partList, new LengthComparator());
        newText = new Composite(partList, TypeOfComposite.TEXT);
        return newText;
    }

    public static Composite sortSentense(Composite text, String str) throws GeneralException { // предлродения в абзаце по количеству вхождений слова
        if (str == null) throw new GeneralException("Empty string");
        Composite newText = new Composite(TypeOfComposite.TEXT);
        for (int i = 0; i < text.getLength(); i++) {
            Composite paragraph = text.getCompositeElement(i);
            List<Component> paragraphList = paragraph.copyEntity();
            Collections.sort(paragraphList, new WordComparator(str));
            newText.add(new Composite(paragraphList, TypeOfComposite.PARAGRAPH));
        }
        return newText;
    }

    public static Composite sortWord(Composite text) {// сортировка слов в предложении по длине
        Composite newtext = new Composite(TypeOfComposite.TEXT);
        Composite paragraph;
        Composite sentense;
        try {
            for (int i = 0; i < text.getLength(); i++) {
                Composite newparagraph = new Composite(TypeOfComposite.PARAGRAPH);
                paragraph = text.getCompositeElement(i);
                for (int j = 0; j < paragraph.getLength(); j++) {
                    sentense = sortWordSentense(paragraph.getCompositeElement(j));
                    newparagraph.add(sentense);
                }
                newtext.add(newparagraph);
            }
        } catch (GeneralException e) {
            log.error(e.getMessage());
        }
        return newtext;
    }

    private static Composite sortWordSentense(Composite sentense) throws GeneralException {
        if (TypeOfComposite.SENTENSE.equals(sentense.getType())) {
            List<Component> listSentense = sentense.copyEntity();
            Collections.sort(listSentense, new WordLengthComparator());
            return new Composite(listSentense, TypeOfComposite.SENTENSE);
        } else
            throw new GeneralException("Composite is not sentense");
    }
}

