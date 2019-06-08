package by.javatr.task2.entity;

public interface Entity {
    static final String DELIMETER=" ";
    int getLength();
    int leafLength();
    int matchStr(String str);
}
