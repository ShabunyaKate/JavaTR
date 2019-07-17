package by.epam.musician.domain;

public enum Role {
    ADMINISTRATOR("administrator"),
    MUSICIAN("musician"),
    USER("user");

    private String name;

    private Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return ordinal();
    }

    public static Role getById(Integer id) {
        return Role.values()[id];
    }
}