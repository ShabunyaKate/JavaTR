package by.epam.fest.domain;



import java.util.Locale;

public class LangHolder {
    private static LangHolder instance;
    private LangHolder(){}
    public static LangHolder getInstance(){
        if(instance == null){
            instance = new LangHolder();
        }
        return instance;
    }
    private Locale locale=new Locale(Lang.RU.getName(), Lang.RU.toString()) ;

    public void setLocale(String lang) {
        switch (lang) {
            case "ru_RU":
                locale = new Locale(Lang.RU.getName(), Lang.RU.toString());
                break;
            case "en_US":
                locale = new Locale(Lang.US.getName(), Lang.US.toString());
                break;
            case "de_DE":
                locale = new Locale(Lang.DE.getName(), Lang.DE.toString());
                break;
        }
    }
    public Locale getLocale() {
        return locale;
    }
}
