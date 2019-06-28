package by.javatr.task2.entity;

import by.javatr.task2.exception.GeneralException;

import java.util.ArrayList;
import java.util.List;


public class Composite implements Component {
    private static final String PARAGRAPH_DELIMETR = "      ";
    private static final String SENTENSE_DELIMETER = ".";

    private TypeOfComposite type;
    private List<Component> partList = new ArrayList<>();

    public Composite(TypeOfComposite type) {
        this.type = type;
    }

    public Composite(List<Component> partList, TypeOfComposite type) {
        this.partList = partList;
        this.type = type;
    }

    public TypeOfComposite getType() {
        return type;
    }

    @Override
    public String toString() {
        String s = DELIMETER;
        if (TypeOfComposite.PARAGRAPH.equals(type)) {
            s = PARAGRAPH_DELIMETR;
        }
        if (TypeOfComposite.SENTENSE.equals(type)) {
            s = SENTENSE_DELIMETER;
        }
        for (Component e : partList) {
            s = s + e.toString();
        }
        return s;
    }

    @Override
    public int matchStr(String str) {
        int matcher = 0;
        for (Component e : partList) {
            matcher += e.matchStr(str);
        }
        return matcher;
    }

    @Override
    public int getLength() {
        return partList.size();
    }

    public Component getElement(int i) throws GeneralException {
        if (i >= getLength()) throw new GeneralException("Index out of range");
        return partList.get(i);
    }

    public Composite getCompositeElement(int i) throws GeneralException {
        if (getElement(i) instanceof Composite) {
            return (Composite) getElement(i);
        } else throw new GeneralException("Element isnt composite");
    }

    @Override
    public int leafLength() {
        int length = 0;
        for (Component e : partList) {
            length += e.leafLength();
        }
        return length;
    }

    public List<Component> copyEntity() {
        List<Component> copyPartList = new ArrayList<>();
        for (Component e : partList) {
            copyPartList.add(e);
        }
        return copyPartList;
    }

    public void add(Component component) {
        partList.add(component);
    }

    public void remove(Component component) {
        partList.remove(component);
    }

}

