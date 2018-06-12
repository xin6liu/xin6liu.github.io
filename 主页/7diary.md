---
layout: post
title: 生活 Diary
description: 一些值得记录的小事 Some thing rememberable
image: assets/images/pic07.jpg
nav-menu: true
---

<ul class="posts">
	{% for post in site.posts %}
		{% if post.category == "diary" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
</ul>
