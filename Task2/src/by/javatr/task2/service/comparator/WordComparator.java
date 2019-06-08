package by.javatr.task2.service.comparator;

import by.javatr.task2.entity.Entity;

import java.util.Comparator;

public class WordComparator implements Comparator<Entity> {

    private String str;
    public WordComparator(String str){
        this.str=str;
    }
    @Override
    public int compare(Entity o1, Entity o2) {
        return o1.matchStr(str) - o2.matchStr(str);
    }
}