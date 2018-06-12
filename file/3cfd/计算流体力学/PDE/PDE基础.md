---
layout: page
title: PDE基础
permalink: /目录catalog/计算流体力学/PDE/PDE基础
---

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