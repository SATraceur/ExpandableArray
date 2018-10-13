package expandablearray;

public class ExpandableArrayDriver
{

    public static void main(String[] args)
    {
        ExpandableArray ea = new ExpandableArray(1);

        System.out.println("size: " + ea.size());

        for(int i = 0; i < 1000; i++) {
           new Thread(new MyRunnable(ea)).start(); 
        }
        
        for(int i = 0; i < 10; i++) {
            ea.add(i);
            ea.get(i);
        }
        
        System.out.println("size: " + ea.size());
        
        
    }

}
