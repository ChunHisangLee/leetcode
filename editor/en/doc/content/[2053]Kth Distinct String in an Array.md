<p>A <strong>distinct string</strong> is a string that is present only <strong>once</strong> in an array.</p>

<p>Given an array of strings <code>arr</code>, and an integer <code>k</code>, return <em>the </em><code>k<sup>th</sup></code><em> <strong>distinct string</strong> present in </em><code>arr</code>. If there are <strong>fewer</strong> than <code>k</code> distinct strings, return <em>an <strong>empty string </strong></em><code>""</code>.</p>

<p>Note that the strings are considered in the <strong>order in which they appear</strong> in the array.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = ["d","b","c","b","c","a"], k = 2
<strong>Output:</strong> "a"
<strong>Explanation:</strong>
The only distinct strings in arr are "d" and "a".
"d" appears 1<sup>st</sup>, so it is the 1<sup>st</sup> distinct string.
"a" appears 2<sup>nd</sup>, so it is the 2<sup>nd</sup> distinct string.
Since k == 2, "a" is returned. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = ["aaa","aa","a"], k = 1
<strong>Output:</strong> "aaa"
<strong>Explanation:</strong>
All strings in arr are distinct, so the 1<sup>st</sup> string "aaa" is returned.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = ["a","b","a"], k = 3
<strong>Output:</strong> ""
<strong>Explanation:</strong>
The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= k &lt;= arr.length &lt;= 1000</code></li> 
 <li><code>1 &lt;= arr[i].length &lt;= 5</code></li> 
 <li><code>arr[i]</code> consists of lowercase English letters.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | String | Counting</details><br>

<div>👍 773, 👎 32<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[新版网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价；已支持老用户续费~**

</div>

