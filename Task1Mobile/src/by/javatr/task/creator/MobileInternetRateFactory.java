
package by.javatr.task.creator;

import by.javatr.task.entity.MobileInternetRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

public class MobileInternetRateFactory {
    public static Rate create(String[] s) throws GeneralException {
        if (s.length != 6) {
            throw new GeneralException("Incorrect numbers of variables in line");
        }
        MobileInternetRate rate = new MobileInternetRate();
        rate.setName(s[1]);

        rate.setPrice(Validator.parseOfInt(s[2]));
        rate.setPeople(Validator.parseOfInt(s[3]));
        rate.setCalls(Validator.parseOfInt(s[4]));
        rate.setInternet(Validator.parseOfInt(s[5]));
        Rate rate1 = rate;
        return rate1;
    }

}
package by.javatr.task.creator;

import by.javatr.task.entity.MobileInternetRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

public class MobileInternetRateFactory {
    public static Rate create(String[] s) throws GeneralException {
        if(s.length!=6){
            throw new GeneralException("Incorrect numbers of variables in line");
        }
        MobileInternetRate rate = new MobileInternetRate();
        rate.setName(s[1]);

        rate.setPrice(Validator.parseOfInt(s[2]));
        rate.setPeople(Validator.parseOfInt(s[3]));
        rate.setCalls(Validator.parseOfInt(s[4]));
        rate.setInternet(Validator.parseOfInt(s[5]));
        Rate rate1 = rate;
        return rate1;
    }

        }

