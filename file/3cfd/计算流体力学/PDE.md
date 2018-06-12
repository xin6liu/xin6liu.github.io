---
layout: page
title: PDE
permalink: /file/3cfd/计算流体力学/PDE
---

- 离散方法
- 速度压力耦合方法

<ul class="posts">
	{% for post in site.posts %}
		{% if post.category == "PDE" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
</ul>