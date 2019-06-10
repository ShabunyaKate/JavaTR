package by.javatr.task3.entity;

public class RunnableChanger implements Runnable{
    private int n;
    private Matrix matrix;
    public RunnableChanger(int n, Matrix matrix){
        this.n=n;
        this.matrix=matrix;
    }
    @Override
    public void run() {
        while(!matrix.isFinallyChanged()) {
            matrix.changeValue(n);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("эксешнон");
            }
        }
    }
}
