package by.javatr.task3.entity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Matrix {
    private static Matrix instance;
    private int[ ][ ] a;
    private int n;
    private boolean[] keysModified;
    private ReentrantLock locker;

    public static Matrix getInstance(int nn, ReentrantLock locker) {
        if (instance == null) {
            synchronized (Matrix.class) {
                if (instance == null) {
                    instance = new Matrix(nn, locker);
                }
            }
        }
        return instance;
    }

      private Matrix(int nn,ReentrantLock locker) {
        n = nn;
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = (int)(Math.random() * 5);
            }
        }
        keysModified=new boolean[n];
        this.locker=locker;
    }
    public Matrix(int[][] a){
        this.a=a;
        this.n=a.length;
    }
    public void show(){
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }
    public void changeValue(int threadN) {
        locker.lock();
        for (int i = 0; i < n; i++) {
            if (!keysModified[i]) {
                a[i][i] = threadN;
                keysModified[i] = true;
                break;
            }
        }
        locker.unlock();
    }
    public boolean isFinallyChanged(){
        for (int i = 0; i < n; i++) {
            if (!keysModified[i]) {
                return false;
            }
        }
      return true;
    }
}