<h1 id="-">写语义化代码应该注意什么</h1>
<ul><li>尽可能少的使用无语义的标签div和span；在语义不明显时，既可以使用div或者p时，尽量用p, 因为p在默认情况下有上下间距，对兼容特殊终端有利；</li>
<li>不要使用纯样式标签，如：b、font、u等，改用css设置。需要强调的文本，可以包含在strong或者em标签中（浏览器预设样式，能用CSS指定就不用他们），strong默认样式是加粗（不要用b），em是斜体（不用i）；</li>
<li>使用表格时，标题要用caption，表头用thead，主体部分用tbody包围，尾部用tfoot包围。表头和一般单元格要区分开，表头用th，单元格用td；</li>
<li>表单域要用fieldset标签包起来，并用legend标签说明表单的用途；每个input标签对应的说明文本都需要使用label标签，并且通过为input设置id属性，在lable标签中设置for=someld来让说明文本和相对应的input关联起来。</li>
</ul><h1 id="-">常用的一些语义化标签</h1>
<ul><li><code>&lt;h1&gt;</code>~<code>&lt;h6&gt;</code> ，作为标题使用，并且依据重要性递减，<code>&lt;h1&gt;</code> 是最高的等级。</li>
<li><code>&lt;p&gt;</code>段落标记，知道了 <code>&lt;p&gt;</code> 作为段落，你就不会再使用 <code>&lt;br /&gt;</code> 来换行了，而且不需要 <code>&lt;br /&gt;</code> 来区分段落与段落。<code>&lt;p&gt;</code> 中的文字会自动换行，而且换行的效果优于 <code>&lt;br /&gt;</code>。段落与段落之间的空隙也可以利用 CSS 来控制，很容易而且清晰的区分出段落与段落。</li>
<li><code>&lt;ul&gt;</code>、<code>&lt;ol&gt;</code>、<code>&lt;li&gt;</code>，<code>&lt;ul&gt;</code> 无序列表，这个被大家广泛的使用，<code>&lt;ol&gt;</code> 有序列表不常用。在 Web 标准化过程中，<code>&lt;ul&gt;</code> 还被更多的用于导航条，本来导航条就是个列表，这样做是完全正确的，而且当你的浏览器不支持 CSS 的时候，导航链接仍然很好使，只是美观方面差了一点而已。</li>
<li><code>&lt;dl&gt;</code>、<code>&lt;dt&gt;</code>、<code>&lt;dd&gt;</code>，<code>&lt;dl&gt;</code> 就是“定义列表”。比如说词典里面的词的解释、定义就可以用这种列表。<strong>dl不单独使用，它通常与dt和dd一起使用。dl开启一个定义列表，dt表示要定义的项目名称，dd表示对dt的项目的描述。</strong></li>
<li><code>&lt;em&gt;</code>、<code>&lt;strong&gt;</code>，<code>&lt;em&gt;</code> 是用作强调，<code>&lt;strong&gt;</code> 是用作重点强调。</li>
<li><code>&lt;table&gt;</code>、<code>&lt;thead&gt;</code>、<code>&lt;tbody&gt;</code>、<code>&lt;td&gt;</code>、<code>&lt;th&gt;</code>、<code>&lt;caption&gt;</code>， 就是用来做表格不要用来布局</li>
</ul><h1 id="html5-">HTML5新增的那些</h1>
<p>HTML5标准更加的讲究语义化了，借用一张网上的图来说明这些新标签</p>
<p><img src="http://www.html5jscss.com/pic/htmljscss/html5-layout.jpg" alt="H5新增布局标签"></p>
<ul><li><code>header元素</code>：header 元素代表“网页”或“section”的页眉。</li>
<li><code>footer元素</code>：footer元素代表“网页”或“section”的页脚，通常含有该节的一些基本信息，譬如：作者，相关文档链接，版权资料。</li>
<li><code>hgroup元素</code>：</li>
<li><code>nav元素</code>：nav元素代表页面的导航链接区域。用于定义页面的主要导航部分。</li>
<li><code>aside元素</code>：aside元素被包含在article元素中作为主要内容的附属信息部分，其中的内容可以是与当前文章有关的相关资料、标签、名次解释等。（特殊的section）</li>
<li><code>section元素</code>：section元素代表文档中的“节”或“段”，“段”可以是指一篇文章里按照主题的分段；“节”可以是指一个页面里的分组。section通常还带标题，虽然html5中section会自动给标题h1-h6降级，但是最好手动给他们降级。</li>
<li><code>article元素</code>：article元素最容易跟section和div容易混淆，其实article代表一个在文档，页面或者网站中自成一体的内容，其目的是为了让开发者独立开发或重用。譬如论坛的帖子，博客上的文章，一篇用户的评论，一个互动的widget小工具。（特殊的section）除了它的内容，article会有一个标题（通常会在header里），会有一个footer页脚。</li>
</ul><p>推荐看原博主的博客：<a href="http://www.html5jscss.com/html5-semantics-section.html" target="_blank">传送门</a></p>