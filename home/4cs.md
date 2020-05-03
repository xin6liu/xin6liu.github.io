---
layout: post
title: 计算机科学 Computer Science 
description: 分为计算机语言，软件两大类。这个专题主要是前端语言(html,css,js等)，数学软件(matlab,R等)，和标记语言(LaTeX,markdown等)的学习心得。
image: assets/images/pic04.jpg
nav-menu: true
---

<ul class="posts">
	{% for post in site.posts %}
		{% if post.category == "cs" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
</ul>