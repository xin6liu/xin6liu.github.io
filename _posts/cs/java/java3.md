# 继承

`public class Dog extends Animal {}`
注意 private 不能继承

初始化顺序：
1. 父类属性
2. 父类构造方法
3. 子类属性
4. 子类构造方法

- final:

fianl类，final方法，final变量：
类不能继承，方法在子类不能覆盖，变量不许修改（常量）。

- super:

```java
//子类
public void m() {
		System.out.println(s);
		System.out.println(super.s);
	}
```

如果父类中自己写一个**有参构造方法**，那么系统就不会自动生成**无参构造方法**。子类必须写一个相同的有参的constructor: `public Dog(int a) {super(a);}`

- object 类:

1. toString: 若没有，则object返回地址哈希值，若有，则返回属性。（因为默认继承 Object 的 toString( ) 方法，输出对象地址）

2. object1.equals(object2)：若没有source生成，则判断地址是否一样，若有，则判断属性值是否一样。

两者都可以用source生成。

**obj**: 类的对象。
**obj.getClass**: 类对象。

