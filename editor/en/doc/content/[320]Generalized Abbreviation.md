<p>A word's <strong>generalized abbreviation</strong> can be constructed by taking any number of <strong>non-overlapping</strong> and <strong>non-adjacent</strong> <span data-keyword="substring-nonempty">substrings</span> and replacing them with their respective lengths.</p>

<ul> 
 <li>For example, <code>"abcde"</code> can be abbreviated into: </li>
</ul>

    <ul>
    	<li><code>&quot;a3e&quot;</code> (<code>&quot;bcd&quot;</code> turned into <code>&quot;3&quot;</code>)</li>
    	<li><code>&quot;1bcd1&quot;</code> (<code>&quot;a&quot;</code> and <code>&quot;e&quot;</code> both turned into <code>&quot;1&quot;</code>)</li>
    	<li><code>&quot;5&quot;</code> (<code>&quot;abcde&quot;</code> turned into <code>&quot;5&quot;</code>)</li>
    	<li><code>&quot;abcde&quot;</code> (no substrings replaced)</li>
    </ul>
    </li>
    <li>However, these abbreviations are <strong>invalid</strong>:
    <ul>
    	<li><code>&quot;23&quot;</code> (<code>&quot;ab&quot;</code> turned into <code>&quot;2&quot;</code> and <code>&quot;cde&quot;</code> turned into <code>&quot;3&quot;</code>) is invalid as the substrings chosen are adjacent.</li>
    	<li><code>&quot;22de&quot;</code> (<code>&quot;ab&quot;</code> turned into <code>&quot;2&quot;</code> and <code>&quot;bc&quot;</code> turned into <code>&quot;2&quot;</code>) is invalid as the substring chosen overlap.</li>
    </ul>
    </li>


<p>Given a string <code>word</code>, return <em>a list of all the possible <strong>generalized abbreviations</strong> of</em> <code>word</code>. Return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> word = "word"
<strong>Output:</strong> ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> word = "a"
<strong>Output:</strong> ["1","a"]
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= word.length &lt;= 15</code></li> 
 <li><code>word</code> consists of only lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>String | Backtracking | Bit Manipulation</details><br>

<div>👍 684, 👎 226<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

</div>

