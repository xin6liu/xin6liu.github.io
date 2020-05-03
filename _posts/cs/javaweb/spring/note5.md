## 1. Controller, HandlerMapping 映射（可注解，可xml）
## 2. ViewResolver 映射 （可xml）



在spirngboot中必须导入
```xml
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>1.2.0</version>
		</dependency>
```
@Mapper才能用

```xml
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
	<version>6.0.6</version>
</dependency>
```
jdbc连接Driver才不会报错



@Autowired的作用：
public class Boss {
    @Autowired
    private Car car;
    @Autowired
    private Office office;}
这样配置class="com.liuxin.entity.Boss"这个bean的时候就不用再：
<property name="car" ref="car"/>
<property name="office" ref="office" />


@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。

1)如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，配置的视图解析器InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。

例如：本来应该到success.jsp页面的，则其显示success.

2)如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
3)如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解。

要想返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解，这样如果多个方法都要返回JSON，XML或自定义mediaType内容到页面那么就需要每个方法上面加@ResponseBody注解，而@RestController注解这个注解恰好解决这个问题，在想要返回JSON，XML或自定义mediaType内容到页面时候就不用写@Controller加上一个@ResponseBody注解了，其实@RestController就相当于@Controller和@ResponseBody的合并

如果一个类中都是处理的Ajax请求,返回json串或者其他非页面地址内容,就可以在类上使用@RestController注解. 要是需要返回页面地址,就要使用@Controller注解


- @Component, @Service, @Controller, @Repository是spring注解，注解后可以被spring框架所扫描并注入到spring的bean容器来进行管理 
- @Component是通用注解，其他三个注解是这个注解的拓展，并且具有了特定的功能 
- @Repository注解在持久层中，具有将数据库操作抛出的原生异常翻译转化为spring的持久层异常的功能。 
- @Controller层是spring-mvc的注解，具有将请求进行转发，重定向的功能。 
- @Service层是业务逻辑层注解，这个注解只是标注该类处于业务逻辑层。 
- 用这些注解对应用进行分层之后，就能将请求处理，义务逻辑处理，数据库操作处理分离出来，为代码解耦，也方便了以后项目的维护和开发。


@Autowired按byType自动注入，而@Resource默认按byName自动注入罢了。@Resource有两个属性是比较重要的，分别是name和type，Spring将@Resource注解的name属性解析为bean的名字，而type属性则解析为bean的类型。所以如果使用name属性，则使用byName的自动注入策略，而使用type属性时则使用byType自动注入策略。如果既不指定name也不指定type属性，这时将通过反射机制使用byName自动注入策略。 

@Resource装配顺序:

- 如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常
- 如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常
- 如果指定了type，则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
- 如果既没有指定name，又没有指定type，则自动按照byName方式进行装配（见2）；如果没有匹配，则回退为一个原始类型（UserDao）进行匹配，如果匹配则自动装配；


**装饰模式 Decorator Pattern** 和**代理模式 Proxy Pattern**的相同和区别：
1. decorator 和 proxy 都是要继承原接口的
2. 但proxy里要new一个接口的实现类
3. 而decorator里只需要声明原接口就行了，在客户端决定是哪个实现类输入（也有可能是修饰过的实现类）
4. 代理模式主要是控制对某个特定对象访问，而装饰模式主要是为了给对象添加行为。