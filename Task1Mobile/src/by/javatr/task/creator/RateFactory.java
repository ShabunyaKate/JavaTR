<<<<<<< HEAD
package by.javatr.task.creator;

import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;

public class RateFactory {
    public static Rate creator(TypeOfRate type, String[] s) throws GeneralException {
        Rate rate = null;
        switch (type) {
            case MOBILE:
                rate = MobileRateFactory.create(s);
                break;
            case INTERNET:
                rate = InternetRateFactory.create(s);
                break;
            case MOBILE_INTERNET:
                rate = MobileInternetRateFactory.create(s);
                break;
            case DEFAULT:
                rate = DefaultRateFactory.create(s);
                break;

                default: throw new GeneralException();
        }
        return rate;
    }









=======
package by.javatr.task.creator;

import by.javatr.task.entity.Rate;
import by.javatr.task.entity.typeOfRate.TypeOfRate;
import by.javatr.task.exception.GeneralException;

public class RateFactory {
    public static Rate creator(TypeOfRate type, String[] s) throws GeneralException {
        Rate rate = null;
        switch (type) {
            case MOBILE:
                rate = MobileRateFactory.create(s);
                break;
            case INTERNET:
                rate = InternetRateFactory.create(s);
                break;
            case MOBILE_INTERNET:
                rate = MobileInternetRateFactory.create(s);
                break;
            case DEFAULT:
                rate = DefaultRateFactory.create(s);
                break;

                default: throw new GeneralException();
        }
        return rate;
    }









>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
}