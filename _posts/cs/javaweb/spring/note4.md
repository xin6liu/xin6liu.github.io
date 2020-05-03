# 单独mybatis，不带web

### 1. [pom.xml]
mybatis, mysql-connector-java

### 2. 在resources里建立[mybatis-config.xml]
mybatis-config.xml由configuration包裹，里面包括三部分：properties, environments, mappers
```xml
<properties resource="db.properties"></properties>
<environments>...</environments>
<mappers><mapper resource="mapper/userMapper.xml"></mappers>
```
可以看出我们接下来要在resources里建立[db.properties]和[mapper/userMapper.xml]

### 3. [db.properties]:
driver=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8
username=root
password=307715

### 4. [mapper/userMapper.xml]和[User.java]:
User是等会儿要建立的entity实体类名字, 也是mysql里面表的名字
```xml
<mapper namespace="com.liuxin.entity.User">
    <select id="findAll" resultType="com.liuxin.entity.User">
        select * from user
    </select>
</mapper>
```
com.liuxin.entity.User.java里：
```java
private Integer uid;
private String username;
private String password;
private String name;
```

### Test文件
```java
SqlSessionFactory factory =
    new SqlSessionFactoryBuilder().build
    (Resources.getResourceAsStream("mybatis.xml"));
SqlSession session = factory.openSession();

List<User> userList = session.selectList("findAll");
for(User u:userList){
    System.out.println(u);
}

session.close();
```


# mybatis + web
前四步都一样，最后一步测试可以拆开到几个文件里：
SqlSessionFactoryUtils.java, 
InitSqlSessionListener.java,
UserDao.java

SqlSessionFactoryUtils.java