---
layout: post
author: liuxin
title: 2-变分法近似解法
date: 2017-08-02
category: 变分法
tags: calculus of variations 
---


## 强解

![][image-1]

## 弱解

![][image-2]

将微分方程乘以一个权函数（基函数），然后令加权积分为零

在弱形式中，我们将乘的这个函数称为检验函数(test function)，用V￼表示。

![][image-3]

第一项积分内y是二次微分而检验函数v是零次微分。如果使用分部积分，就可以将一次微分转移到检验函数v上，这样y的近似解函数只需是一阶线性的而不用是二次的了。通过分部积分可得：

![][image-4]

最后得到加权积分(弱形式)：

![][image-5]

反求出I，我们知道 I 的一阶变分，与上面的加权积分形式是一样的。原来，$\delta y$ 就是v。

![][image-6]

## Example2:

![][image-7]

> ![][image-8]

![][image-9]

![][image-10]

强解解法：

![][image-11]

## 总结

![][image-12]

## 注释

![][image-13]

[image-1]:	http://wx2.sinaimg.cn/mw690/8db2c8cbgy1ficnnlgy4dj20i60egtb9.jpg
[image-2]:	http://wx3.sinaimg.cn/mw690/8db2c8cbly1fiaw27g8gij20jb02rmxn.jpg
[image-3]:	http://wx4.sinaimg.cn/mw690/8db2c8cbgy1fiawxi3fzzj20kt050js0.jpg
[image-4]:	http://wx4.sinaimg.cn/mw690/8db2c8cbgy1fiawxjy0huj20kq02wwev.jpg
[image-5]:	http://wx3.sinaimg.cn/mw690/8db2c8cbgy1fiawxlswh9j20i101y0su.jpg
[image-6]:	http://wx4.sinaimg.cn/mw690/8db2c8cbgy1fiaythj8auj20gx04aq3f.jpg
[image-7]:	http://wx3.sinaimg.cn/mw690/8db2c8cbgy1fiaytj4a0wj20g605djs0.jpg
[image-8]:	http://wx3.sinaimg.cn/mw690/8db2c8cbgy1fickqggrnrj20dn067t9k.jpg
[image-9]:	http://wx3.sinaimg.cn/mw690/8db2c8cbgy1fickqifcsij20fx0e3jtb.jpg
[image-10]:	http://wx2.sinaimg.cn/mw690/8db2c8cbgy1fickqkcv6zj20gj05yt9l.jpg
[image-11]:	http://wx2.sinaimg.cn/mw690/8db2c8cbgy1ficnnnkdnqj20hl0cc763.jpg
[image-12]:	http://wx2.sinaimg.cn/mw690/8db2c8cbgy1ficubsrdtgj20ei0af3zu.jpg
[image-13]:	http://wx1.sinaimg.cn/mw690/8db2c8cbly1fiaw28zmuej20iy05h74w.jpg