总项目名称ssm, 每个java包里都建立com.liuxin.ssm这个包
ssm创建顺序：
dao, biz, web（选择maven-web配置） 层建好

# dao层
## pom.xml:
mysql-connector-java, mybatis, 
spring-core, spring-beans, spring-context, spring-jdbc, mybatis-spring
## resources
mybatis-fonfig.xml, db.propertise, 
com/liuxin/ssm/dao -> DepartmentDao.xml 
## java
com.liuxin.ssm.entity -> Department.java
com.liuxin.ssm.dao -> DepartmentDao.java

# biz层
## pom.xml:
test_ssm_dao, spring-tx, spring-aop, aspectjweaver
## resources
spring-biz.xml
## java
com.liuxin.ssm.biz -> DepartmentBiz.java
com.liuxin.ssm.biz.impl -> DepartmentBizImpl.java

# web层
## pom.xml:
test_ssm_biz, javax.servlet-api, jstl, spring-web, spring-webmvc
## resources
spring-web.xml
## webapp
WEB-INF -> web.xml, /WEB-INF/pages -> list.jsp
## java
com.liuxin.ssm.controller -> DepartmentController.java



### DepartmentDao.java
```java
@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void update(Department department);
    void delete(String sn);
    Department select(String sn);
    List<Department> selectAll();
}
```
### DepartmentBizImpl.java
```java
@Service("departmentBiz")
public class DepartmentBizImpl implements DepartmentBiz {
    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public void remove(String sn) {
        departmentDao.delete(sn);
    }

    public Department get(String sn) {
        return departmentDao.select(sn);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
```
### DepartmentController.java
```java
@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",departmentBiz.getAll());
        return "department_list";
    }

}