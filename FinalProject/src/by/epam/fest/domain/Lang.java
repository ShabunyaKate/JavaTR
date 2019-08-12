package by.epam.fest.domain;

public enum Lang {
    US("en"),
    RU("ru"),
    DE("de");
    private String name;

    private Lang(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
