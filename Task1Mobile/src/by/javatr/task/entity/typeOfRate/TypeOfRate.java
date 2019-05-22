<<<<<<< HEAD
package by.javatr.task.entity.typeOfRate;

import by.javatr.task.entity.InternetRate;
import by.javatr.task.entity.MobileInternetRate;
import by.javatr.task.entity.MobileRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import sun.java2d.loops.FillRect;

public enum TypeOfRate {
    MOBILE,
    MOBILE_INTERNET,
    INTERNET,
    DEFAULT;

    public static TypeOfRate makeType(String s) throws GeneralException {

            if (TypeOfRate.MOBILE.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.MOBILE;
            }
            if (TypeOfRate.INTERNET.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.INTERNET;
            }
            if (TypeOfRate.MOBILE_INTERNET.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.MOBILE_INTERNET;
            }
            if (TypeOfRate.DEFAULT.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.DEFAULT;
            }
            else throw new GeneralException("Not Type of rate");

    }

  public static String typeOfRate(Rate rate) {

                String type = null;
                if (rate instanceof MobileInternetRate) {
                    type = TypeOfRate.MOBILE_INTERNET.toString();
                } else if (rate instanceof InternetRate) {
                    type = TypeOfRate.INTERNET.toString();
                } else if (rate instanceof MobileRate) {
                    type = TypeOfRate.MOBILE.toString();
                } else type =  TypeOfRate.DEFAULT.toString();

        return type;
    }
}
=======
package by.javatr.task.entity.typeOfRate;

import by.javatr.task.entity.InternetRate;
import by.javatr.task.entity.MobileInternetRate;
import by.javatr.task.entity.MobileRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;
import sun.java2d.loops.FillRect;

public enum TypeOfRate {
    MOBILE,
    MOBILE_INTERNET,
    INTERNET,
    DEFAULT;

    public static TypeOfRate makeType(String s) throws GeneralException {

            if (TypeOfRate.MOBILE.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.MOBILE;
            }
            if (TypeOfRate.INTERNET.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.INTERNET;
            }
            if (TypeOfRate.MOBILE_INTERNET.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.MOBILE_INTERNET;
            }
            if (TypeOfRate.DEFAULT.toString().equalsIgnoreCase(s)) {
                return TypeOfRate.DEFAULT;
            }
            else throw new GeneralException("Not Type of rate");

    }

  public static String typeOfRate(Rate rate) {

                String type = null;
                if (rate instanceof MobileInternetRate) {
                    type = TypeOfRate.MOBILE_INTERNET.toString();
                } else if (rate instanceof InternetRate) {
                    type = TypeOfRate.INTERNET.toString();
                } else if (rate instanceof MobileRate) {
                    type = TypeOfRate.MOBILE.toString();
                } else type =  TypeOfRate.DEFAULT.toString();

        return type;
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
