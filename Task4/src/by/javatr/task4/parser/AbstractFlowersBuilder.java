package by.javatr.task4.parser;
import by.javatr.task4.entity.Flower;

import java.util.HashSet;
import java.util.Set;
public abstract class AbstractFlowersBuilder {
        protected Set<Flower> flowers;
        public AbstractFlowersBuilder() {
            flowers = new HashSet<Flower>();
        }
        public AbstractFlowersBuilder(Set<Flower> flowers) {
            this.flowers = flowers;
        }
        public Set<Flower> getFlowers() {
            return flowers;
        }
        abstract public void buildSetFlowers(String fileName);
    }

