public class Array2 {

    //1. 首先声明全局变量data, size;
    //2. constructor输入capacity, 初始化data和size
    //3. 3个基本函数：getCapacity, getSize, isEmpty

    private int[] data;
    private int size;

    public Array2(int capacity){
        data = new int[capacity];
        size = 0;
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        Array2 arr = new Array2(3);

        int capacity = arr.getCapacity();
        int size = arr.getSize();
        boolean b = arr.isEmpty();

        for(int e:arr.data){
            System.out.println(e);
        }

        System.out.println("capacity: "+capacity);
        System.out.println("size: "+size);
        System.out.println("b: "+b);

    }
    
}