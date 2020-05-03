import java.util.Arrays;

public class Array4 {

    private int[] data;
    private int size;

    public Array4(int capacity) {
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

    // 在index索引的位置插入一个新元素e
    public void add(int index, int e){
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //O(1)
    public void addLast(int e){
        add(size,e);
    }

    //O(n)
    public void addFirst(int e){
        add(0,e);
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
        Array4 arr = new Array4(4);
        System.out.println(arr);

        arr.addLast(2);
        arr.addFirst(1);
        arr.add(1, 3);
        System.out.println(arr); 
    }
    
}