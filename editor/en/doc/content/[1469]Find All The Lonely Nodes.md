<p>In a binary tree, a <strong>lonely</strong> node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.</p>

<p>Given the <code>root</code> of a binary tree, return <em>an array containing the values of all lonely nodes</em> in the tree. Return the list <strong>in any order</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/06/03/e1.png" style="width: 203px; height: 202px;" /> 
<pre>
<strong>Input:</strong> root = [1,2,3,null,4]
<strong>Output:</strong> [4]
<strong>Explanation:</strong> Light blue node is the only lonely node.
Node 1 is the root and is not lonely.
Nodes 2 and 3 have the same parent and are not lonely.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/06/03/e2.png" style="width: 442px; height: 282px;" /> 
<pre>
<strong>Input:</strong> root = [7,1,4,6,null,5,3,null,null,null,null,null,2]
<strong>Output:</strong> [6,2]
<strong>Explanation:</strong> Light blue nodes are lonely nodes.
Please remember that order doesn't matter, [2,6] is also an acceptable answer.
</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/06/03/tree.png" style="width: 363px; height: 202px;" /> 
<pre>
<strong>
Input:</strong> root = [11,99,88,77,null,null,66,55,null,null,44,33,null,null,22]
<strong>Output:</strong> [77,55,33,66,44,22]
<strong>Explanation:</strong> Nodes 99 and 88 share the same parent. Node 11 is the root.
All other nodes are lonely.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the <code>tree</code> is in the range <code>[1, 1000].</code></li> 
 <li><code>1 &lt;= Node.val &lt;= 10<sup>6</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 489, 👎 10<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

<!-- vip -->
<!-- i_63956417e4b02685a425cc0d -->

本题思路为 labuladong 网站会员专属，请 [点击这里](https://labuladong.online/algo/intro/site-vip/) 购买会员并查看各个插件的解锁方法。

若之前已经购买会员并成功解锁，现在却突然出现这个问题，请尝试重新手动刷新插件数据，操作方法见 [这里](https://labuladong.online/algo/intro/site-vip/)。

若依然无法解决问题，可以在 [会员购买页](https://labuladong.online/algo/intro/site-vip/) 文末加我微信直接反馈，如是 bug 我会立即修复。</details>
</div>

