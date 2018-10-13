    package expandablearray;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

    public class MyRunnable implements Runnable {

    private ExpandableArray ea;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock readLock = readWriteLock.readLock();
    private Lock writeLock = readWriteLock.writeLock();


    public MyRunnable(ExpandableArray ea) {
        this.ea = ea;
    }

    @Override
    public void run() {


            for(int i = 0; i < 50; i++) {   
                        
               ea.add(Thread.currentThread().getName() + " " + i); 
               ea.removeLast();
               System.out.println(ea.size());

            }
            
            
    }

}
