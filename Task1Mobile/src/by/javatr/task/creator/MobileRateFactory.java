<<<<<<< HEAD
package by.javatr.task.creator;

import by.javatr.task.entity.MobileRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

public class MobileRateFactory {
   public static Rate create(String[] s) throws GeneralException {
        if(s.length!=5){
            throw new GeneralException("Incorrect numbers of variables in line");
        }
        MobileRate rate = new MobileRate();
        rate.setName(s[1]);

        rate.setPrice(Validator.parseOfInt(s[2]));
        rate.setPeople(Validator.parseOfInt(s[3]));
        rate.setCalls(Validator.parseOfInt(s[4]));
        Rate rate1 = rate;
        return rate1;
    }
}
=======
package by.javatr.task.creator;

import by.javatr.task.entity.MobileRate;
import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

public class MobileRateFactory {
   public static Rate create(String[] s) throws GeneralException {
        if(s.length!=5){
            throw new GeneralException("Incorrect numbers of variables in line");
        }
        MobileRate rate = new MobileRate();
        rate.setName(s[1]);

        rate.setPrice(Validator.parseOfInt(s[2]));
        rate.setPeople(Validator.parseOfInt(s[3]));
        rate.setCalls(Validator.parseOfInt(s[4]));
        Rate rate1 = rate;
        return rate1;
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
