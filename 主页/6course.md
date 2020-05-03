---
layout: post
title: 课程 Course
description: 本专题收录了大学上的课程(数学、物理、化学、生物等)的课堂与课下笔记，但可能不是很全。
image: assets/images/pic06.jpg
nav-menu: true
---
<ul class="posts">
	{% for post in site.posts %}
		{% if post.category == "chem" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
		{% if post.category == "bio" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
</ul>
