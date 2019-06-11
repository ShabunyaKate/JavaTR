package by.javatr.task3.controller;

import by.javatr.task3.creator.MatrixCreator;
import by.javatr.task3.creator.ThreadCreator;
import by.javatr.task3.entity.Matrix;
import by.javatr.task3.exception.GeneralException;
import by.javatr.task3.reader.EntityFileReader;
import by.javatr.task3.service.MatrixPresentation;
import by.javatr.task3.service.ThreadStarter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private static final Logger log= LogManager.getLogger(Runner.class);
    public static void main(String[] args) {
        try {
            List<String> lines = EntityFileReader.readFromFile("matrix");
            ReentrantLock locker = new ReentrantLock();
            Matrix matrix = MatrixCreator.createMatrix(lines, locker);
            MatrixPresentation.show(matrix);
            List<String> lines1 = EntityFileReader.readFromFile("threads");
            List<Thread> threads = ThreadCreator.createThreads(lines1, matrix);
            ThreadStarter.startThreads(threads);
            try {
                TimeUnit.SECONDS.sleep(15);//Main thread sleep
            } catch (InterruptedException e) {
            }
            MatrixPresentation.show(matrix);
        }catch (GeneralException e){
       log.error(e);
        }

    }
}
