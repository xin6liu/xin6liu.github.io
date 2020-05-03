public class StringMethod{
    public static void main(String[] args) {
        String str = "abc-abc";

        Char c = str.charAt(2);
        String s = str.substring(2,4);

        int i = str.indexOf("b");
        int i2 = str.indexOf("b",2);

        String s2 = str.replace("a", "d");

        String[] arr = str.split("-");

        System.out.println(c);
        System.out.println(s);
        System.out.println(i);
        System.out.println(i2);
        System.out.println(s2);
        for(String e:arr){
            System.out.print(e);
        }

    }
}