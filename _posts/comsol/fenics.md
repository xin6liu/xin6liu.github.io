
给你一个函数f(x,y),然后给你一个mesh，如何求Laplace(f(x))这种基本问题，如果这个mesh是规则的，那直接根据经验，就可以有限差分得出一个矩阵乘以f(x,y)。如果是三角形这种不规则的，就需要点点数学了，基本思路就是乘以一个任意函数g，然后用Divergence theorem转成弱形式（此时你会希望g能有个性质就是在边界上为0），然后你再把g表示成basis function的叠加（边界上为零的条件自然成立）。此时你再把f(x,y)表示成basis function的叠加（设系数为矢量U），带入到弱形式里，你会得到stiffness matrix K，而Laplace(f(x))这一端呢，你会得到一个load vector L，然后你会发现有
L Laplace(f(x)) = K U
Laplace(f(x)) = L^-1 K U
注意这里是假设f(x,y)已知的情况，求Laplace(f(x)) ，如果是f(x,y)未知，Laplace(f(x))已知，譬如Poisson方程，那求解上面的线性方程就行了。
个人认为这就是有限元的基本原理。
ps：关于basis function你可以假设在一个unit triangle上已知三个顶点的函数值，然后去插值，然后任意三角形直接做一个affine变换就行了。