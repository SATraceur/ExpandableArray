package expandablearray;

/**
 * The class implements an adaptable array of arbitrary objects, i.e., 
 * the size of the array can be increased or decreased according to the number
 * of objects to be stored. The adaptation is realized by the method add(): 
 * If the array data is fully occupied when trying to add a new object, 
 * the size of the array will be increased by allocating a larger array and 
 * using the method arraycopy() from the java.lang.System class to copy the 
 * content of the old array into the new array. Without the synchronization  
 * included, the class cannot be used concurrently by more than one thread safely. 
 * A conflict could occur if, e.g., two threads tried to perform an add() 
 * operation at the same time.
 */
public class ExpandableArray
{

    private Object[] data;
    private int size = 0;

    public ExpandableArray(int cap) { data = new Object[cap]; }

    public synchronized int size() { return size; }

    public synchronized Object get(int i) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException(i);
        }
        return data[i];
    }

    public synchronized void add(Object x) {
        if (size == data.length) { // too small
            Object[] od = data;
            //data = new Object[3 * (size + 1)/2];
            data = new Object[size + 2];
            System.arraycopy(od, 0, data, 0, od.length);
        }
        data[size++] = x;
    }

    public synchronized void removeLast() throws NullPointerException {
        if (size == 0) {
            throw new NullPointerException("Expandable Array Empty");
        }
        data[--size] = null;
    }

}
