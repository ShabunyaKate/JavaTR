package by.javatr.task2.service.comparator;

import by.javatr.task2.entity.Entity;

import java.util.Comparator;

public class WordLengthComparator implements Comparator<Entity> {
    @Override
    public int compare(Entity o1, Entity o2) {
        return o1.leafLength() - o2.leafLength();
    }
}

