package by.javatr.task2.service.comparator;

import by.javatr.task2.entity.Component;

import java.util.Comparator;

public class LengthComparator implements Comparator<Component> {

        @Override
        public int compare(Component o1, Component o2) {
            return o1.getLength()-o2.getLength();
        }

}
