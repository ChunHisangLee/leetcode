<p>Given an integer array <code>nums</code>, return <em>the value of the bitwise </em><strong>OR</strong><em> of the sum of all possible <strong>subsequences</strong> in the array</em>.</p>

<p>A <strong>subsequence</strong> is a sequence that can be derived from another sequence by removing zero or more elements without changing the order of the remaining elements.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,1,0,3]
<strong>Output:</strong> 7
<strong>Explanation:</strong> All possible subsequence sums that we can have are: 0, 1, 2, 3, 4, 5, 6.
And we have 0 OR 1 OR 2 OR 3 OR 4 OR 5 OR 6 = 7, so we return 7.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,0,0]
<strong>Output:</strong> 0
<strong>Explanation:</strong> 0 is the only possible subsequence sum we can have, so we return 0.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Math | Bit Manipulation | Brainteaser</details><br>

<div>👍 33, 👎 5<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

</div>

