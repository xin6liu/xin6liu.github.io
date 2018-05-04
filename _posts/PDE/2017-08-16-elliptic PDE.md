---
layout: post
author: liuxin
title: 2-elliptic PDE 的基本特征 
date: 2017-08-16
category: PDE
tags: elliptic PDE
---

Elliptic PDEs govern **steady-state equilibrium problems**, which are **boundary-value problems** in closed domains. Consequently, elliptic PDEs are solved numerically by **relaxation methods**. 在[2-PDE的分类]()一节里讲到过, elliptic PDEs 控制的问题没有 real characteristics. 物理层面上，这意味着：**1. there are no preferred paths of information propagation** and that **2. the domain of dependence and the range of influence of every point is the entire solution domain**. （第二点的意思是：The solution at every point depends on the solution at all other points, including the boundaries of the solution domain, and the solution at every point influences the solution at all other points. 第一点的意思是：The solution is continuous through out the solution domain since there are no paths along which the derivatives of the solution maybe discontinuous.）

下图是这些 general features of elliptic PDEs：
![][image-1]

可以对比一下 general features of parabolic PDEs:
![][image-2]

Every exact partial derivative in a PDE should be approximated in a manner consistent with the physical requirements of the problem. For an elliptic PDE, the solution at every point in the solution domain depends on the solution at all the other points, in particular, the immediate neighboring points. Thus, the exact partial derivatives in elliptic PDEs are approximated by **centered-difference approximations**, as discussed in Section 9.3.2. 



[image-1]:	http://wx1.sinaimg.cn/mw690/8db2c8cbly1fiye6j2652j20f70agq3t.jpg
[image-2]:	http://wx3.sinaimg.cn/mw690/8db2c8cbly1fiye6ibwyuj20o90c10xx.jpg