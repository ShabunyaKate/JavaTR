package by.javatr.task3.validator;

import by.javatr.task3.exception.GeneralException;

import java.util.List;


/**Class for validating params, while threads are creating
 */
public class RunnableValidator{
    /**MAX and MIN values- range of correct count of threads
     */
    public static final int MAX_VALUE=6;
    public static final int MIN_VALUE=4;

    /**
     *check, that count of threads is in correct range
     * @param lines count of threads
     * @return correct or not
     */
    public static boolean isRangeOfLength(List<String> lines){
        if( lines.size()<=MAX_VALUE&&lines.size()>=MIN_VALUE){
            return true;
        }
        return false;
    }

    /**
     *
     * @param param - string-> parse int->int must be positive
     * @return int if positive
     * @throws GeneralException if not positive
     */
    public static int isCorrectParam(String param) throws GeneralException{
        int a=Integer.parseInt(param);
        if(a<=0) throw new GeneralException("Param number isn`t positive");
        return a;
    }
}