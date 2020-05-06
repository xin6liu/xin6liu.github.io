---
layout: post
title: 遗传算法
date: 2018-04-22
category: ai
---


<h3 id="labdoc-header-12">1. 了解理论知识</h3>
<blockquote>
<p>遗传学背景知识</p><ul>
<li>种群(Population)：生物的进化以群体的形式进行，这样的一个群体称为种群。</li>
<li>个体：组成种群的单个生物。</li>
<li>基因 ( Gene ) ：一个遗传因子。</li>
<li>染色体 ( Chromosome ) ：包含一组的基因。</li>
<li>生存竞争，适者生存：对环境适应度高的个体参与繁殖的机会比较多，后代就会越来越多。适应度低的个体参与繁殖的机会比较少，后代就会越来越少。</li>
<li>遗传与变异：新个体会遗传父母双方各一部分的基因，同时有一定的概率发生基因变异。</li>
<li>简单说来就是：繁殖过程，会发生基因交叉( Crossover ) ，基因突变 ( Mutation ) ，适应度( Fitness )低的个体会被逐步淘汰，而适应度高的个体会越来越多。那么经过N代的自然选择后，保存下来的个体都是适应度很高的，其中很可能包含产生的适应度最高的个体
历史：进化策略(ES)是在1965年由Rechenberg和Schwefel独立提出的。之后，进化策略的思想被其他研究者推广，John Holland和他的学生和同事在此基础上发明了遗传算法，与此同时Holland 的著作”Adaption in Natural and Artificial Systems“与1975年发布。</li>
</ul>
</blockquote>
<blockquote>
<p>1993年，John Koza使用遗传算法写成演化程序来解决特定的问题。他称这种程序为遗传编程（GP)。使用的编程语言是LISP,因为这种编程语言可以用解析树（parse tree)的形式呈现，而解析树问题也是遗传算法的工作对象。</p></blockquote>
<blockquote>
<p>染色体（Chromosome）：</p></blockquote>
<blockquote>
<p>所有的生物体都是由细胞组成，每一个细胞中都有一定数量的染色体。染色体是DNA的序列和遗传信息（基因）的主要载体。每一个基因对特定的蛋白质进行编码，通常来说就是每一个基因会控制一种特征，例如眼睛的颜色。用来控制同一个特征（蓝色或棕色）的基因被称为等位基因（alleles)。每一个基因在染色体上的位置是固定的，这个位置被称为基因座（locus).
完整的遗传物质（所有染色体）称为基因组。基因组中的特定基因称为基因型。基因型是个体表现型的有关基因组成，包括生理和心理特征，如眼睛颜色、智力等。</p></blockquote>
<blockquote>
<p>繁殖（Reproduction）：</p></blockquote>
<blockquote>
<p>在繁殖过程中，首先发生的是重组（或交叉（crossover））。父母的基因在以某种方式形成了整个新染色体。新创建的后代可以突变。突变意味着DNA的组成基因有些变化。这种变化主要是由于父母复制基因的错误造成的。
个体的适应性是个体对于生存环境的适应程度决定。</p></blockquote>
<blockquote>
<p>搜索空间（search space）：</p></blockquote>
<blockquote>
<p>如果我们解决一些问题，我们通常做的就是寻找它的解，并且力求找到最优解。一个问题的所有可能解称为搜索空间，搜索空间中的每一个点都代表一个可能解。一个可能解的可能程度是通过他所对应的计算值或适应度评估。</p></blockquote>
<p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488718504596.png/wm" alt="此处输入图片的描述"><p></p><blockquote>
<p>大多时候，我们所求的最优解是找寻搜索空间中函数极大值或极小值所对应的解。这个过程还是很复杂的，因为我们不知道从何搜起。现有一些找寻合适解的方法：爬山法（hill climbing），禁忌搜索（tabu search），模拟退火法（simulated annealing），遗传算法等。这些方法都是被认为比较好的方法，因为我们不需要证明所得到的解是最优的。</p></blockquote>
<blockquote>
<p>适应度函数（Fitness）</p></blockquote>
<blockquote>
<p>适应度用于评价个体的优劣程度,适应度越大个体越好,反之适应度越小则个体越差；根据适应度的大小对个体进行选择,以保证适应性能好的个体有更多的机会繁殖后代,使优良特性得以遗传.因此,遗传算法要求适应度函数值必须是非负数,而在许多实际问题中,求解的目标通常是费用最小,而不是效益最大,因此需要将求最小的目标根据适应度函数非负原则转换为求最大目标的形式。</p></blockquote>
<h3 id="labdoc-header-13">2. 二进制编码（Binary Encoding）</h3>
<p>这里我要对代码中的一些变量进行说明：</p><ul>
<li><p>popsize:每代的个体数</p></li>
<li><p>chrosize：变量编码长度</p></li>
<li><p>[xrangemin,xrangxmax] ：变量取值范围</p></li>
<li>crossrate：交叉率</li>
<li>mutationrate ：变异率</li>
<li>generation：遗传代数</li>
</ul>
<p>先导入需要用到的库：</p><pre><code class="hljs coffeescript"><span class="hljs-keyword">from</span> numpy <span class="hljs-keyword"><span class="hljs-keyword">import</span></span> random
<span class="hljs-keyword"><span class="hljs-keyword">import</span></span> numpy <span class="hljs-keyword"><span class="hljs-keyword">as</span></span> np
<span class="hljs-keyword"><span class="hljs-keyword">import</span></span> matplotlib.pyplot <span class="hljs-keyword"><span class="hljs-keyword">as</span></span> plt
<span class="hljs-keyword">from</span> math <span class="hljs-keyword"><span class="hljs-keyword">import</span></span> <span class="hljs-built_in">pi</span>,<span class="hljs-built_in">sin</span>
<span class="hljs-keyword"><span class="hljs-keyword">import</span></span> copy
</code></pre><blockquote>
<p>二进制编码是最常用的的编码方式，每个个体都是由0,1组成。
表现型：一个具体的实数x
基因型：二进制编码（串长取决于求解精度）
我们可以随机生存0,1数组，然后在对随机数组对应到实数空间中进行解密。
编码长度越长，精度越高。如将6位二进制编码映射到<span class="katex"><span class="katex-mathml"><math><semantics><mrow><mo>[</mo><mo>−</mo><mn>1</mn><mo separator="true">,</mo><mn>1</mn><mo>]</mo></mrow><annotation encoding="application/x-tex">[-1,1]</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="strut" style="height:0.75em;"></span><span class="strut bottom" style="height:1em;vertical-align:-0.25em;"></span><span class="base"><span class="mopen">[</span><span class="mord">−</span><span class="mord">1</span><span class="mpunct">,</span><span class="mord rule" style="margin-right:0.16666666666666666em;"></span><span class="mord">1</span><span class="mclose">]</span></span></span></span>内，则精度为:
<img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693074561.png/wm" alt="此处输入图片的描述">,则先将二进制转化为十进制，如<img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693095438.png/wm" alt="此处输入图片的描述">，转化为$[-1,1]内为<img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693111719.png/wm" alt="此处输入图片的描述">。</p></blockquote>
<p>初始化种群：</p><pre><code class="hljs python"><span class="hljs-function"><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">def</span></span></span><span class="hljs-function"> </span><span class="hljs-title"><span class="hljs-function"><span class="hljs-title">initialpop</span></span></span><span class="hljs-params"><span class="hljs-function"><span class="hljs-params">(</span></span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-params">self</span></span></span><span class="hljs-function"><span class="hljs-params">)</span></span></span></span><span class="hljs-function">:</span>
        pop = random.randint(<span class="hljs-number"><span class="hljs-number">0</span></span>,<span class="hljs-number"><span class="hljs-number">2</span></span>,size =(<span class="hljs-keyword">self</span>.popsize,<span class="hljs-keyword">self</span>.chrosize))
        <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> pop
