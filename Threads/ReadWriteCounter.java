package Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    private int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try{
            count++;
            Thread.sleep(50);
        }catch (Exception e){

        }finally {
            writeLock.unlock();
        }
    }

    public int getCount() {
        readLock.lock();
        try{
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
