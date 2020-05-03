import java.util.Arrays;

public class Array3 {

    private int[] data;
    private int size;

    public Array3(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "Array ["
        + "data=" + Arrays.toString(data) 
        + ", size=" + getSize() 
        + ", capacity=" + getCapacity() 
        + ", isEmpty=" + isEmpty() 
        + "]";
    }

    public static void main(String[] args) {
        Array3 arr = new Array3(3);
        System.out.println(arr);
    }
    
}