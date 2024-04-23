<p>You are given the <code>root</code> of a binary tree containing digits from <code>0</code> to <code>9</code> only.</p>

<p>Each root-to-leaf path in the tree represents a number.</p>

<ul> 
 <li>For example, the root-to-leaf path <code>1 -&gt; 2 -&gt; 3</code> represents the number <code>123</code>.</li> 
</ul>

<p>Return <em>the total sum of all root-to-leaf numbers</em>. Test cases are generated so that the answer will fit in a <strong>32-bit</strong> integer.</p>

<p>A <strong>leaf</strong> node is a node with no children.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num1tree.jpg" style="width: 212px; height: 182px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3]
<strong>Output:</strong> 25
<strong>Explanation:</strong>
The root-to-leaf path <span><code>1-&gt;2</code></span> represents the number <span><code>12</code></span>.
The root-to-leaf path <span><code>1-&gt;3</code></span> represents the number <span><code>13</code></span>.
Therefore, sum = 12 + 13 = <span><code>25</code></span>.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/num2tree.jpg" style="width: 292px; height: 302px;" /> 
<pre>
<strong>Input:</strong> root = [4,9,0,5,1]
<strong>Output:</strong> 1026
<strong>Explanation:</strong>
The root-to-leaf path <span><code>4-&gt;9-&gt;5</code></span> represents the number 495.
The root-to-leaf path <span><code>4-&gt;9-&gt;1</code></span> represents the number 491.
The root-to-leaf path <span><code>4-&gt;0</code></span> represents the number 40.
Therefore, sum = 495 + 491 + 40 = <span><code>1026</code></span>.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 1000]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>The depth of the tree will not exceed <code>10</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Binary Tree</details><br>

<div>👍 7566, 👎 124<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_63956417e4b02685a425cc0d -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并查看各个插件的解锁方法。

若之前已经购买会员并成功解锁，现在却突然出现这个问题，请尝试重新手动刷新插件数据，操作方法见 [这里](https://labuladong.online/algo/intro/site-vip/)。

若依然无法解决问题，可以在 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 文末加我微信直接反馈，如是 bug 我会立即修复。</details>
</div>

