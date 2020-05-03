---
layout: post
author: liuxin
title: 2-PDE的分类
date: 2017-08-12
category: PDE
tags: partial differential equations 
---

## 分类

结合物理问题，

* a single first-order PDE: 极少数
* a system of first-order PDEs：许多
* a single second-order PDE：一些
* a system of second-order PDEs：许多

PDE的分类就从**a single second-order PDE** 来解释比较容易。
所以在接下来的讨论中，最先分类的是 the **general quasilinear second-order non-homogenous PDE in two independent variables.**
也就是：$$ Af_{xx} + Bf_{xy} + Cf_{yy} + Df_x + Ef_y + Ff = G $$

上面这个式子可以分三类，而分类的依据是(discriminant)判别式: $B^2 - 4AC$

![][image-1]

**Classification** 由 **Characteristics** 决定。
PDE 的 characteristics 就是 (n-1)-dimensional **hyper-surfaces** in n-dimensional **hyper-space** that have some very special features.

hyper 指的是不止三维，也就是 xyzt spaces, and curves and surfaces within those spaces. 

在二维空间里，characteristics 是在solution domain中的paths (一般来说是曲线)，而 information 就沿着这些 paths 传播。

如果一个PDE具有 real characteristics, 那么信息就会沿着这些 characteristics 传播。如果没有 real characteristics，那么就没有信息传播的 preferred paths. 

所以说， 有没有characteristics对PDE的解有着重要影响。

Connection is the process in which a physical property is propagated through space by the motion.

也就是说，motion of the medium occupying the space.

fluid flow 是一个常见的 convection 例子

The convection of **a property f** of a fluid particle in one dimension:

$$f_t + u f_x = 0$$

u 就是 convection velocity.

a moving fluid particle carries (convects) its mass, momentum, and energy with it as it moves through space. 

上式(convection equation)还可写为：

$$ f_t + \frac{dx}{dt} f_x = 0  $$

而很明显，$ f_t + \frac{dx}{dt} f_x = \frac{df}{dt}$，所以$\frac{df}{dt} = 0$, f 为常数。

一个方法就是回答以下问题：在solution domain D(x,y) 中能不能找到一个路径，这个路径经过点P，二阶导$f_{xx}$ $f_{xy}$ $f_{yy}$是 multivalued 或 discontinuous? 如果这些paths 存在，那么这些paths就是信息传播的paths，也就是characteristics! 

![][image-2]

通过cramer’s法则可以得到无数的$f_{xx}$ $f_{xy}$ $f_{yy}$ 的值, 这样就没有物理意义了。所以我们把 determinant of the coefficient matrix 设为0

![][image-3]

如果这两组curves存在，它们就是原PDE的characteristic paths

Elliptic PDEs have no real characteristic paths, parabolic PDEs have one real repeated characteristic path, and hyperbolic PDEs have two real distinct characteristic paths. 

### domain of dependence 和 range of influence

假设 solution domain 上有一点P。

点P的 **domain of dependence** 定义为$f(x_p,y_p)$决定的region of the solution domain。注：$f(x_p,y_p)$ 是位于点P的解。也就是说，$f(x_p,y_p)$ 决定了在domain of dependence  发生的一切。

点P的 **range of influence** 定义为 $f(x_p,y_p)$ 影响的 region of solution domain。也就是说，影响了在 range of influence 里所有点的解。

因为elliptic PDE 没有real characteristic paths, 所以它没有特殊的 domains of dependence 和 ranges of influence。实际上，它的整个 solution domain  就是 solution domain 上每个点的 both the domain of dependence and the range of influence.

### summary

[image-1]:	http://wx3.sinaimg.cn/mw690/8db2c8cbly1fitx9punuyj20jd09l407.jpg
[image-2]:	http://wx1.sinaimg.cn/mw690/8db2c8cbly1fivqnv0n15j20hd0enwh0.jpg
[image-3]:	http://wx3.sinaimg.cn/mw690/8db2c8cbly1fiww7tu2wpj20iq0dpad4.jpg