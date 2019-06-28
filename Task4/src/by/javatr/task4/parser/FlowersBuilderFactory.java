package by.javatr.task4.parser;

public class FlowersBuilderFactory {
    private enum TypeParser {
        DOM, SAX, STAX;
    }
    public AbstractFlowersBuilder createFlowersBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new FlowersDOMBuilder();
            case SAX:
                return new FlowersSAXBuilder();
            case STAX:
                return new FlowersStAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}

