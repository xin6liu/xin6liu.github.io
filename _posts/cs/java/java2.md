# 封装

## private修饰符, getter/setter方法

特点、好处：外部不能直接访问**类**里面的某些信息，只能通过规定的方式访问数据。

1. 修饰符：private
2. getter/setter 方法：用于属性的读写
3. 在 getter/setter 方法中加入**属性控制语句**：对属性的合法性进行判断

```java

public class Telephone{
    private float screen;

    public float getScreen(){
        return screen;
    }
    public void setScreen(float a){
        screen = a;
    }
}

public class InitialTelephone {
	
	public static void main(String[] args) {
		Telephone huawei = new Telephone();
		//huawei.screen 是不行的，因为screen是private属性 
		huawei.setScreen(2.3f);
		System.out.println(huawei.getScreen());
	}

}

```


## 包

包的作用：解决重名的class。格式：第一行写，package 包名。用.来区分层次。
- eg: com.imooc.MyClass 和 com.baidu.MyClass

系统的包：java.(功能).(类)
- eg: java.lang.(类) java.util.(类) java.io.(类)

不同文件夹需import
- eg: import com.imooc.MyClass


## 访问修饰符

private, 默认, protected, public
本类，同包，子类，其他

一般属性用private, 方法用public

## this
封装对象属性时，常用this关键字

```java
public void setScreen(float a){
        screen = a;
public void setScreen(float screen){
        this.screen = screen;
```
两种是等效的

## 外部类和内部类

如果外部类和内部类具有相同的成员变量或方法，内部类默认访问自己的成员变量或方法，如果要访问外部类的成员变量，可以使用 this 关键字。

```java
public class Outer{
    int a = 1;
    public class Inner{
        int a = 2;
        public void test(){
            System.out.println(a);
            System.out.println(Outer.this.a);
        }
    }
}
```

- 静态内部类`public static class SInner {}`

```java
//外部类
public class HelloWorld {
    
    // 外部类中的静态变量score
    private static int score = 84;
    
    // 创建静态内部类
	public static class SInner {
        // 内部类中的变量score
        int score = 91;
        
		public void show() {
			System.out.println("访问外部类中的score：" +           HelloWorld.score );
			System.out.println("访问内部类中的score：" + score);
		}
	}

	// 测试静态内部类
	public static void main(String[] args) {
        // 若是普通内部类：
        // HelloWorld hello = new HelloWorld();
        // SInner si = hello.new SInner();
		// 直接创建内部类的对象
        SInner si = new SInner();
        
        
        // 调用show方法
		si.show();
	}
}
```

- 方法内部类
```java
//外部类
public class HelloWorld {
    
    private String name = "爱慕课";
    
    // 外部类中的show方法
    public void show() { 
		// 定义方法内部类
		class MInner {
			int score = 83;
			public int getScore() {
				return score + 10;
			}
		}
        
		// 创建方法内部类的对象
        MInner mi = new MInner();
        
        // 调用内部类的方法
	    int newScore = 	mi.getScore();
        
		System.out.println("姓名：" + name + "\n加分后的成绩：" + newScore);
	}
    
	// 测试方法内部类
	public static void main(String[] args) {
        
		// 创建外部类的对象
        HelloWorld mo = new HelloWorld();
        
        // 调用外部类的方法
		mo.show();
	}
}
```



