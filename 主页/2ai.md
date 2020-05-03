---
layout: 2ai
title: 机器学习 Machine Learning
description: TensorFlow, ScikitLeran
image: assets/images/pic02.jpg
nav-menu: true
---

<html>
	<head>
		<title>ai</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="/file/2ai/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

<!-- Sidebar -->
<section id="sidebar">
				<div class="inner">
					<nav>
						<ul>
							<li><a href="#intro">最近文章</a></li>
							<li><a href="#one">分类</a></li>
							<li><a href="#two">主页</a></li>
							<li><a href="#three">联系我</a></li>
						</ul>
					</nav>
				</div>
			</section>

<!-- Wrapper -->
<div id="wrapper">

<!-- Intro -->
<section id="intro" class="wrapper style1 fullscreen fade-up">
						<div class="inner">
							<h1>最近文章</h1>
							<ul class="posts">
	{% for post in site.posts %}
		{% if post.category == "ai" %}
		<li>
			<a href="{{ post.url }}">{{ post.title }}</a>
			<span> &raquo; {{ post.date | date: "%B %d, %Y" }}</span>
		</li>
		{% endif %}
	{% endfor %}
</ul>
						</div>
					</section>

<!-- One -->
<section id="one" class="wrapper style2 spotlights">
						<section>
							<a href="#" class="image"><img src="/file/2ai/images/pic01.jpg" alt="" data-position="center center" /></a>
							<div class="content">
								<div class="inner">
									<h2>理论知识</h2>
									<p>依据吴恩达在Coursera上的机器学习课程.</p>
									<ul class="actions">
										<li><a href="#" class="button">Learn more</a></li>
									</ul>
								</div>
							</div>
						</section>
						<section>
							<a href="#" class="image"><img src="/file/2ai/images/pic02.jpg" alt="" data-position="top center" /></a>
							<div class="content">
								<div class="inner">
									<h2>编程相关</h2>
									<p>主要利用Python结合机器学习.</p>
									<ul class="actions">
										<li><a href="#" class="button">Learn more</a></li>
									</ul>
								</div>
							</div>
						</section>
						<section>
							<a href="#" class="image"><img src="/file/2ai/images/pic03.jpg" alt="" data-position="25% 25%" /></a>
							<div class="content">
								<div class="inner">
									<h2>实战</h2>
									<p>一些开源项目.</p>
									<ul class="actions">
										<li><a href="#" class="button">Learn more</a></li>
									</ul>
								</div>
							</div>
						</section>
					</section>

<!-- Two -->
<section id="two" class="wrapper style3 fade-up">
						<div class="inner">
							<h2><a href="/index.html">主页</a></h2>
							<h3><a href="/index.html">Xin Liu's Blog 刘鑫的博客</a></h3>
							<p>求知若渴 虚怀若愚  STAY HUNGRY, STAY FOOLISH.</p>
							<div class="features">
								<section>
									<span class="icon major fa-code"></span>
									<h3>python</h3>
									<p>人生苦短，我用Python</p>
								</section>
								<section>
									<span class="icon major fa-chain"></span>
									<h3>机器学习</h3>
									<p>TensorFlow, ScikitLeran.</p>
								</section>
								<section>
									<span class="icon major fa-cog"></span>
									<h3>计算流体力学</h3>
									<p>这个专栏的文章分为三类：一类是基础知识方面，主要是参考曾攀先生的有限元分析基础教程写的读书笔记，以及ACE相关的基础数学和物理方面的知识总结；第二类是据comsol官方网站的一些资料、示例、博客等进行的翻译；第三类是自己的一些技巧总结.</p>
								</section>
								<section>
									<span class="icon major fa-desktop"></span>
									<h3>计算机科学</h3>
									<p>分为计算机语言，软件两大类。这个专题主要是我相对擅长的网页语言(html,ruby,css,js等)，数学软件(matlab,R等)，和标记语言(LaTeX,markdown等)的学习心得.</p>
								</section>
								<section>
									<span class="icon major fa-chain"></span>
									<h3>纳米材料与技术</h3>
									<p>纳米材料与技术是我本科的专业，本专题就与它有关.</p>
								</section>
								<section>
									<span class="icon major fa-diamond"></span>
									<h3>课程</h3>
									<p>本专题收录了大学上的课程(数学、物理、化学、生物等)的课堂与课下笔记，但可能不是很全.</p>
								</section>
							</div>
							<ul class="actions">
								<li><a href="#" class="button">Learn more</a></li>
							</ul>
						</div>
					</section>

<!-- Three -->
<section id="three" class="wrapper style1 fade-up">
						<div class="inner">
							<h2>联系我</h2>
							<p>因为是静态网页，请利用下面的表格给我发邮件.</p>
							<div class="split style1">
								<section>
									<form method="post" action="#">
										<div class="field half first">
											<label for="name">Name</label>
											<input type="text" name="name" id="name" />
										</div>
										<div class="field half">
											<label for="email">Email</label>
											<input type="text" name="email" id="email" />
										</div>
										<div class="field">
											<label for="message">Message</label>
											<textarea name="message" id="message" rows="5"></textarea>
										</div>
										<ul class="actions">
											<li><a href="" class="button submit">Send Message</a></li>
										</ul>
									</form>
								</section>
								<section>
									<ul class="contact">
										<li>
											<h3>Address</h3>
											<span>201 Lester<br />
											Waterloo, ON<br />
											CANADA</span>
										</li>
										<li>
											<h3>Email</h3>
											<a href="#">x399liu@edu.uwaterloo.ca</a>
										</li>
										<li>
											<h3>Phone</h3>
											<span>(226) 505-6868</span>
										</li>
										<li>
											<h3>Social</h3>
											<ul class="icons">
												<li><a href="#" class="fa-twitter"><span class="label">Twitter</span></a></li>
												<li><a href="#" class="fa-facebook"><span class="label">Facebook</span></a></li>
												<li><a href="#" class="fa-github"><span class="label">GitHub</span></a></li>
												<li><a href="#" class="fa-instagram"><span class="label">Instagram</span></a></li>
												<li><a href="#" class="fa-linkedin"><span class="label">LinkedIn</span></a></li>
											</ul>
										</li>
									</ul>
								</section>
							</div>
						</div>
					</section>

			</div>

<!-- Footer -->
<footer id="footer" class="wrapper style1-alt">
				<div class="inner">
					<ul class="menu">
						<li>&copy; Untitled. All rights reserved.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
					</ul>
				</div>
			</footer>

<!-- Scripts -->
<script src="/file/2ai/assets/js/jquery.min.js"></script>
			<script src="/file/2ai/assets/js/jquery.scrollex.min.js"></script>
			<script src="/file/2ai/assets/js/jquery.scrolly.min.js"></script>
			<script src="/file/2ai/assets/js/skel.min.js"></script>
			<script src="/file/2ai/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="/file/2ai/assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="/file/2ai/assets/js/main.js"></script>

	</body>
</html>