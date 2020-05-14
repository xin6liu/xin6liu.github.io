```java
String s = "abcd";
for (int len=s.length(); len >= 1; len--){
    for (int i=0; i+len<=s.length(); i++){
        int left = i, right = i+len-1;
        System.out.println(left);
        System.out.println(right);
        System.out.println("");
    }
    System.out.println("======");
}
```
先最长，后最短
```
0
3

======
0
2

1
3

======
0
1

1
2

2
3

======
0
0

1
1

2
2

3
3

======
```


```java
public class HelloWorld{
    
    public static String longestPalindrome(String s) {
        // write your code here
        if (s.equals("")){
            return "";
        }
        
        String longest = "";
        for (int center = 0; center < s.length(); center++){
            // System.out.println(s.charAt(center));
            String odd = getPalindrome(s, center-1, center+1);
            if (odd.length() > longest.length()){
                longest = odd;
            }
            // System.out.println("------");
            String even = getPalindrome(s,center, center+1);
            if (even.length() > longest.length()){
                longest = even;
            }
            // System.out.println("======");
        }
        
        return longest;
    }
    
    public static String getPalindrome(String s, int left, int right){
        // System.out.println(left);
        // System.out.println(right);
        while(left != -1 && right != s.length() && s.charAt(left) == s.charAt(right)){
            // System.out.println(s.charAt(left));
            // System.out.println(s.charAt(right));
            left--;
            right++;
        }
        // System.out.println(s.substring(left+1,right));
        return s.substring(left+1,right);
    }

    public static void main(String []args){
        String s = "abadd";
        String result = longestPalindrome(s);
        System.out.println(result);
    }
}
```




