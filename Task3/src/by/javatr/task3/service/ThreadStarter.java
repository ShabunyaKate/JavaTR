package by.javatr.task3.service;

import java.util.List;

public class ThreadStarter {
    /**Start all threads in list*/
    public static void startThreads(List<Thread> threads){
        for(Thread e:threads){
            e.start();
        }
    }
}
