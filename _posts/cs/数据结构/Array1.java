public class Array1{

    public static void main(String[] args){
        // 生成array
        // 方法一：new int[num]
        int[] arr1 = new int[2];
        arr1[0] = 11;
        arr1[1] = 22;
        // 没有arr1[2]

        // 方法二：new int[]{.., ..}
        int[] arr2 = new int[]{11, 22};

        // 查看array
        // 方法一：
        for(int i=0; i<arr1.length; i++){
            System.out.println(arr1[i]);
        }

        // 方法二：
        for(int e:arr2){
            System.out.println(e);
        }
        
        // 例子：
        int[] arr3 = new int[5];
        for(int i=0; i<3; i++){
            arr3[i] = i;
        }
        for(int e:arr3){
            System.out.println(e);
        }
    }
}