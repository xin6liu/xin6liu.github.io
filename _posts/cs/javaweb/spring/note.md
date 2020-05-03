### ProductDao.java
包: com.imooc
目标类名: ProductDao
方法: delete, save 

### MyAspect.java
```java
@Aspect
public class MyAspect {
    @Before(value ="execution(* com.imooc.ProductDao.save(..))")
    public void before(){
        System.out.println("前置advice");
    }
}
```
### applicationContext.xml
```java
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop" xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd">
    <aop:aspectj-autoproxy/>

    <bean id="pd" class="com.imooc.ProductDao"></bean>
    <bean class="com.imooc.MyAspect"></bean>
</beans>
```

### Test.java
```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test {
    @Resource(name = "pd")
    private ProductDao p;
    @Test
    public void test1(){
        p.delete();
        p.save();
    }
}