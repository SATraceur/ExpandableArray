package expandablearray;

public class MyRunnableGood implements Runnable {

    private ExpandableArray ea;
    
    public MyRunnableGood(ExpandableArray ea) {
        this.ea = ea;
    }
    
    @Override
    public void run() {
        
        synchronized(this) {
            for(int i = 0; i < 50; i++) {
               System.out.println(Thread.currentThread().getName() + " adding " + i + " to array ");
               ea.add(i); 
               System.out.println(Thread.currentThread().getName() + " getting " + ea.get(i));
            }
        }
    }
    
}
