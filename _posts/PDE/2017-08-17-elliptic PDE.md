---
layout: post
author: liuxin
title: 3-FDM 
date: 2017-08-17
category: PDE
tags: elliptic PDE
---

The finite difference method is a numerical procedure which solves a PDE by **discretizing the continuous physical domain into a discrete finite difference grid**, approximating the individual exact partial derivatives in the PDE by algebraic **finite difference approximations (FDAs)**, substituting the FDAs into the PDE to obtain an algebraic **finite difference equation (FDE)**, and solving the resulting algebraic finite difference equations (FDEs) for the **dependent variable**. 以后我们都会用”FDE”来代替 “finite difference equation”. Some general characteristics of finite difference grids and finite difference approximations for equilibrium problems governed by elliptic PDEs are discussed in this section. 

## Finite Difference Grids 
下图是 the closed solution domainD(x, y) in xy space for a two-dimensional equilibrium problem. The solution domain must be covered by a two-dimensional  grid of lines, called the **finite difference grid**. The intersections of these **grid lines** are the **grid points** at which the finite difference solution to the partial differential equation is to be obtained.

![][image-1]

(Solution domain D(x,y) and discrete difference grid.)

The dependent variable at a grid point is denoted by the same subscript notation that is used to denote the grid points themselves.Thus,the function f(x, y) at grid point (i,j) is denoted by 

$$ f(x_i, y_j) = f_{i, j} $$

## Finite Difference Approximations 
Now that the **finite difference grid** has been specified, **finite difference approximations (FDAs)** of the individual exact partial derivatives appearing in the partial differential equation must be developed. This is accomplished by **writing Taylor series for the dependent variable at several neighboring grid points using grid point (i, j) as the base point, and combining these Taylor series to solve for the desired partial derivatives.** This is done in Chapter 5 for functions of one independent variable, where approximations of various types (i.e., forward, backward,and centered) having various orders of accuracy (i.e., first order, second order, etc.) are developed for various derivatives (i.e., first derivative, second derivative, etc.). Those results are presented in Table5.1. 

The forms of the finite difference approximations of the individual exact partial derivatives in a PDE should be governed by the physics being represented by the PDE. For elliptic PDEs containing only second derivatives, a characteristic analysis shows that there are no preferred physical informative propagation paths. Thus, the solution at all points depends on the solution at all other points, and the solution at all points influences the solution at all the other points. Consequently, **centered-space finite difference approximations** should be used for the **second-order spatial derivatives in the Laplace equation and the Poisson equation**. 

In the development of finite difference approximations, a distinction must be made between the **exact solution** of a PDE and the **approximate solution** of the PDE. For the remainder of this chapter, exact solutions will be denoted by an overbar over the symbol for the dependent variable [i.e., jT(x,y)](), and approximate solutions will be denoted by the symbol for the dependent variable without an overbar[i.e., f(x, y)](). Thus, 

通过泰勒展开，得到 f(i+1) 和 f(i-1) 与 f(i), fx(i), fxx(i) … 的关系，最后得到用f(i+1) f(i-1) 和 f(i) 来表达 fxx(i).

真实值：

$$ f_{xx} \bar \| i,j = \frac{f \bar _{i+1,j} - 2 \ bar f_{i,j} + f \bar _i-1,j }{ \Delta x ^2} - \frac{1}{12} f  \bar_{xxxx} (\epsilon} \Delta x^2 $$

而 second-order centered-space approximation of $f_{xx}\bar$ at grid point (i,j) 是：
 
$$ f_{xx \| i,j} = \frac{f_{i+1,j} - 2 f_{i,j} + f_{i-1,j }{ \Delta x ^2}  $$

remainder term 叫做truncation error of the finite difference approximation of $f\bar_{xx}$ 

## Finite Difference Equations 

Finite difference equations are obtained by replacing the individual exact partial derivatives in a partial differential equation by finite difference approximations, such as $ f_{xx i,j} = \frac{f_{i+1,j} - 2 f_{i,j} + f_{i-1,j }{ \Delta x ^2}  $, to obtain a finite difference approximation of the partial differential equation, which is called a **finite difference equation (FDE)**. A finite difference approximation of the two-dimensional Laplace equation is developed in Section 9.4, and a finite difference approximation of the two-dimensional Poisson equation is developed in Section 9.8. 





[image-1]:	http://wx4.sinaimg.cn/mw690/8db2c8cbly1fiz8e3i67gj20ex09rgmy.jpg