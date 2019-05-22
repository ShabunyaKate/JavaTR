<<<<<<< HEAD
package by.javatr.task.creator;

import by.javatr.task.exception.GeneralException;

public class Validator {
    public static int parseOfInt(String s) throws GeneralException {
        try {
            int a= Integer.parseInt(s);
            if (a<=0){
                throw new GeneralException("Parametr must be nonnegative");
            }
            return a;
        } catch (NumberFormatException e) {
            throw new GeneralException("Not Number Format of parametr");
        }
    }
}
=======
package by.javatr.task.creator;

import by.javatr.task.exception.GeneralException;

public class Validator {
    public static int parseOfInt(String s) throws GeneralException {
        try {
            int a= Integer.parseInt(s);
            if (a<=0){
                throw new GeneralException("Parametr must be nonnegative");
            }
            return a;
        } catch (NumberFormatException e) {
            throw new GeneralException("Not Number Format of parametr");
        }
    }
}
>>>>>>> b8b1e858dae3e49ee4bc0f3e614209143df76551
