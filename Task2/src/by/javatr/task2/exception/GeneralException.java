package by.javatr.task2.exception;

    public class GeneralException extends Exception{
        public GeneralException(){}
        public GeneralException(String message){
            super(message);
        }
        public GeneralException(String message, Throwable e){
            super(message,e);
        }
        public GeneralException(Throwable e) { super(e);}
    }

