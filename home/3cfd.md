---
layout: 3cfd
title: 计算流体力学 CFD
description: 这个专栏的文章分为三类：一类相关的基础数学和物理方面的知识总结；第二类是软件应用Ansys,Comsol等；第三类是自己的一些技巧总结。
image: assets/images/pic03.jpg
nav-menu: true
---

# 计算流体力学 CFD 

### 数学部分

<ul class="actions">
	<a href="/file/3cfd/计算流体力学/PDE" class="button">PDE</a>
	{% for post in site.posts %}
		{% if post.tags == "ansys" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
	<a href="/file/3cfd/计算流体力学/变分法" class="button">变分法</a>
	<a href="/file/3cfd/计算流体力学/有限体积法" class="button">有限体积法</a>
</ul>


### 物理部分

<ul class="actions">
	<a href="/file/3cfd/计算流体力学/流体力学" class="button">流体力学</a>
	<a href="/file/3cfd/计算流体力学/变分法" class="button">连续介质力学</a>
</ul>

> 