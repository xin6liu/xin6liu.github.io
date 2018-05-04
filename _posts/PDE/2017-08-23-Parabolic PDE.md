---
layout: post
author: liuxin
title: 1-intro
date: 2017-08-23
category: PDE
tags: parabolic PDE
---

unsteady one-dimensional heat diffusion equation: 

a combined convection-diffusion problem, which is governed by the convection-diffusion equation. 

A wide variety of parabolic partial differential equations are encountered in engineering and science. Two of the more commonones are the diffusion equation and the convection-diffusion equation 

$\alpha$ 是 diffusivity

$u$是 convection velocity

The diffusion equation applies to problems in mass diffusion, heat diffusion (i.e., conduction), neutron diffusion, etc. The 
convection-diffusion equation applies to problems in which convection occurs in combination with diffusion, for example,fluid mechanics and heat transfer. 

two boundary conditions are required 

## GENERAL FEATURES OF PARABOLIC PDEs 

Propagation problems are **initial-boundary-value problems** in **open domains** (open with respect to time or a time-like variable) 

Propagation problems are governed by parabolic or hyperbolic partial differential equations. 

problems governed by parabolic PDEs have an **infinite physical information propagation speed**. As a result, the solution at a given point P at time level n depends on the solution **at all other points** in the solution domain **at all times preceding** and including time level n, and the solution at a given point P at time level n influences the solution at all other points in the solution domain at all times including and after time level n. Consequently,the physical information propagation speed c = dx/dt is infinite. 

考虑 pure diffusion:
$$ f_t = \alpha f_{xx} $$

$\alpha$ 是 diffusion coefficient. 

给出f(x,0), 即可得出f

initial property distribution $\phi$ simply decays with  
at the exponential rate. Thus, the rate of decay depends on  of the wave number k. The initial property distribution does not propagate in space. 

Consequently, pure diffusion causes the **initial property distribution** to **decay and change shape**, but the property distribution does **not propagate in space**. 


## characteristics 
In two-dimensional space, which is the case considered here (i.e., space x and time t), characteristics are paths (curved, in general) in the solution domain D(x, t) along which physical information propagates.

The characteristic paths for the unsteady one-dimensional diffusion equation $ f_t = \alpha f_{xx} $ are the **lines of constant time**. 

Thus, physical information propagates at an infinite rate throughout the entire physical solution domain. 也就是说每个点都互相影响。

THE FINITE DIFFERENCE METHOD

1. 先把定义域分割成 discrete difference grid 
2. 把PDE里每一个独立的 exact partial derivatives 约成 finite difference approximations (FDAs)
3. 把 FDAs 代入到 PDE，得到 finite difference equation (FDE)
4. 解 FDE

PDE的数值解的目的就是march the solution at time level n forward in time to time level n+1。

对于domain of dependence of parabolic PDE, 应该是n+1 上所有的点都有影响，所以解域整个都是。

![][image-1]

对于Numerical domain of dependence, 有两种：

1.explicit methods

![][image-2]

 2.implicit methods 

![][image-3]
 
he major similarity is that both methods march the solution forward from one time level to the next time level. 

The major difference is that the numerical information propagation speed for explicit marching 
methods is finite, whereas the numerical information propagation speed for implicit marching methods is infinite. 

explicit methods 比 implicit methods 计算更快，因为explicit methods 没有 system of finite difference equations 需要计算。

然而，explicit methods 的 finite numerical information propagation speed 并不是正确的 parabolic PDE 信息传播的速度，而 implicit method 的是。

实际上，只有一小部分物理信息会以 infinite physical information propagation propagation speed 来传播。

$x_i = (i-1) \Delta x, \ t^n = n \Delta t $

finite difference approximations 

还是写泰勒展开式
  



[image-1]:	http://wx3.sinaimg.cn/mw690/8db2c8cbgy1fj5awp7pgaj20mi0c8af2.jpg
[image-2]:	http://wx4.sinaimg.cn/mw690/8db2c8cbgy1fj5awmh3aaj20ln0c5dhq.jpg
[image-3]:	http://wx1.sinaimg.cn/mw690/8db2c8cbgy1fj5awnppvpj20m60c1whi.jpg