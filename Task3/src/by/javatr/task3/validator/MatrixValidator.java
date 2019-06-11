package by.javatr.task3.validator;

import java.util.List;

/**Class for validating params, while matrix is creating
 */
public class MatrixValidator {
    /**MAX and MIN values- range of correct matrix size
     */
    public static final int MAX_VALUE=12;
    public static final int MIN_VALUE=8;

    /**
     *check, that count of rows is in correct range
     * @param lines count of rows
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
     * @param param length of row
     * @param length length of columns
     * @return is correct rows,will be matrix square or not
     */
    public static boolean isCorrectRow(int param,int length){
        if(param==length){
            return true;
        }
        else return false;
    }
}
