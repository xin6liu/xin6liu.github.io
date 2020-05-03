---
layout: post
title: 网络爬虫
date: 2018-06-03
category: cs
---

两种经典的网络爬虫：
1. 通用网络爬虫
2. 聚焦网络爬虫

## 通用网络爬虫
1. 初始URL
2. 新的URL
3. 将新的URL放到URL队列中
4. 从URL队列中读取新的URL
5. 满足条件时，停止爬取

## 聚焦网络爬虫
比通用网络爬虫多出三步：
1. 目标的定义
2. 无关链接的过滤
3. 下一步要爬取得URL地址的选取

    import urllib.request
    data = urllib.request.urlopen("http://www.baidu.com").read().decode("utf-8")
    print(data)

