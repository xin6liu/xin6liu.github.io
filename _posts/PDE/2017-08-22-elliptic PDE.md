---
layout: post
author: liuxin
title: 8-summary
date: 2017-08-22
category: PDE
tags: elliptic PDE
---


summary

The numerical solution of elliptic partial differential equations by finite difference methods is discussed in this chapter. **Elliptic PDEs** govern equilibrium problems, which have **no preferred paths of information propagation**. The domain of dependence and range of influence of every point is the entire closed solution domain. Such problems are solved numerically by **relaxation methods**. The **two-dimensional Laplace equation** is considered 
as the model elliptic PDE in this chapter.  

Finite difference methods, as typified by the five-point method, yield **a system of finite difference equations**, called the **system equation**, which must be solved by **relaxation methods**. The **successive-over-relaxation (SOR) method** is generally the method of choice. The multi grid method(Brandt, 1977) shows the best potential for rapid convergence. 

Nonlinear partial differential equations yield nonlinear finite difference equations. Systems of nonlinear FDEs can be extremely difficult to solve. The multi grid method can be applied directly to nonlinear PDEs. Three-dimensional PDEs are approximated simply by including the finite difference approximations of the spatial derivatives in the third direction. The relaxation techniques used to solve two-dimensional problems generally can be used to solve three-dimensional problems, at the expense of a considerable increase in computational effort. 

