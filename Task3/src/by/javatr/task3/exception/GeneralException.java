package by.javatr.task3.exception;

/** General exception
 * exception in our task
 * can use as wrapper
 */
public class GeneralException extends Exception{
    /**
     * Class has 4 constructors
     */
    public GeneralException(){}
    public GeneralException(String message){
        super(message);
    }
    public GeneralException(String message, Throwable e){
        super(message,e);
    }
    public GeneralException(Throwable e) { super(e);}
}


