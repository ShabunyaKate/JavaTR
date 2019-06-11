package by.javatr.task3.creator;

import by.javatr.task3.entity.Matrix;
import by.javatr.task3.entity.RunnableChanger;
public class RunnableChangerCreator {
    /**Method create RunnableChanger
     * @param param unique number
     * @param matrix resource
     * @return object of class RunnableChanger with given params
     */
    public static RunnableChanger createRunnableChanger(int param, Matrix matrix){
       return new  RunnableChanger(param,matrix);
    }
}
