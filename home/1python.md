---
layout: post
title: 网页开发 Web Development 
description: 前端+后端 front end + back end
image: assets/images/pic01.jpg
nav-menu: true
---

<ul class="posts">
	{% for post in site.posts %}
		{% if post.category == "web" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
</ul>