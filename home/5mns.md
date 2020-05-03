---
layout: post
title: 纳米科学 Nanoscience
description: 本科专业
image: assets/images/pic05.jpg
date : 2020-01-05
nav-menu: true
---

<ul class="posts">
	{% for post in site.posts %}
		{% if post.category == "mns" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
</ul>