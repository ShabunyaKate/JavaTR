package by.epam.fest.validation;


public interface Validation {

    boolean isTextForm(String str);

    boolean isEmail(String str);

    boolean isLogin(String str);

    boolean isPassword(String str);

    boolean isPhone(String str);

    boolean isValidDate(String str);

    boolean isPositiveNumber(Integer id);

    boolean isSong(String str);

    boolean isFormatFle(String str);


}
