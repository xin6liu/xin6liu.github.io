public class index{
    public static void main(String[] args) {
        String str = "abcdabcd";
        System.out.println(str.charAt(2));

        //没有substr();
        System.out.println(str.substring(2,4));

        System.out.println(str.indexOf("c"));
        System.out.println(str.indexOf("c",3));

        String str1 = "a,b,c";
        String[] arr = str1.split(",");
        for(String e:arr){
            System.out.println(e);
        }

        // str.concat("hh");

    }
}


