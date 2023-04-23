<p>Given the <code>root</code> of an n-ary tree, return <em>the preorder traversal of its nodes' values</em>.</p>

<p>Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png" style="width: 100%; max-width: 300px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
<strong>Output:</strong> [1,3,5,6,2,4]
</pre>

<p><strong class="example">Example 2:</strong></p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png" style="width: 296px; height: 241px;" /></p>

<pre>
<strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
<strong>Output:</strong> [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li> 
 <li>The height of the n-ary tree is less than or equal to <code>1000</code>.</li> 
</ul>

<p>&nbsp;</p> 
<p><strong>Follow up:</strong> Recursive solution is trivial, could you do it iteratively?</p>

<details><summary><strong>Related Topics</strong></summary>Stack | Tree | Depth-First Search</details><br>

<div>👍 2459, 👎 115<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；[第 13 期刷题打卡](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后一天报名！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

按照 [学习数据结构和算法的框架思维](https://labuladong.github.io/article/fname.html?fname=学习数据结构和算法的高效方法) 给出的二叉树遍历框架就能推导出多叉树遍历框架了。

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

```java
class Solution {
    public List<Integer> preorder(Node root) {
        traverse(root);
        return res;
    }

    List<Integer> res = new LinkedList<>();

    void traverse(Node root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        res.add(root.val);
        for (Node child : root.children) {
            traverse(child);
        }
        // 后序遍历位置
    }
}
```

</details>
</div>



