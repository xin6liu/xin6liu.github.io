<!-- ---
title: 我的故事 My stories 
layout: landing
description: 'Lorem ipsum dolor sit amet nullam consequa<br />sed veroeros. tempus adipiscing nulla.'
image: assets/images/pic07.jpg
--- -->
<!-- banner -->
<section id="banner" class="style2">
  <div class="inner">
<!-- 图片背景 -->
    <span class="image">
    <img src="{{ site.baseurl }}/{{ page.image }}" alt="">
    </span>
<!-- 题目 -->
    <header class="major">
    {{ page.title }}
    </header>
<!-- 描述 -->
    <div class="content">
    {{ page.description }}
    </div>
  </div>
</section>

<!-- 正文 -->
<div id="main">
<!-- section1 --> 
  <section id="one"> 
    <div class="inner">
    <header class="major">
    小标题1
    </header>
    段落1
    </div><p></p>
  </section><p></p>
<!-- section2 -->     
  <section id="two" class="spotlights">
    <section>
      <a href="generic.html">
        <img src="assets/images/pic08.jpg" alt="" data-position="center center">
      </a>
      <div class="content">
        <div class="inner">
          <header class="major">
          小标题2
          </header>
          段落2
          <em><a href="generic.html">链接</a></em>
        </div>
      </div>
    </section>
    <section>
    <em><a href="generic.html"><img src="assets/images/pic09.jpg" alt="" data-position="top center"></a></em>
    <div class="content">
    <em></em>
    <div class="inner"><em><header class="major">小标题3</header>段落3</em></div></div></section>

<section><a href="generic.html"><img src="assets/images/pic10.jpg" alt="" data-position="25% 25%"></a>

<div class="content"><div class="inner"><header class="major">小标题4</header>段落4<em></em></div></div></section><em><p></p></em></section><em><p></p></em>

<!-- section3 --> 
  <section id="three">
    <em></em>
    <div class="inner">
    <em><header class="major">小标题5</header>段落5</em>
    </div>
  </section>
  <p></p>

  <link rel="stylesheet" href="/assets/css/swiper.min.css">
<style>
    body {}
    .swiper-container {
          width: 100%;
          padding-top: 50px;
          padding-bottom: 50px;
      }
    .swiper-slide {
          background-position: center;
          background-size: cover;
          width: 300px;
          height: 300px;
      }
</style>

<p>我叫刘鑫，一个默默无闻的单身好青年，理想是做一个浪漫科研狗。</p>

mail: `15514657777@163.com` 或 `x399liu@uwaterloo.ca` 

<h2> 喜欢摄影 Love Taking Pictures</h2>

<div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide" style="background-image:url(http://ww2.sinaimg.cn/mw690/8db2c8cbgw1f4mu1zjvo4j20q90higqh.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww2.sinaimg.cn/mw690/8db2c8cbgw1f4mu1uehx2j20q90hiap2.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f4mu1t93tdj20q90hitit.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww2.sinaimg.cn/mw690/8db2c8cbgw1f4mu1vfp9cj20q90hi787.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f4mu1wgduqj20q90hin16.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f4mu1vxt9tj20q90hiq6p.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww2.sinaimg.cn/mw690/8db2c8cbgw1f91oao6j7yj21kw11x4dd.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f4mu1rpkydj20q90hidki.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww3.sinaimg.cn/mw690/8db2c8cbgw1f4mu1r8pdmj20q90hin1g.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f4mu1qtpjqj20q90hijux.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f4mu1ol153j20wt0lv0zv.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww3.sinaimg.cn/mw690/8db2c8cbgw1f4mu1mszz0j20q90hijwi.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f4mu1m30j5j20q90hidkr.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f4mu25ykqbj20q913etdt.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f91oagg11uj21kw2dcnp3.jpg)"></div>
  </div>
  <div class="swiper-pagination"></div>
</div>

<script src="/assets/js/swiper.min.js"></script>

<script>
var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        effect: 'coverflow',
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: 'auto',
        coverflow: {
            rotate: 50,
            stretch: 0,
            depth: 100,
            modifier: 1,
            slideShadows : true
        }
    });
</script>

<h2> 喜欢设计</h2>

<div class="swiper-container">
    <div class="swiper-wrapper">
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f9b0uptfr6j21kw29xu0x.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww2.sinaimg.cn/mw690/8db2c8cbgw1f9b0uuft9wj21kw29xx6g.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww3.sinaimg.cn/mw690/8db2c8cbgw1f9b0xdu7zuj20sv150tm0.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f9b0udh6lyj20sv151wz1.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f9b0bydgb8j20yf1cqtwe.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww3.sinaimg.cn/mw690/8db2c8cbgw1f9b0bu1y0qj20yf1cqqrh.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww4.sinaimg.cn/mw690/8db2c8cbgw1f9b0uk523cj20yf1cqqii.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f9b0uyu2pqj20qo0jxmz5.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww2.sinaimg.cn/mw690/8db2c8cbgw1f9b0uwnwgpj20jw0qogos.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f9b0x12rqpj21cq0yf15j.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww2.sinaimg.cn/mw690/8db2c8cbgw1f9b0x3v9g0j21cq0yfqe4.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f9b0x8hzd3j21cq0yftp2.jpg)"></div>
            <div class="swiper-slide" style="background-image:url(http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f9b0xb4p0rj21cq0yf44b.jpg)"></div>
    </div>
    <div class="swiper-pagination"></div>
</div>


<script src="/assets/js/swiper.min.js"></script>
<script>
var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        effect: 'coverflow',
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: 'auto',
        coverflow: {
            rotate: 50,
            stretch: 0,
            depth: 100,
            modifier: 1,
            slideShadows : true
        }
    });
</script>




<iframe width="760px" height="500px" src="https://sway.com/s/8CsBDymPwIEAei84/embed" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border: none; max-width:100%; max-height:100vh" allowfullscreen webkitallowfullscreen mozallowfullscreen msallowfullscreen></iframe>






 <h2> 喜欢吉他</h2>

<iframe width="760px" height="500px" src="https://sway.com/s/RUcEizqz03GJxRmX/embed" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border: none; max-width:100%; max-height:100vh" allowfullscreen webkitallowfullscreen mozallowfullscreen msallowfullscreen></iframe>

 <h2> 喜欢篮球</h2>
<div class="image fit">
<img src="http://ww1.sinaimg.cn/mw690/8db2c8cbgw1f91q0elykhj20im0agdhr.jpg" />
<img src="http://ww3.sinaimg.cn/mw690/8db2c8cbgw1f91q0cz3ddj20zk0qodjy.jpg" />
</div>

 <h2> 喜欢视频制作</h2>

<iframe width="760px" height="500px" src="https://sway.com/s/kLIYRTg8Gd2i5Tzf/embed" frameborder="0" marginwidth="0" marginheight="0" scrolling="no" style="border: none; max-width:100%; max-height:100vh" allowfullscreen webkitallowfullscreen mozallowfullscreen msallowfullscreen></iframe>

 <h2> 不喜欢填坑</h2>

<p>嘻嘻，开玩笑啦～ 考完试我就把这个网站写完</p>

<h2>Projects</h2>

<ul>
  <li><a href="https://nano-er.com/">www.nano-er.com</a></li>
  <li><a href="https://liuxin.in/">www.liuxin.in</a></li>
</ul>
</div>
