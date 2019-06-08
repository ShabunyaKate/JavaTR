<<<<<<< HEAD
package by.javatr.task.creator;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

public class DefaultRateFactory {
    public static Rate create(String[] s) throws GeneralException {
        if(s.length!=4){
            throw new GeneralException("Incorrect numbers of variables in line");
        }
        Rate rate = new Rate();
        rate.setName(s[1]);
        rate.setPrice(Validator.parseOfInt(s[2]));
        rate.setPeople(Validator.parseOfInt(s[3]));
        return rate;
    }
}
=======
package by.javatr.task.creator;

import by.javatr.task.entity.Rate;
import by.javatr.task.exception.GeneralException;

public class DefaultRateFactory {
    public static Rate create(String[] s) throws GeneralException {
        if(s.length!=4){
            throw new GeneralException("Incorrect numbers of variables in line");
        }
        Rate rate = new Rate();
        rate.setName(s[1]);
        rate.setPrice(Validator.parseOfInt(s[2]));
        rate.setPeople(Validator.parseOfInt(s[3]));
        return rate;
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