</code></pre><p>初始化产生10个个体如下，其中黄色标记为最优个体，即对应实数的函数适应度最大：</p><p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488643332848.png/wm" alt="此处输入图片的描述"><p></p><p>对群组在实数空间内解码：</p><pre><code class="hljs python"><span class="hljs-comment"><span class="hljs-comment">#对十进制进行转换到求解空间中的数值</span></span>
<span class="hljs-function"><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">def</span></span></span><span class="hljs-function"> </span><span class="hljs-title"><span class="hljs-function"><span class="hljs-title">get_declist</span></span></span><span class="hljs-params"><span class="hljs-function"><span class="hljs-params">(</span></span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-params">self</span></span></span><span class="hljs-function"><span class="hljs-params">,chroms)</span></span></span></span><span class="hljs-function">:</span>
        step =(<span class="hljs-keyword">self</span>.xrangemax - <span class="hljs-keyword">self</span>.xrangemin)/float(<span class="hljs-number"><span class="hljs-number">2</span></span>**<span class="hljs-keyword">self</span>.chrosize<span class="hljs-number">-</span><span class="hljs-number"><span class="hljs-number">1</span></span>)
        <span class="hljs-keyword">self</span>.chroms_declist =[]
        <span class="hljs-keyword"><span class="hljs-keyword">for</span></span> i <span class="hljs-keyword"><span class="hljs-keyword">in</span></span> xrange(<span class="hljs-keyword">self</span>.popsize):
            chrom_dec =<span class="hljs-keyword">self</span>.xrangemin+step*<span class="hljs-keyword">self</span>.chromtodec(chroms[i])  
            <span class="hljs-keyword">self</span>.chroms_declist.append(chrom_dec)      
        <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> <span class="hljs-keyword">self</span>.chroms_declist
 <span class="hljs-comment"><span class="hljs-comment">#将二进制数组转化为十进制</span></span>
    <span class="hljs-function"><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">def</span></span></span><span class="hljs-function"> </span><span class="hljs-title"><span class="hljs-function"><span class="hljs-title">chromtodec</span></span></span><span class="hljs-params"><span class="hljs-function"><span class="hljs-params">(</span></span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-params">self</span></span></span><span class="hljs-function"><span class="hljs-params">,chrom)</span></span></span></span><span class="hljs-function">:</span>
        m = <span class="hljs-number"><span class="hljs-number">1</span></span>
        r = <span class="hljs-number"><span class="hljs-number">0</span></span>
        <span class="hljs-keyword"><span class="hljs-keyword">for</span></span> i <span class="hljs-keyword"><span class="hljs-keyword">in</span></span> xrange(<span class="hljs-keyword">self</span>.chrosize):
            r = r + m * chrom[i]
            m = m * <span class="hljs-number"><span class="hljs-number">2</span></span>
        <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> r
