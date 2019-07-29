package by.epam.fest.domain;


public enum TicketType {
    VIP("vip"),
    FAN_ZONE("fan_zone"),
    DANCE_FlOOR("dance_FLOOR");


    private String type;

    private TicketType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Integer getId() {
        return ordinal();
    }

    public static TicketType getById(Integer id) {
        return TicketType.values()[id];
    }
}