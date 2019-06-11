package by.javatr.task3.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

/**Class wrapper for matrix
 * Singletone
 * rows=columns=n
 * diagonal elements = 0
 */
public class Matrix {
    private static final Logger log= LogManager.getLogger(Matrix.class);
    /**instance-ref to object(singletone)*/
    private static Matrix instance;
    public static final int ZERO=0;

    private int[ ][ ] matrix;
    /** length of matrix*/
    private int length;

    private ReentrantLock locker;
    /** Counter for changing element*/
    private  int COUNTER=0;

    /**
     * @param i row coordinate
     * @param j column coordinate
     * @return element on position i, j
     */
    public int getElement(int i,int j){
        return matrix[i][j];
    }
    public  int getCOUNTER() {
        return COUNTER;
    }

    public int getLength(){
        return length;
    }
    /**synchronised singletone*/
    public static Matrix getInstance(int[][] matrix, ReentrantLock locker) {
        if (instance == null) {
            locker.lock(); {
                if (instance == null) {
                    instance = new Matrix(matrix, locker);
                }
            }
            locker.unlock();
        }
        return instance;
    }

      private Matrix(int[][] matrix,ReentrantLock locker) {
        this.matrix=matrix;
        this.length=matrix.length;
        this.locker=locker;
        /** 0 will be in diagonal positions*/
        this.clearDiagonal();
    }
    /** clear element in diagonal positions(make 0)*/
    private void clearDiagonal(){
        for(int i=ZERO;i<length;i++){
            matrix[i][i]=ZERO;
        }
    }
    /**@metod changed diagonal elements(for threads)
     * synchronised(lockers)
     * change only one time - one position
     * @param threadN-is unique number of thread, that replace zero
     */
    public void changeValue(int threadN) {
        locker.lock();
        for (int i =COUNTER; i < length; i++) {
            if(matrix[i][i]==ZERO) {
                matrix[i][i] = threadN;
                log.info(Thread.currentThread().getName()+" changed element in position["+i+","+i+"]");
                ++COUNTER;
                break;
            }
        }
        locker.unlock();
    }
}