</code></pre><p>对应的实数空间为：
 [-0.9501466275659824, -0.7419354838709677, -0.7741935483870968, 1.63049853372434, -0.3724340175953079, -0.6744868035190617, 0.24926686217008798, 1.3870967741935485, 0.9736070381231672, 0.16715542521994142]
以下内容涉及到遗传算法的核心部分，有必要先了解一些具体流程和优化目标：</p><ul>
<li>算法流程图：
<center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488643580954.png/wm" alt="此处输入图片的描述"></center></li>
</ul>
<ul>
<li>我们的目标是求解函数：<img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488868074359.png/wm" alt="此处输入图片的描述">上最大值，从函数曲线图可以看出，函数值跳跃性很强，用一般的穷举法求解较为困难。通过求导法，可以求解出函数的最优解为：f(1.85)=3.85。  </li>
</ul>
<p><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488643855010.png/wm" alt="此处输入图片的描述"></p><ul>
<li>原函数与适应度函数：<pre><code class="hljs ruby"><span class="hljs-comment"><span class="hljs-comment"># 对传入的每个变量，计算函数值</span></span>
<span class="hljs-function"><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">def</span></span></span><span class="hljs-function"> </span><span class="hljs-title"><span class="hljs-function"><span class="hljs-title">fun</span></span></span><span class="hljs-params"><span class="hljs-function"><span class="hljs-params">(</span></span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-params"><span class="hljs-keyword">self</span></span></span></span><span class="hljs-function"><span class="hljs-params">,x1)</span></span></span></span>:
  <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> x1*sin(<span class="hljs-number"><span class="hljs-number">10</span></span>*pi*x1)+<span class="hljs-number"><span class="hljs-number">2.0</span></span>
<span class="hljs-comment"><span class="hljs-comment">#由于我们所求的是最大值，所有可以用函数值代替适应度</span></span>
<span class="hljs-function"><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">def</span></span></span><span class="hljs-function"> </span><span class="hljs-title"><span class="hljs-function"><span class="hljs-title">get_fitness</span></span></span><span class="hljs-params"><span class="hljs-function"><span class="hljs-params">(</span></span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-params"><span class="hljs-keyword">self</span></span></span></span><span class="hljs-function"><span class="hljs-params">,x)</span></span></span></span>:       
  fitness = []
  <span class="hljs-keyword"><span class="hljs-keyword">for</span></span> x1 <span class="hljs-keyword"><span class="hljs-keyword">in</span></span> <span class="hljs-symbol"><span class="hljs-symbol">x:</span></span>
  fitness.append(<span class="hljs-keyword"><span class="hljs-keyword">self</span></span>.fun(x1))
  <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> fitness   
