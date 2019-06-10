package by.javatr.task3.controller;

import by.javatr.task3.entity.Matrix;
import by.javatr.task3.entity.RunnableChanger;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    public static void main(String[] args) {
        ReentrantLock locker=new ReentrantLock();
        Matrix matrix=Matrix.getInstance(8,locker);
        matrix.show();
        RunnableChanger changer1=new RunnableChanger(100,matrix);
        RunnableChanger changer2=new RunnableChanger(200,matrix);
        RunnableChanger changer3=new RunnableChanger(300,matrix);
        RunnableChanger changer4=new RunnableChanger(400,matrix);
        RunnableChanger changer5=new RunnableChanger(500,matrix);
        RunnableChanger changer6=new RunnableChanger(600,matrix);
        Thread thread6=new Thread(changer6);
        Thread thread5=new Thread(changer5);
        Thread thread1=new Thread(changer1);
        Thread thread2=new Thread(changer2);
        Thread thread3=new Thread(changer3);
        Thread thread4=new Thread(changer4);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e){
            System.out.println("Эусепшон в мейне");
        }
        matrix.show();
    }
}
