---
layout: post
title: "falling slowly"
date: 2017-2-9
category: 音乐
description: "上星期和同学一起录的，一次录成，qiao开心"
---
这是我花了一个星期的时间改编的一个html5的audio播放器代码，是不是很萌啊～具体内容我放在后面了，先听歌先听歌～

<link rel="stylesheet" href="/assets/css/audio.css" media="screen" type="text/css" />

<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
<iframe frameborder="0" scrolling="no" src="/assets/audio/music.html" width="800px" height="400px"></iframe>



![1](http://wx1.sinaimg.cn/mw690/8db2c8cbgy1fclbfcqbqdj208c09hjrk.jpg)
![2](http://wx2.sinaimg.cn/mw690/8db2c8cbgy1fclbffsvsej208c09haaj.jpg)
![3](http://wx4.sinaimg.cn/mw690/8db2c8cbgy1fclbfea5a8j208c08cjs1.jpg)
![4](http://wx2.sinaimg.cn/mw690/8db2c8cbgy1fclbfay0xfj208c08c3yn.jpg)

><link rel="stylesheet" href="/assets/css/audio.css" media="screen" type="text/css" />


这是index，我机智的用了iframe, 然后嵌入了另一个index，在下一个index中我们放入css和js等，这样一来不会让我的文章看得很乱，二来避免了播放器的css和js等和主网页有冲突。

	<div style="text-align:center;clear:both">
	<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
	<script src="/follow.js" type="text/javascript"></script>
	</div>
	<iframe frameborder="0" scrolling="no" src="/assets/audio/music.html" width="80%" height="300px"></iframe>


这是我的第二个index，也就是上面的`/assets/audio/music.html`:

	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>HTML5笑脸样式音乐播放器DEMO</title>
	<link rel="stylesheet" href="/assets/audio/css/style.css" media="screen" type="text/css" />
	<script type="text/javascript">
	window.onload=function(){
	   var canvas=document.getElementById('canvas');
	   if(canvas.getContext){
			var ctx=canvas.getContext("2d");
			ctx.beginPath();
			ctx.strokeStyle='darkgreen';
			ctx.lineCap='round';
			ctx.lineWidth=6;
			ctx.arc(160,160,150,0,Math.PI,false);
			ctx.stroke();
	   }					   
	}
	</script></head>
	<body>
	<div id="container">
		<canvas id="canvas" width="320" height="320">对不起，你的浏览器不支持Canvas标签！</canvas>
		<canvas id="progress" width="320" height="320"></canvas><!-- progress bar -->
		<div id="player">
			<audio id="audio" controls>
				<source src="/assets/falling.mp3" type="audio/mpeg" codecs="mp3"></source>		
			</audio>
			<div class="cover">
				<div class="controls">
					<div class="play_pause" id="play" title="Play" onClick="togglePlay()"><i>&#xe600;</i></div>
					<div class="play_pause" id="replay"  onclick="replayAudio()"><i>&#xe607;</i></div>
					<div class="voice"><i>&#xe608;</i><input id="volume" name="volume" min="0" max="1" step="0.1" type="range" onChange="setVolume()" /></div>
					<div id="times">00:00/00:00</div>
				</div><!-- #controls -->
				<div class="info">
					<p class="song"><a href="#" target="_blank">Falling Slowly</a></p>
					<p class="author"><a href="#" target="_blank">Liu Xin</a></p>
				</div>
			</div><!-- #cover -->
		</div><!-- #player -->
	</div><!-- #container -->
	<script src="/assets/audio/js/index.js"></script>
	</body>
	</html>

下面是js：

		var audio = document.getElementById('audio');
		var progress = document.getElementById('progress');
		var playpause = document.getElementById("play");
		var replay = document.getElementById("replay");
		var volume = document.getElementById("volume");
		var time=document.getElementById('times');
		audio.controls = false;
		// audio.autoplay=true;
		audio.addEventListener('timeupdate', function() {	
		  	updateProgress();
			  var	aTime =parseInt(audio.currentTime);
			  var   aLength =parseInt(audio.duration) ; 
			  if(aTime<10){
			  		time.innerHTML='00:0'+aTime+'/00:'+aLength;
			  }else{
			  	 time.innerHTML='00:'+aTime+'/00:'+aLength;
			  }
	      
		}, false);
	function togglePlay() {
	   if (audio.paused || audio.ended) {
	      playpause.title = "Pause";
	      playpause.innerHTML = '<i>&#xe603;</i>';
	      audio.play();
	   } else {
	      playpause.title = "Play";
	      playpause.innerHTML = '<i>&#xe600;</i>';
	      audio.pause();
	   }
	}
	function replayAudio(){
		audio.currentTime = 0; 
		ctx.clearRect(0,0,canvas.width,canvas.height);
	}
	function setVolume() {
	   audio.volume = volume.value;
	}
	var canvas = document.getElementById('progress');
	var ctx = canvas.getContext('2d');
	function updateProgress() {
		var percent = Math.floor((100 / audio.duration) * audio.currentTime);
		progress.value = percent;		
		var centerX = canvas.width / 2;
		var centerY = canvas.height / 2;
		var radius = 150;	
		var circ = Math.PI;
		var quart = Math.PI / 4;
		var cpercent = percent / 100; /* current percent */
		ctx.beginPath();
		ctx.lineCap='round';
		ctx.arc(centerX, centerY, radius,0, ((circ) * cpercent), false);
		ctx.lineWidth =5;
		ctx.strokeStyle = 'yellow';
		ctx.stroke();
		if(audio.ended){
			resetPlayer();
		}
	}
	function resetPlayer() {
		audio.currentTime = 0; 
		ctx.clearRect(0,0,canvas.width,canvas.height);
		playpause.title = "Play";
	    playpause.innerHTML = '<i>&#xe600;</i>';
	 	  /*playpause.title = "Play";
		  playpause.innerHTML = '<i class="fa fa-play fa-3x"></i>';*/
	}

最后css：

	*{
		margin: 0;padding: 0; 
	}
	*:before, *:after { box-sizing: border-box; }
	body { margin: 0; min-height: 100%; background: #EEE; font-family: 'Roboto Condensed', sans-serif; font-weight: 300;background: lightblue; }
	a { color: #FFF; text-decoration: none; }
	a:hover { color: #26C5CB; }
	p { margin: 0; }
	@font-face {font-family: 'iconfont';
		    src: url('../iconfont/iconfont.eot'); /* IE9*/
		    src: url('../iconfont/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
		    url('../iconfont/iconfont.woff') format('woff'), /* chrome、firefox */
		    url('../iconfont/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
		    url('../iconfont/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */
		}
	/* Centering */
	/#container, #progress,#canvas, #player, .cover{
		  position: absolute;
		  margin: auto;
		  top: 0;
		  left: 0;
		  right: 0;
	  	  bottom: 0;
	}
	/#container {
		  width: 350px;
		  height: 320px;/* 
		        perspective: 550px;
		  -webkit-perspective: 550px;
		         transform-style: preserve-3d;
		  -webkit-transform-style: preserve-3d; //perspective 属性定义 3D 元素距视图的距离，以像素计。该属性允许您改变 3D 元素查看 3D 元素的视图。
	当为元素定义 perspective 属性时，其子元素会获得透视效果，而不是元素本身。*/
	}
	/#player {
	  	width: 320px;
		height: 320px;
		overflow: hidden;
		z-index:3;
	}
	/#progress {
		  width: 320px;
		  height: 320px;
		  z-index:2;     
		  transform: rotateY(180deg);
		  -webkit-transform: rotateY(180deg);
		  filter: blur(1.5px);
		  -webkit-filter: blur(1.5px);
	}
	/#canvas{
		  width: 320px;
		  height: 320px;
		  z-index:1;
		  
	}
	/* Player Buttons */
	.cover{
		top:30%;
		z-index:500;
	}
	.controls {
		  position: relative;
		  width: 100%;
		  height: 50%;
		  color: #fff;
		  text-align: center;
		  overflow: hidden;
	}
	.play_pause{
		  position: absolute;
		  left:0%;
		  top: 0;
		  width:24px;
		  height:24px;
		  color: #fff;
		  border: 0;
		  outline: 0;
		  text-align: center;
		  background: #fff;
		  border-radius: 100%;
		  cursor: pointer;
		  z-index: 10;
	}
	/#replay{
		left: auto;
		right: 0;
		background:darkgreen ;
	}
	.play_pause:hover {
		  color: #26C5CB;
	}
	.play_pause i{
		display: block;
		line-height:24px;
		font-style: normal;
		font-family: 'iconfont';
		font-size:24px;
		color: darkgreen;
		cursor: pointer;
	}
	/#replay i{
		font-size: 14px;
		color: #fff
	}
	/#times{
		width:80px;
		height:20px;
		background: #000;
		border-radius: 10px;
		position: absolute;
		left:50%;
		margin-left: -40px;
		top:30%;
		line-height:20px;
		font-size:0.6em;
	}		   
	.voice{
		position: absolute;
		left: 50%;
		margin-left: -40px;
		top:0;
		-webkit-appearance: none !important;
	}
	/*.voice i{
		display: block;
		font-style: normal;
		font-family: 'iconfont';
		font-size:12px;
		color: darkgreen;
		cursor: pointer;
		float: left;
		margin-top:15px;
	}*/
	/* Volume */
	input[type='range'] {
		  display: block;
		  margin:20px auto;
		  width: 80px;
	      height: 2px; 
		  outline: 0;
		  cursor: pointer;
		  box-shadow: 1px 1px 3px 0 #000;
		  -webkit-appearance: none !important;
		  float: left;
	}
	input[type='range']::-webkit-slider-thumb {
		  background: #AEAEAE;
		  height: 6px;
		  width: 6px;
		  border-radius: 50%;
		  transition: .3s all linear;
		  -webkit-transition: .3s all linear;
		  -webkit-appearance: none !important;
	}
	input[type='range']:hover::-webkit-slider-thumb {
	  	  background: darkgreen;
		  -webkit-transform:scale(2);
	}
	/* Song Info */
	.info {
	  	position: relative;
		  margin-top: 28px;
		  bottom: 10px;
		  color: #fff;
		  text-align: center;
	}
	.song {
		  font-size: 18px;
	}
	.author {
		  font-size: 14px;
		  margin-bottom: -8px;
	}
	/* ... */
	.song,
	.author,
	.playlist a {
		  white-space: nowrap; 
		  overflow: hidden;
		  text-overflow: ellipsis;
	}
	/* Media Queries */
	@media all and (max-width: 768px) {
		  #container, #player { width: 150px; height: 150px;}
		  #progress { width: 160px; height: 160px; margin-top: -5px; margin-left: -5px; }
		  label, .lyrics, .scroll { display: none; }
		  .cover { padding-top: 46px; }
		  button { margin: 4px; }
		  button:first-of-type, button:last-of-type { display: none; }
		  input[type='range'] { display: block; margin-top: -76px; height: 1px; }
		  .info { margin-top: 70px; }
		  .song { font-size: 12px; }
		  .author { font-size: 10px; }
	}

最后把这两个文件放到你想要的位置，修改我的index2的路径就大功告成啦！