### 1. 总pom.xml
spring-version: 4.0.2.RELEASE

### 2.1 **service** 这个module的pom.xml：
- packaging: jar
- mybatis: mysql-connector-java, mybatis
- spring: spring-core, spring-beans, spring-context, spring-aop, aspectjweaver
- transection: spring-jdbc, spring-tx, mybatis-spring

### 2.2 **web** 这个module的pom.xml:
- packaging: war
- service
- javax.servlet-api
- jstl

### 3.1 **service** moudule: 
java(com.liuxin.projectname)包里放**dao,entity,service**, resources包里放**spring.xml**。

### 3.2 **web** moudule:
java(com.liuxin.projectname)包里放**controller,global**, webapp包里放**css,images,js,pages,web.xml**。

### 4. **spring.xml配置**：
<!-- spring整合mybatis -->
- org.springframework.jdbc.datasource.DriverManagerDataSource (dataSource)
- org.mybatis.spring.SqlSessionFactoryBean (sqlSessionFactory)
* dataSource(dataSource), typeAliasesPackage(entity)
- org.mybatis.spring.mapper.MapperScannerConfigurer
* sqlSessionFacotryBeanName(sqlSessionFactory), basePackage(dao)
<!-- 声明式事务 -->
- org.springframework.jdbc.datasource.DataSourceTransactionManager (transactionManager)
* dataSource(dataSource)
- tx:advice (txAdvice)
- aop:config 
* aop:pointcut "execution(* com.liuxin.projectname.service.*.*(..))" (txPointcut)
* aop:advisor txAdvice,txPointcut
<!-- 全局扫描 -->
- context:component-scan "com.liuxin.projectname"
- aop:aspectj-autoproxy





### 部门信息增删改查
1. 实体类：Department.java
2. 吃阶层：DepartmentDao.java(interface), DepartmentDao.xml(mapper) 
mapper的<resultMap>把实体类和mysql表格对应起来，
mapper的<insert><delete><update><select>实现Dao接口具体SQL语句方法。
3. 业务层: DepartmentService.java(interface), DepartmentServiceImpl.java
DepartmentServiceImpl.java里需要引入持久层，所以：
DepartmentDao.java里注释`@Repository("departmentDao")`
DepartmentServiceImpl.java里注释`@Service("departmentService")`
然后就可以在DepartmentServiceImpl.java里直接引用departmentDao这个bean了：
```java
@Autowired
private DepartmentDao departmentDao;
// 不用再重新new DepartmentDao()来实现departmentDao了
public void add(Department department){
    departmentDao.insert(department);
    // departmentDao的insert方法是在DepartmentDao.xml(mapper)里写的
}
public void remove(Integer id){
    departmentDao.delete(id);
}
```

4. controller, 页面
