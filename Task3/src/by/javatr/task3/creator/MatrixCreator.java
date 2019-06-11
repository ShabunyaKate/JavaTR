package by.javatr.task3.creator;

import by.javatr.task3.entity.Matrix;
import by.javatr.task3.exception.GeneralException;
import by.javatr.task3.validator.MatrixValidator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**Class for creating Matrix
 */
public class MatrixCreator {
    private static final Logger log= LogManager.getLogger(MatrixCreator.class);
    /**Constant separate number in rows
     */
    public static final String SEPARATOR_IN_FILE = " ";

    /**
     * @param lines List of rows
     * @param locker
     * @return Object of class Matrix, that is singletone.
     * @throws GeneralException throw,when incorrect information. A lot of check in class MatrixValidator
     */
    public static Matrix createMatrix(List<String > lines, ReentrantLock locker) throws GeneralException{
        if (!MatrixValidator.isRangeOfLength(lines)){
            throw new GeneralException("Incorrect length of matrix");
        }
        int length=lines.size();
        int[][] matrixInt=new int[length][length];
        int j=0;
        for(String line:lines){
            if(line.isEmpty()){
                throw new GeneralException("Row is empty");
            }
            String[] param = line.split(SEPARATOR_IN_FILE);
            if(!MatrixValidator.isCorrectRow(param.length,length)){
              throw new GeneralException("InCorrect row, matrix must be NхN");
            }
            for(int i=0;i<param.length;++i){
                matrixInt[j][i]=Integer.parseInt(param[i]);
            }
            ++j;
        }
        Matrix matrix=Matrix.getInstance(matrixInt,locker);
        /**First time-create new Matrix
         * Second and n-times return ref to matrix, that was created
         */
        log.info("Matrix created");

        return matrix;
    }
}
