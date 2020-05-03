torque = r * F
F = torque / r





This kind of paradoxical calculations

0.7: actual mechanical efficiency

Input voltage 减去 当转的越来越快时产生的voltage (angular velocity) = motor 真正接受到的 voltage



保持 20 mliAms = 0.02 A 以下
所有的pin 加起来 0.2 A 以下
Bule LED = 3V = 150 Ohm
Red led 另加 300ohm

Proportion P: 越大，越靠近ref. 太大会oscillates 

SPDT: Single pole, double throw

Pole: # of circuits
Throw: # of positions


速度差 —(controller)>  电压  — {(circuit)>  torque -(rotor)} ->  速度
{(circuit)->  torque -(rotor)} = {plant}





int s = 0;
  while(x>0){
    int a = x%10;
    int s = s + a;
    x = x/10;
  }
return s;

## interface

如果大部分Bird并不会飞，如果Bird这个Class里面有fly这个method的话，每次继承这个类都要override. 不如我们删掉这个Bird里面的fly方法，建立一个interface. 命名为 Flyable.

interface里面建立一个abstrct方法:
public void fly();
没有body{}

然后在其他可以飞的子类中引用这个方法




## abstract / 多态的作用

Public static void main 里面直接使用的method都得是static的。。。。

polymorphism

【接口名】 refVar = new ClassConstructor();
【类名 】refVar = new ClassConstructor();

当右边的object的Class：1.没有extends左边的类名，或者 2. 没有implements左边的接口



# string class

Data type: int, boolean…

String 其实是一个class

# 常用UML图

用例图 The Use Case Diagram （方法）
序列图 The Sequence Diagram（顺序）
类图 The Class Diagram（结构）





Auto a1 = new Car("A",1,0,2);
Auto a2 = new Car("B",2,0,3);
Auto a3 = new Truck("C",3,2,0);
Auto a4 = new Truck("D",4,3,0);
Auto a5 = new Pickup("E",5,2,3);
Auto[] carList = {a1,a2,a3,a4,a5};

可以简写为:
Auto[] carList = {new Car(“A”,1,0,2),
new Car(“B”,2,0,3), new Truck(“C”,3,2,0), 
new Truck(“D”,4,3,0), new Pickup(“E”,5,2,3)}

# error
InputMismatchException e
ArithmeticException e
Exception e





table tbody tr td

Html:5


I = 0: 1: 101[0] 0
I = 1 0: 101[1] 1 
1: 101[2] 2


元素的宽和高指的是元素中内容的宽和高，并不是元素本身(边框border)的宽和高

# eclipse快捷键
^c: 自动补充
注释：
command /
输入/**然后一回车，自动帮你生成方法和参数的注释
Command + shift + o: 自动导入包
command + 1: 自动修改

## vscode快捷键
command + 回车: 在下建立空行
Ctrl + Command + N: 复制一行
Command + J: 合并
Ctrl + A: 行首
Ctrl + D: 删除后面的所有
Ctrl + H: 删除前面的一个



Width, height 默认是 box-sizeing: content-box. 意思是：

Relative 相对于自己原来常规流中的位置偏移


宽度50%是指最近定位的祖先元素，要是没有的话就是body.

css display 属性:
1. none: 此元素不会被显示。
2. block: 此元素将显示为块级元素，此元素前后会带有换行符。
3. Inline-block: 行内块元素。


## JavaScript
`setInterval()` 方法会不停地调用函数，直到 `clearInterval()` 被调用或窗口被关闭。
由 `setInterval()` 返回的 ID 值可用作 `clearInterval()` 方法的参数。

### function的写法
    function f1(){
        ...
    }
可以写成：
    f1 = function(){
        ...
    }

这样一来就可以匿名f1:
    f1  = function(){
        console.log("haha");
    }
    setInterval("f1()",1000);
可以写成：
    setInterval(function(){
        console.log("haha")
        },1000);



通过静态map来模拟数据库，设置为静态的，就可以保证在类加载的时候就被实例化了，通过静态代码块，完成map内值的初始化，方便后面的使用。
静态变量是类变量，在类加载的时候被初始化；静态代码块当类被载入时，自动执行静态代码块，且只被执行一次经常用于类属性的初始化，模拟数据库的内容要全程使用，且在使用时要保证数据已经被初始化，否则程序会出错，因此这个地方应该使用静态的


添加
list.add(obj1);
查看
ClassName obj = (ClassName) list.get(0);
修改
list.set(0, new ClassName(“”) );
删除
list.remove(obj);
或list.remove(0);


Set 能用foreach, iterator

List 此外还能用get()方法


```java
List<C1> ls = new ArrayList<C1>();
C1 obj1 = new C1();
ls.add(obj1);
C1 temp = ls.get(0)
// 可得到ls的第0位：temp(也就是obj1)
listForEach(ls);

// 遍历：
public static void listForEach(List<C1> ls){
	for (C1 obj: ls){
		syso(obj.属性)
	}
}

Set<C2> st = new HashSet<C2>();
C2 obj2 = new C2();
st.add(obj2);
setForEach(st);

// 遍历：
public static void setForEach(Set<C2> st){
	for (C2 obj: st){
		syso(obj.属性)
	}
}
```