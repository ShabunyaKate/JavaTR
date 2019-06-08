package by.javatr.thread.task5;

import by.javatr.thread.task3.PriorThread;

public class Runner {
    public static void main(String[ ] args) {
        System.out.println("Главный поток начал работу...");
        PriorThread min = new PriorThread("Min");
        PriorThread max = new PriorThread("Max");
        PriorThread norm = new PriorThread("Norm");
        min.setPriority(Thread.MIN_PRIORITY); // 1
        max.setPriority(Thread.MAX_PRIORITY); // 10
        norm.setPriority(Thread.NORM_PRIORITY); // 5
        min.start();
        norm.start();
        max.start();
       /*
        try {
// если надо, чтобы вызвавший поток завершился последним
            min.join();
            norm.join();
            max.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        */
        System.out.println("Главный поток завершил работу...");
    }
}
