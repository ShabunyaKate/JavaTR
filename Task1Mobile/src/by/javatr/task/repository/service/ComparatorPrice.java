<<<<<<< HEAD
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;

import java.util.Comparator;

public class ComparatorPrice implements Parametr, Comparator<Rate>{
    @Override
    public int compare(Rate o1, Rate o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
=======
package by.javatr.task.repository.service;

import by.javatr.task.entity.Rate;

import java.util.Comparator;

public class ComparatorPrice implements Parametr, Comparator<Rate>{
    @Override
    public int compare(Rate o1, Rate o2) {
        return o1.getPrice()-o2.getPrice();
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
