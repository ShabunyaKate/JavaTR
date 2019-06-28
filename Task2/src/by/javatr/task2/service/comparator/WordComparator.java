package by.javatr.task2.service.comparator;

import by.javatr.task2.entity.Component;

import java.util.Comparator;

public class WordComparator implements Comparator<Component> {

    private String str;
    public WordComparator(String str){
        this.str=str;
    }
    @Override
    public int compare(Component o1, Component o2) {
        return o1.matchStr(str) - o2.matchStr(str);
    }
}