package by.javatr.thread.task4;

public class RunnerJoin {
    static{
        System.out.println("Старт потока main");
    }

    public static void main(String[] args) {
        JoinThread t1=new JoinThread("First");
        JoinThread t2=new JoinThread("Second");
        JoinThread t3=new JoinThread("Default");
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();//блокирует работу потока, в котором он вызван, до тех пор, пока не будет закончено
            //выполнение вызывающего метод потока или не истечет время ожидания при обращении к методу
           // join(long timeout).
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //Если вместо метода join() без параметров использовать версию join(long timeout), то поток
        //main будет остановлен только на указанный промежуток времени. При вызове t1.join(500) вывод
        //будет другим:
        System.out.println(Thread.currentThread().getName());
        //Статический метод currentThread() возвращает ссылку на текущий поток, т. е. на поток, в
        //котором данный метод был вызван.
    }
}
