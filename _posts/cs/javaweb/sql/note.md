resources里面是放databases有关文件的。
1. 先写`mybatis-cofig.xml`文件
2. 再写需要引用的`db.properties`
3. 在resources下创建`mapper`文件夹，文件夹里创建`usersMapper.xml`(类名Mapper.xml)

```xml
<!-- `db.properties`和`usersMapper.xml`都是`mybatis-config.xml`需要引用的： -->
<configuration>
<properties resource="db.properties"></properties>
<environments>...</environments>
<mappers><mapper resource="mapper/usersMapper.xml"/></mappers>
</configuration>
```

1. `mybatis-config.xml`
2. InputStream
3. SqlSessionFactory
4. SqlSession
5. 执行配置好的SQL