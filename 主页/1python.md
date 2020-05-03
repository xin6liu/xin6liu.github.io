---
layout: post
title: Full Stack Web
description: 前端+后端
image: assets/images/pic01.jpg
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