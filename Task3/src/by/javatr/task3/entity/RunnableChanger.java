package by.javatr.task3.entity;
import java.util.concurrent.TimeUnit;

/**Runnable class
 * has unique number and resource
 */
public class RunnableChanger implements Runnable{
    /**unique positive number*/
    private int n;
    /** resource*/
    private Matrix matrix;

    /**Constructor
     * @param n-number
     * @param matrix-resource
     */
    public RunnableChanger(int n, Matrix matrix){
        this.n=n;
        this.matrix=matrix;
    }
    /** method run for thread
     * change diagonal element
     * after that sleep
     * repeat loop, while all diagonal elements will be not changed
     * */
    @Override
    public void run() {
        while(matrix.getLength()>matrix.getCOUNTER()) {
            matrix.changeValue(n);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }
}