</code></pre></li>
</ul>
<h3 id="labdoc-header-14">3. 选择（selection）</h3>
<blockquote>
<p>下一代染色体是从进行交叉的父代个体中选择而来。问题在于，如何选择。根据达尔文的生物进化理论，适应性较好的个体会生存下来并且创造后代。有很多种方法来选择适应性较好的个体。例如：轮盘赌选择（roulette wheel selection），玻尔兹曼选择（Boltzman selection），联赛选择（tournament selection），排序选择（rank selection），稳定状态选择（steady state selection）等。</p></blockquote>
<h4 id="3-3-1-roulette-wheel-selection-">3.1 轮盘赌选择（Roulette Wheel Selection ）：</h4>
<p>又称比例选择方法．其基本思想是：各个个体被选中的概率与其适应度大小成正比。
从父代个体的适应度选择，适应度越好，被选择的概率越大。想象眼前有一个轮盘，把所有染色体放在轮盘上，每一个个体都有和适应度相关比例的空间大小。</p><p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488643921111.png/wm" alt="此处输入图片的描述"><p></p><p>很显然个体1的适应度最大，所有对应的空间大小也最大。但是其他较低适应度的个体也有被选择到的概率。
这样有什么好处？避免了所有的后代都选择概率最大的个体1（所谓的最优值问题），换句话，各个概率（各种情况）都相应的被使用到了，避免了陷入局部最优的问题。</p><p>下面具体介绍一下轮盘赌选择的实现过程：</p><p>（1）    计算群体中每个个体的适应度f(i =1,2,…….N)；</p><p>（2）    计算出每一个个体被遗传到下一代群体中的概率：
<img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693153965.png/wm" alt="此处输入图片的描述"></p><p>（3）    计算每个个体的；累计概率：
<img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693179911.png/wm" alt="此处输入图片的描述"></p><p>   其中<em>q(xi)</em>称为染色体x[i] (i=1, 2, …, n)的积累概率；</p><p>（4）    在[0，1]区间内产生一个均匀分布的伪随机数r；</p><p>（5）    若r&lt;q[1]，则选择个体1，否则，选择个体k，使得：q[k-1]&lt;r≤q[k] 成立；</p><p>（6）    重复(4)、(5)共M次。</p><p>下面给出轮盘赌算法的代码：</p><pre><code class="hljs python"><span class="hljs-meta"><span class="hljs-comment">#输入参数为上一代的种群，和上一代种群的适应度列表</span></span>
<span class="hljs-function"><span class="hljs-keyword">def</span> <span class="hljs-title">selection</span><span class="hljs-params">(self,popsel,fitvalue)</span>:</span><span class="hljs-type"></span>
        <span class="hljs-keyword">new</span><span class="hljs-type">_fitvalue</span> = []
        totalfit = sum(fitvalue)
        accumulator = <span class="hljs-number"><span class="hljs-number">0.0</span></span>
        <span class="hljs-keyword"><span class="hljs-keyword">for</span></span> val <span class="hljs-keyword"><span class="hljs-keyword">in</span></span> fitvalue: <span class="hljs-type"></span>
            <span class="hljs-meta"><span class="hljs-comment">#对每一个适应度除以总适应度，然后累加，这样可以使适应度大</span></span>
            <span class="hljs-meta"><span class="hljs-comment">#的个体获得更大的比例空间。</span></span>
            <span class="hljs-keyword">new</span><span class="hljs-type">_val</span> =(val*<span class="hljs-number"><span class="hljs-number">1.0</span></span>/totalfit)            
            accumulator += <span class="hljs-keyword">new</span><span class="hljs-type">_val</span>
            <span class="hljs-keyword">new</span><span class="hljs-type">_fitvalue</span>.append(accumulator)            
        ms = []
        <span class="hljs-keyword"><span class="hljs-keyword">for</span></span> i <span class="hljs-keyword"><span class="hljs-keyword">in</span></span> xrange(self.popsize):<span class="hljs-type"></span>
            <span class="hljs-meta"><span class="hljs-comment">#随机生成0,1之间的随机数</span></span>
            ms.append(random.random()) 
        ms.sort() <span class="hljs-meta"><span class="hljs-comment">#对随机数进行排序</span></span>
        fitin = <span class="hljs-number"><span class="hljs-number">0</span></span>
        <span class="hljs-keyword">new</span><span class="hljs-type">in</span> = <span class="hljs-number"><span class="hljs-number">0</span></span>
        <span class="hljs-keyword">new</span><span class="hljs-type">pop</span> = popsel
        <span class="hljs-keyword"><span class="hljs-keyword">while</span></span> <span class="hljs-keyword">new</span><span class="hljs-type">in</span> &lt; self.popsize:<span class="hljs-type"></span>
            <span class="hljs-meta"><span class="hljs-comment">#随机投掷，选择落入个体所占轮盘空间的个体</span></span>
            <span class="hljs-keyword"><span class="hljs-keyword">if</span></span>(ms[<span class="hljs-keyword">new</span><span class="hljs-type">in</span>] &lt; <span class="hljs-keyword">new</span><span class="hljs-type">_fitvalue</span>[fitin]):<span class="hljs-type"></span>
                <span class="hljs-keyword">new</span><span class="hljs-type">pop</span>[<span class="hljs-keyword">new</span><span class="hljs-type">in</span>] = popsel[fitin]
                <span class="hljs-keyword">new</span><span class="hljs-type">in</span> = <span class="hljs-keyword">new</span><span class="hljs-type">in</span> + <span class="hljs-number"><span class="hljs-number">1</span></span>
            <span class="hljs-keyword"><span class="hljs-keyword">else</span></span>:<span class="hljs-type"></span>
                fitin = fitin + <span class="hljs-number"><span class="hljs-number">1</span></span>
        <span class="hljs-meta"><span class="hljs-comment">#适应度大的个体会被选择的概率较大</span></span>
        <span class="hljs-meta"><span class="hljs-comment">#使得新种群中，会有重复的较优个体</span></span>
        pop = <span class="hljs-keyword">new</span><span class="hljs-type">pop</span>

        <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> pop
