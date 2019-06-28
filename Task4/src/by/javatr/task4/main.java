package by.javatr.task4;

import by.javatr.task4.entity.Flower;
import by.javatr.task4.entity.FlowerEnum;
import by.javatr.task4.entity.Flowers;
import by.javatr.task4.parser.*;

import java.util.Set;

public class main {
    public static void main(String[] args) {
        FlowersBuilderFactory fFactory = new FlowersBuilderFactory();
        AbstractFlowersBuilder builder = fFactory.createFlowersBuilder("dom");
        builder.buildSetFlowers("data/new.xml");
        Set<Flower> s = builder.getFlowers();
        for (Flower d : s) {
            System.out.println(d);
        }
    }
}
