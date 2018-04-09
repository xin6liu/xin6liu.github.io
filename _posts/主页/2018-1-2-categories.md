---
layout: post
title: 总目录 Categories
description: 这是所有目录的汇总 All the categories are included.
image: assets/images/pic05.jpg
date : 2018-01-02
nav-menu: true
---


{% capture categories %}{% for category in site.categories %}{{ category | first }}{% unless forloop.last %},{% endunless %}{% endfor %}{% endcapture %}
{% assign category = categories | split:',' | sort %}
<h4 class="category">全部分类</h4>
<ul>
    {% for item in (0..site.categories.size) %}{% unless forloop.last %}
    {% capture word %}{{ category[item] | strip_newlines }}{% endcapture %}
    <li><a href="#{{ word }}">{{ word }}&nbsp;<sup>{{ site.categories[word].size }}</sup></a></li>
    {% endunless %}{% endfor %}
  </ul>


{% for item in (0..site.categories.size) %}{% unless forloop.last %}
{% capture word %}{{ category[item] | strip_newlines }}{% endcapture %}
<h2 class="category" id="{{ word }}">{{ word }}</h2>

{% for post in site.categories[word] %}{% if post.title != null %}
<ul><li>{{ post.date | date: "%Y-%m-%d" }}&nbsp;&nbsp;&raquo;&nbsp;&nbsp;<a href="{{ post.url }}">{{ post.title }}</a></li></ul>
{% endif %}{% endfor %}
{% endunless %}{% endfor %}
<br/><br/>


<section id="one" class="tiles">
{% for post in site.posts limit:site.tiles-count %}
<article>
                <span class="image">
                        <img src="{{ post.image }}" alt="" />
                </span>
                <header class="major">
                        <h3><a href="{{ post.url  | relative_url }}" class="link">{{ post.title }}</a></h3>
                        <p>{{ post.description }}</p>
                </header>
        </article>
{% endfor %}
</section>