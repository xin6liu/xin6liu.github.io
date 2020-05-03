# 开发准备：
JDK, MAVEN, TOMCAT
1. 创建后报错找不到“HttpServlet”：properties -> java build path -> libraries -> add library -> server runtime -> Tomcat
2. 警告当前执行环境是J2SE-1.5 而装的JRE是1.8：
改动pom.xml
	<build>
		<finalName>o3o</finalName>
		<plugins>
			<plugin>
				<!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-compiler-plugin -->
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.6.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>UTF8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>
3. Maven规定，必须创建以下几个Source Folder
    src/main/resources
    src/main/java
    src/test/resources
    src/test/java
   点击项目右键-->new-->Source Folder 添加以上的Source Folder
4. O3o/.settings/org.eclipse.wst.common.project.facet.core.xml 里面jst.web 2.3改为3.1
5. Web-app头文件也改为3.1:
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1" metadata-complete="true">
6. 添加  
<welcome-file-list>
  	<welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
7. 把o3o加入Tomcat, 运行，打开 localhost:8080/o3o/