</code></pre><p>根据轮盘赌选择的原理，适应度高的个体将会被选择下来的可能性更大，所以我们可以打印出初代选择之后的种群发现，最优个体被五次选择：</p><p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693379922.png/wm" alt="此处输入图片的描述"><p></p><h4 id="3-3-2-rank-selection-">3.3.2 排序选择算法（Rank Selection ）：</h4>
<p>轮盘赌选择算法可能会在个体适应度相差很大的时候带来一些问题。比如，最好个体的适应度是占据了轮盘面积的90%，那么剩余的个体的生存几率将会很小，显然这会影响物种多样性。
排序选择首先会将按照个体适应度进行排序，按照排序的结果，每个个体将会重新获得一个数值。最差的个体的适应度为1，第二差的为2，以此类推最好的个体的适应度为N(种群个体的大小)。
可以对比一下按照个体适应度和排序数值的不同结果：</p><p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693444712.png/wm" alt="此处输入图片的描述"><p></p><p></p><center>图：按照适应度分配空间<p></p><p>轮盘赌选择：                                      </p><table>
<thead>
<tr>
<th style="text-align:left">Chromosomes</th>
<th style="text-align:right">rate</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align:left">Chromosome1</td>
<td style="text-align:right">0.90</td>
</tr>
<tr>
<td style="text-align:left">Chromosome2</td>
<td style="text-align:right">0.06</td>
</tr>
<tr>
<td style="text-align:left">Chromosome3</td>
<td style="text-align:right">0.03</td>
</tr>
<tr>
<td style="text-align:left">Chromosome4</td>
<td style="text-align:right">0.01</td>
</tr>
</tbody>
</table>
<p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693556558.png/wm" alt="此处输入图片的描述"><p></p><p></p><center>图：按照排序值分配空间<p></p><p>排序选择</p><table>
<thead>
<tr>
<th style="text-align:left">Chromosomes</th>
<th style="text-align:center">ranking</th>
<th style="text-align:center">rate</th>
</tr>
</thead>
<tbody>
<tr>
<td style="text-align:left">Chromosome1</td>
<td style="text-align:center">1</td>
<td style="text-align:center">4/10=0.4</td>
</tr>
<tr>
<td style="text-align:left">Chromosome2</td>
<td style="text-align:center">2</td>
<td style="text-align:center">0.3</td>
</tr>
<tr>
<td style="text-align:left">Chromosome3</td>
<td style="text-align:center">3</td>
<td style="text-align:center">0.2</td>
</tr>
<tr>
<td style="text-align:left">Chromosome4</td>
<td style="text-align:center">4</td>
<td style="text-align:center">0.1</td>
</tr>
</tbody>
</table>
<p>排序选择将使所有个体都有将会被选择。但是这样也会导致种群不容易收敛，因为最好的个体与其他个体的差别减小。</p><h3 id="labdoc-header-15">4.  交叉（Crossover）：</h3>
<blockquote>
<p>交叉与变异是遗传算法的两个基本算子。遗传算法的结果主要由这两个算子决定。算子的编写和执行主要取决于编码方式和实际问题。实现交叉和变异的方式有很多种。</p></blockquote>
<ul>
<li>单点交叉（Single point crossover）：
指在个体编码串中只随机设置一个交叉点，然后再该点相互交换两个配对个体的部分染色体。 </li>
</ul>
<p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693658180.png/wm" alt="此处输入图片的描述"><p></p><p></p><center><strong>11001</strong>011 + 11011<strong>111</strong> = <strong>11011111</strong><p></p><pre><code class="hljs python"><span class="hljs-function"><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">def</span></span></span><span class="hljs-function"> </span><span class="hljs-title"><span class="hljs-function"><span class="hljs-title">crossover</span></span></span></span><span class="hljs-function"><span class="hljs-params">(</span></span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-params">self</span></span></span><span class="hljs-function"><span class="hljs-params">,pop)</span>:</span>
        <span class="hljs-keyword"><span class="hljs-keyword">for</span></span> i <span class="hljs-keyword">in</span> xrange(<span class="hljs-keyword">self</span>.popsize<span class="hljs-number">-</span><span class="hljs-number"><span class="hljs-number">1</span></span>):
            <span class="hljs-comment"><span class="hljs-comment">#近邻个体交叉，若随机数小于交叉率</span></span>
            <span class="hljs-keyword"><span class="hljs-keyword">if</span></span>(random.random()&lt;<span class="hljs-keyword">self</span>.crossrate):
                <span class="hljs-comment"><span class="hljs-comment">#随机选择交叉点</span></span>
                singpoint =random.randint(<span class="hljs-number"><span class="hljs-number">0</span></span>,<span class="hljs-keyword">self</span>.chrosize)
                temp1 = []
                temp2 = []
                <span class="hljs-comment"><span class="hljs-comment">#对个体进行切片，重组</span></span>
                temp1.<span class="hljs-keyword">extend</span>(pop[i][<span class="hljs-number"><span class="hljs-number">0</span></span>:singpoint])
                temp1.<span class="hljs-keyword">extend</span>(pop[i+<span class="hljs-number"><span class="hljs-number">1</span></span>][<span class="hljs-symbol">singpoint:</span><span class="hljs-keyword">self</span>.chrosize])
                temp2.<span class="hljs-keyword">extend</span>(pop[i+<span class="hljs-number"><span class="hljs-number">1</span></span>][<span class="hljs-number"><span class="hljs-number">0</span></span>:singpoint])
                temp2.<span class="hljs-keyword">extend</span>(pop[i][<span class="hljs-symbol">singpoint:</span><span class="hljs-keyword">self</span>.chrosize])
                pop[i]=temp1
                pop[i+<span class="hljs-number"><span class="hljs-number">1</span></span>]=temp2
        <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> pop

</code></pre><ul>
<li>两点交叉（Two point crossover）：
在个体编码串中随机设置了两个交叉点，然后再进行部分基因交换。</li>
</ul>
<p><cente><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693729041.png/wm" alt="此处输入图片的描述"></cente></p><p></p><center><strong>11</strong>0010<strong>11</strong> + 11<strong>0111</strong>11 = <strong>11011111</strong><p></p><ul>
<li>均匀交叉（Uniform crossover）：
两个配对个体的每个基因座上的基因都以相同的交叉概率进行交换，从而形成两个新个体。</li>
</ul>
<p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693819296.png/wm" alt="此处输入图片的描述"><p></p><p></p><center>1<strong>10</strong>010<strong>11</strong> + <strong>1</strong>10<strong>111</strong>01 = 11011111<p></p><ul>
<li>算术交叉（Arithmetic crossover）：
由两个个体的线性组合而产生出两个新的个体。该操作对象一般是由浮点数编码表示的个体。</li>
</ul>
<p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693866871.png/wm" alt="此处输入图片的描述"><p></p><p></p><center>11001011 + 11011111 = 11001001 (AND)<p></p><h3 id="labdoc-header-16">5.  变异（Mutation ）</h3>
<ul>
<li>基因反转（Bit inversion）</li>
</ul>
<p></p><center><img src="https://dn-anything-about-doc.qbox.me/document-uid268645labid2619timestamp1488693914820.png/wm" alt="此处输入图片的描述"><p></p><p></p><center>1<strong>1</strong>001001 =&gt;  1<strong>0</strong>001001<p></p><pre><code class="hljs python"><span class="hljs-function"><span class="hljs-keyword">def</span> <span class="hljs-title">mutation</span><span class="hljs-params">(self,</span></span><span class="hljs-built_in"><span class="hljs-function"><span class="hljs-params">pop</span></span></span><span class="hljs-function"><span class="hljs-params">)</span>:</span>
        <span class="hljs-keyword"><span class="hljs-keyword">for</span></span> i <span class="hljs-keyword"><span class="hljs-keyword">in</span></span> <span class="hljs-built_in">xrange</span>(self.popsize):
            <span class="hljs-comment">#反转变异，随机数小于变异率，进行变异</span>
            <span class="hljs-keyword"><span class="hljs-keyword">if</span></span> (<span class="hljs-built_in">random</span>.<span class="hljs-built_in">random</span>()&lt; self.mutationrate):
                mpoint = <span class="hljs-built_in">random</span>.randint(<span class="hljs-number"><span class="hljs-number">0</span></span>,self.chrosize<span class="hljs-number">-</span><span class="hljs-number"><span class="hljs-number">1</span></span>)
                <span class="hljs-comment">#将随机点上的基因进行反转。</span>
                <span class="hljs-keyword"><span class="hljs-keyword">if</span></span>(<span class="hljs-built_in">pop</span>[i][mpoint]==<span class="hljs-number"><span class="hljs-number">1</span></span>):
                    <span class="hljs-built_in">pop</span>[i][mpoint] = <span class="hljs-number"><span class="hljs-number">0</span></span>
                <span class="hljs-keyword"><span class="hljs-keyword">else</span></span>:
                    <span class="hljs-built_in">pop</span>[mpoint] =<span class="hljs-number"><span class="hljs-number">1</span></span>

        <span class="hljs-built_in"><span class="hljs-keyword">return</span></span> <span class="hljs-built_in">pop</span>
</code></pre><h3 id="labdoc-header-17">6.   精英保留策略（Elitism）：</h3>
<blockquote>
<p>通过选择，交叉和变异创造新个体的时候，有可能会失去一部分优秀的个体。
总体思想是，判断经过选择，交叉，变异之后的种群中，是否产生了更优秀的个体，如果没有，则将上一代的精英个体替换较差个体。</p></blockquote>
<blockquote>
<p>精英保留策略会快速提高遗传算法性能，因为它可以防止最优个体的丢失。
<code>`</code>python
def elitism(self,pop,popbest,nextbestfit,fitbest):</p></blockquote>
<pre><code class="hljs perl">    <span class="hljs-meta"><span class="hljs-comment">#输入参数为上一代最优个体，变异之后的种群，</span></span>
    <span class="hljs-meta"><span class="hljs-comment">#上一代的最优适应度，本代最优适应度。这些变量是在主函数中生成的。</span></span>
    <span class="hljs-keyword"><span class="hljs-keyword">if</span></span> nextbestfit-fitbest &lt;<span class="hljs-number"><span class="hljs-number">0</span></span>:  
        <span class="hljs-meta"><span class="hljs-comment">#满足精英策略后，找到最差个体的索引，进行替换。         </span></span>
        pop_worst =nextfitvalue.index(min(nextfitvalue))
        <span class="hljs-keyword"><span class="hljs-keyword">pop</span></span>[pop_worst] = popbest
    <span class="hljs-keyword"><span class="hljs-keyword">return</span></span> <span class="hljs-keyword"><span class="hljs-keyword">pop</span></span> 
</code></pre><pre><code class="hljs css">
##<span class="hljs-selector-id">#</span><span class="hljs-number"><span class="hljs-selector-id">3</span><span class="hljs-selector-class">.7</span></span> 串联整个流程

<span class="hljs-selector-tag">-</span> 首先定义一个<span class="hljs-selector-tag">Gas</span>类，并初始化变量：
</code></pre><p>class Gas():</p><pre><code class="hljs ruby"><span class="hljs-comment"><span class="hljs-comment">#初始化一些变量</span></span>
<span class="hljs-function"><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">def</span></span></span><span class="hljs-function"> </span><span class="hljs-title"><span class="hljs-function"><span class="hljs-title">__init__</span></span></span><span class="hljs-params"><span class="hljs-function"><span class="hljs-params">(</span></span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-params"><span class="hljs-keyword">self</span></span></span></span><span class="hljs-function"><span class="hljs-params">,popsize,chrosize,xrangemin,xrangemax)</span></span></span></span>:
    <span class="hljs-keyword"><span class="hljs-keyword">self</span></span>.popsize =popsize
    <span class="hljs-keyword"><span class="hljs-keyword">self</span></span>.chrosize =chrosize
    <span class="hljs-keyword"><span class="hljs-keyword">self</span></span>.xrangemin =xrangemin
    <span class="hljs-keyword"><span class="hljs-keyword">self</span></span>.xrangemax =xrangemax
    <span class="hljs-keyword"><span class="hljs-keyword">self</span></span>.crossrate =<span class="hljs-number"><span class="hljs-number">1</span></span>
    <span class="hljs-keyword"><span class="hljs-keyword">self</span></span>.mutationrate =<span class="hljs-number"><span class="hljs-number">0</span></span>.<span class="hljs-number"><span class="hljs-number">01</span></span>
</code></pre><pre><code class="hljs coffeescript">-<span class="ruby"> 然后依次在<span class="hljs-class"><span class="hljs-keyword"><span class="hljs-class"><span class="hljs-keyword">class</span></span></span><span class="hljs-class">中添加上面介绍的算子，此处为了更好理解整个流程，只写出函数关键字。函数具体实现上面有介绍：</span></span></span>
</code></pre><p>class Gas():
     def <strong>init</strong>(self)#具体参见上面
         ...
     def def initialpop(self):#初始化种群
         ...
     def fun(self,x1): #定义函数
         ...
     def get_fitness(self,x):  #适应度函数
         ...
     def selection(self,popsel,fitvalue): #选择
         ...
     def crossover(self,pop): #交叉
         ...
     def mutation(self,pop): #变异
         ...
     def elitism(self,pop,popbest,nextbestfit,fitbest):#精英保留
         ...
     def get_declist(self,chroms): #解码
         ...
     def chromtodec(self,chrom): #二进制转十进制
         ...</p><pre><code class="hljs diff">
<span class="hljs-bullet"><span class="hljs-deletion">- </span></span><span class="hljs-deletion">运行主函数：</span>
</code></pre><p>if <strong>name</strong> == '<strong>main</strong>':
    generation = 100 # 遗传代数</p><pre><code class="hljs coffeescript"><span class="hljs-comment">#引入Gas类，传入参数：种群大小，编码长度，变量范围</span>
mainGas =Gas(<span class="hljs-number"><span class="hljs-number">100</span></span>,<span class="hljs-number"><span class="hljs-number">10</span></span>,<span class="hljs-number"><span class="hljs-number">-1</span></span>,<span class="hljs-number"><span class="hljs-number">2</span></span>) 
pop =mainGas.initialpop()  <span class="hljs-comment">#种群初始化</span>
pop_best = [] <span class="hljs-comment">#每代最优个体</span>
<span class="hljs-keyword">for</span> i <span class="hljs-keyword"><span class="hljs-keyword">in</span></span> xrange(generation): 
    <span class="hljs-comment">#在遗传代数内进行迭代</span>
    declist =mainGas.get_declist(pop)<span class="hljs-comment">#解码</span>
    fitvalue =mainGas.get_fitness(declist)<span class="hljs-comment">#适应度函数</span>
    <span class="hljs-comment">#选择适应度函数最高个体</span>
    popbest = pop[fitvalue.index(max(fitvalue))]
    <span class="hljs-comment">#对popbest进行深复制，以为后面精英选择做准备</span>
    popbest =copy.deepcopy(popbest)
    <span class="hljs-comment">#最高适应度</span>
    fitbest = max(fitvalue)
    <span class="hljs-comment">#保存每代最高适应度值</span>
    pop_best.append(fitbest)        
    <span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">##进行算子操作，并不断更新pop</span>
    mainGas.selection(pop,fitvalue)  <span class="hljs-comment">#选择</span>
    mainGas.crossover(pop) <span class="hljs-comment"># 交叉</span>
    mainGas.mutation(pop)  <span class="hljs-comment">#变异</span>
    <span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">##精英策略前的准备</span>
    对变异之后的pop，求解最大适应度
    nextdeclist = mainGas.get_declist(pop) 
    nextfitvalue =mainGas.get_fitness(nextdeclist)        
    nextbestfit = max(nextfitvalue) 
    <span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">######</span><span class="hljs-comment">##精英策略</span>
    <span class="hljs-comment">#比较深复制的个体适应度和变异之后的适应度</span>
    mainGas.elitism(pop,popbest,nextbestfit,fitbest)   
</code></pre><pre><code class="hljs diff"><span class="hljs-bullet"><span class="hljs-deletion">- </span></span><span class="hljs-deletion">对结果进行可视化分析：</span>
</code></pre><p>if <strong>name</strong> == '<strong>main</strong>':<br>    ...</p><pre><code class="hljs cs">t = [<span class="hljs-function">x </span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">for</span></span></span><span class="hljs-function"> x </span><span class="hljs-keyword"><span class="hljs-function"><span class="hljs-keyword">in</span></span></span><span class="hljs-function"> </span><span class="hljs-built_in"><span class="hljs-function"><span class="hljs-title">xrange</span></span></span><span class="hljs-function">(<span class="hljs-params">generation</span>)]
s </span>= pop_best
plt.plot(t,s)
plt.<span class="hljs-built_in">show</span>()
plt.<span class="hljs-built_in">close</span>()
</code></pre><p><code>`</code></p><p>最后可以通过matplot打印出计划图，个体从较小的适应度值，通过遗传进化爬升到较大值，并达到收敛。</p>