Set<C1> st = HashSet<C1>();
for (C1 obj:  st){ obj…}

Student obj = mapStudent.get(id);
Student obj = listStudent.get(0);
而setStudent则不行

ArrayList, LinkedList, HashSet, HashMap


1. Set 接口实例存储的是无序的，不重复的数据。List 接口实例存储的是有序的，可以重复的元素。

2. Set检索效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。List查找元素效率高，插入删除效率低，因为会引起其他元素位置改变。

作用域：数据存储的范围

Request作用域：相邻两个网页之间，共享一个request
pageContext作用域：当前执行页面

request.getParameter(“name”)
request.setAttribute(“key”,”name”)
request.getAttribute(“key”,”name”)


request.getContextPath()

获取servlet访问路径中的工程名（/immoc_servlet1）(创建动态web project时的名字，然后前面加/)

response.getWriter().append(“…”).append(request.getContextPath());

response.getWriter()用于想网页输出字符


String字符串””
char字符’’


**get**方式的请求参数会暴露在url链接中，而**post**不会，并且post携带的数据要比get大，也更安全，
通常提交表单数据数据时，使用的是post请求方式.



request.setAttribute("nn",xxx);
request.getRequestDispatcher(“/xx.jsp”).forward(request,response);
然后在xx.jsp中：
request.getAttribute("nn");
或者${"nn"}

`request.getParameter()`和`request.getAttribute()`的区别



```java
// 某servlet中
request.setAttribute("age", age)
this.getServletContext().setAttribute("age", age)
```

两者不同：request是表示一个请求，只要发出一个请求就会创建一个request，它的作用域：仅在当前请求中有效。所以request.setAttribute("age", age)仅存在于一次请求中，this.getServletContext().setAttribute("age", age)是将数据存储在Application，是一个全局的储存信息的空间，服务器开始就存在，服务器关闭才释放。


```jsp
<%
String path = request.getContextPath(); //path是project的名字
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
```

这样form就可以写：
```jsp
<form action="<%=basePath%>Servlet" method="post">
```

request.setAttribute(“”,xxx);
request.getRequestDispatcher(“/xx.jsp”).forward(request,response);
然后在xx.jsp中：
request.getAttribute(“”);
或者${“”}

Psvm: 主方法
command+n: generate
Contrl + command + f: next word
Contrl + command + b: previous word


四大作用域
request: 相邻页面
pageContext：本页面
session: 浏览器关闭前所有页面 (重启servlet不会丢失）
application: web容器的生命周期(重启servlet会重新计算）




80端口是HTTP常用端口，21端口主要用于FTP（File Transfer Protocol，文件传输协议）服务，22端口是ssh常用端口，3306是Mysql默认端口