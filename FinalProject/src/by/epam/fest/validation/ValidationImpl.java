package by.epam.fest.validation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class ValidationImpl implements Validation {
    private ValidationImpl() {
    }

    private static class LazyHolder {
        public static final ValidationImpl INSTANCE = new ValidationImpl();
    }

    public static ValidationImpl getInstance() {
        return ValidationImpl.LazyHolder.INSTANCE;
    }

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String TEXT_PATTERN = "^[а-яА-ЯёЁa-zA-Z ]+$";
    private static final String LOGIN_PATTERN = "^[а-яА-ЯёЁa-zA-Z0-9]+$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]{8,25}$";
    private static final String PHONE_PATTERN = "^\\+[1-9]{1}[0-9]{3,14}$";
    private static final String SONG_PATTERN ="^[а-яА-ЯёЁa-zA-Z0-9 ]+$";
    private static final String FILE_PATTERN ="(.*)\\.(png|jpeg|jpg)$";

    @Override
    public boolean isTextForm(String str) {
        return Pattern.matches(TEXT_PATTERN, str);
    }

    @Override
    public boolean isEmail(String str) {
        return Pattern.matches(EMAIL_PATTERN, str);
    }

    @Override
    public boolean isLogin(String str) {
        return Pattern.matches(LOGIN_PATTERN, str);
    }

    @Override
    public boolean isPassword(String str) {
        return Pattern.matches(PASSWORD_PATTERN, str);
    }

    @Override
    public boolean isPhone(String str) {
        return Pattern.matches(PHONE_PATTERN, str);
    }

    @Override
    public boolean isSong(String str) {
       if (!str.trim().isEmpty()){
           return false;
       }
        return Pattern.matches(SONG_PATTERN, str);
    }

    @Override
    public boolean isFormatFle(String str) {
        return Pattern.matches(FILE_PATTERN, str);
    }

    @Override
    public boolean isValidDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                format.parse(str);
                return true;
            }
            catch(ParseException e){
                return false;
            }
        }

    @Override
    public boolean isPositiveNumber(Integer id) {
        if(id>=0) {
            return true;
        } else return false;
    }
}

