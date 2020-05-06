---
layout: 3cfd
title: 计算流体力学 CFD
description: 这个专栏的文章分为三类：一类相关的基础数学和物理方面的知识总结；第二类是软件应用Ansys,Comsol等；第三类是自己的一些技巧总结。
image: assets/images/pic03.jpg
nav-menu: true
---

## 计算流体力学 CFD 


### 数学部分
<ul class="actions">
	<a href="#pde" class="button">PDE</a>
	<ul class="hide" id="pde">
	{% for post in site.posts %}
		{% if post.tags contains "PDE" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
	</ul>
	<a href="#bff" class="button">变分法</a>
	<ul class="hide" id="bff">
	{% for post in site.posts %}
		{% if post.tags contains "变分法" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
	</ul>
	<a href="/file/3cfd/计算流体力学/有限体积法" class="button">有限体积法</a>
	<ul class="hide" id="bff">
	{% for post in site.posts %}
		{% if post.tags contains "变分法" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
	</ul>
</ul>


### 物理部分

<ul class="actions">
	<a href="/file/3cfd/计算流体力学/流体力学" class="button">流体力学</a>
	<a href="/file/3cfd/计算流体力学/变分法" class="button">连续介质力学</a>
</ul>


### 软件部分

<ul class="actions">
	<a href="/file/3cfd/计算流体力学/流体力学" class="button">Ansys</a>
	<a href="/file/3cfd/计算流体力学/流体力学" class="button">StarCMM</a>
	<a href="/file/3cfd/计算流体力学/变分法" class="button">Comsol</a>
</ul>
