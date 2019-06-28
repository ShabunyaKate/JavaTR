package by.javatr.task4.entity;

public enum  FlowerEnum{
    FLOWERS("flowers"),
    ID("id"),
    SOIL("soil"),
    MULTIPLYING("multiplying"),
    FLOWER("flower"),
    NAME("name"),
    ORIGIN("origin"),
    STALK_COLOR("stalk_color"),
    LEAF_COLOR("leaf_color"),
    FLOWER_SIZE("flower_size"),
    TEMPERATURE("temperature"),
    PHOTOPHILIOUS("photophilious"),
    WATERING("watering"),
    LANDING_DATE("landing_date"),
    VISUAL_PARAM("visual_param"),
    GROWING_TIPS("growing_tips");
    private String value;
    private FlowerEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}