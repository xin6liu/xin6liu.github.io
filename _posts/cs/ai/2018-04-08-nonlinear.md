---
layout: post
title: 非线性回归
date: 2018-04-08
category: ai
---

> vscode 小技巧：
> Shift + Alt + I, 在选定的每一行的末尾插入光标


### 1 数据集描述和加载

本例中，我们使用生成的数据集，这跟书中第三章线性回归类似。

我们这次选择的方程是一个二次方程，并加上随机噪声，这有助于帮助我们测试回归的泛化能力。

核心代码如下：

```python
import numpy as np
trainsamples = 200
testsamples = 60
dsX = np.linspace(-1, 1, trainsamples + testsamples).transpose()
dsY = 0.4* pow(dsX,2) +2 * dsX + np.random.randn(*dsX.shape) * 0.22 + 0.8
```
### 2 数据集预处理

本例中的数据集不需要预处理，因为它是我们人工生成的，具有更好的性能，比如能够保证数据范围是 $ (-1,1) $ 。
### 3 模型结构——损失函数描述

本例中的损失函数使用均方误差，由以下代码实现：

```python
cost = tf.pow(py_x-Y, 2)/(2)
```
### 4 损失函数优化器

本例中，我们使用梯度下降作为损失函数优化器，可以用以下代码实现：

```python
train_op = tf.train.AdamOptimizer(0.5).minimize(cost)
```
### 5 准确度和收敛测试

```python
predict_op = tf.argmax(py_x, 1)
cost1 += sess.run(cost, feed_dict={X: [[x1]], Y: y1}) / testsamples
```
### 6 完整源代码如下

因为需要在 $ Jupyter\ Notebook $ 中执行，下文中的代码为使其能够在实验楼环境中运行会对原书的内容进行一些细微的更改。

**☞ 示例代码：**
```python
import tensorflow as tf
import numpy as np
from sklearn.utils import shuffle
import matplotlib.pyplot as plt 
%matplotlib inline


trainsamples = 200
testsamples = 60

# 这里我们定义模型。这个模型中含有一个简单的输入层和一个隐藏的sigmoid激活层。
def model(X, hidden_weights1, hidden_bias1, ow):
    hidden_layer =  tf.nn.sigmoid(tf.matmul(X, hidden_weights1)+ b) 
    return tf.matmul(hidden_layer, ow)

# 随机生成数据
dsX = np.linspace(-1, 1, trainsamples + testsamples).transpose() # 在-1到1内返回均匀间隔的数字
dsY = 0.4* pow(dsX,2) +2 * dsX + np.random.randn(*dsX.shape) * 0.22 + 0.8 # 生成Y方向的值

plt.figure() # 创建输出文件
plt.title('Original data')
plt.scatter(dsX,dsY) # 绘制数据点的散点图
```
**☞ 动手练习：**
**☞ 示例代码：**
```python
X = tf.placeholder("float")
Y = tf.placeholder("float")

# 创建第一个隐藏层
hw1 = tf.Variable(tf.random_normal([1, 10], stddev=0.01))
# 创建输出连接
ow = tf.Variable(tf.random_normal([10, 1], stddev=0.01))
# 产生误差
b = tf.Variable(tf.random_normal([10], stddev=0.01))

model_y = model(X, hw1, b, ow)
# 损失函数
cost = tf.pow(model_y-Y, 2)/(2)
# 创建优化器
train_op = tf.train.AdamOptimizer(0.0001).minimize(cost)
```
**☞ 动手练习：**
**☞ 示例代码：**
```python
# 在进程中启动
with tf.Session() as sess:
    tf.global_variables_initializer.run() # 初始化所有变量
    
    for i in range(1,10):
        trainX, trainY =dsX[0:trainsamples], dsY[0:trainsamples] # 对样本进行随机抽样保证有较好的训练效果
        for x1,y1 in zip (trainX, trainY):
            sess.run(train_op, feed_dict={X: [[x1]], Y: y1})
        testX, testY = dsX[trainsamples:trainsamples + testsamples], dsY[0:trainsamples:trainsamples+testsamples]
        cost1=0.
        for x1,y1 in zip (testX, testY):
            cost1 += sess.run(cost, feed_dict={X: [[x1]], Y: y1}) / testsamples       
            print( " Average cost for epoch " + str (i) + ":" + str(cost1))
        dsX, dsY = shuffle (dsX, dsY) # 我们随机抽样来实施更好的训练
```
**☞ 动手练习：**
### 6 结果描述

生成的人工数据的散点图如下图所示。

![人工数据散点图](attachment:%E4%BA%BA%E5%B7%A5%E6%95%B0%E6%8D%AE%E6%95%A3%E7%82%B9%E5%9B%BE.png)

由以下每次迭代的结果，我们知道该实现结果非常好，甚至在第一次迭代的时候就取得了不错的结果。

```
Average cost for epoch 1:[[ 0.00753353]]
Average cost for epoch 2:[[ 0.00381996]]
Average cost for epoch 3:[[ 0.00134867]]
Average cost for epoch 4:[[ 0.01020064]]
Average cost for epoch 5:[[ 0.00240157]]
Average cost for epoch 6:[[ 0.01248318]]
Average cost for epoch 7:[[ 0.05143405]]
Average cost for epoch 8:[[ 0.00621457]]
Average cost for epoch 9:[[ 0.00073790]]
```

注：因为自动生成的数据不同，每次运行的结果可能并不一样。
## 五、实验总结

本文通过对非线性数据进行回归分析，初步展现了向前神经网络的功能。在上述实验中，用向前神经网络计算模型，很快就获得了良好的结果，在之后的实验中我们将逐步扩大模型。
## 六、扩展阅读

本课程源自 [异步社区](http://www.epubit.com.cn/) 的 [《TensorFlow机器学习项目实战》](http://www.epubit.com.cn/book/details/4797) 第 $ 5 $ 章，再次感谢 [异步社区](http://www.epubit.com.cn/) 授权实验楼发布。

如果学完本课程，对书籍其他内容感兴趣欢迎点击以下链接购买书籍：

- [立即购买《TensorFlow机器学习项目实战》](https://item.jd.com/12235801.html)
<div style="color: #999;font-size: 12px;font-style: italic;">*本课程内容，由作者授权实验楼发布，未经允许，禁止转载、下载及非法传播。</div