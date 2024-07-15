<p>Given the root of a binary tree and two integers <code>p</code> and <code>q</code>, return <em>the <strong>distance</strong> between the nodes of value </em><code>p</code><em> and value </em><code>q</code><em> in the tree</em>.</p>

<p>The <strong>distance</strong> between two nodes is the number of edges on the path from one to the other.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" /> 
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 0
<strong>Output:</strong> 3
<strong>Explanation:</strong> There are 3 edges between 5 and 0: 5-3-1-0.</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" /> 
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 7
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are 2 edges between 5 and 7: 5-2-7.</pre>

<p><strong class="example">Example 3:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" /> 
<pre>
<strong>Input:</strong> root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 5
<strong>Output:</strong> 0
<strong>Explanation:</strong> The distance between a node and itself is 0.</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in the tree is in the range <code>[1, 10<sup>4</sup>]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>9</sup></code></li> 
 <li>All <code>Node.val</code> are <strong>unique</strong>.</li> 
 <li><code>p</code> and <code>q</code> are values in the tree.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Hash Table | Tree | Depth-First Search | Breadth-First Search | Binary Tree</details><br>

<div>👍 423, 👎 17<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[新版网站会员](https://labuladong.online/algo/intro/site-vip/) 即将涨价！算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题很明显是最近公共祖先问题（LCA）的拓展，原版的 LCA 问题是让我们返回最近公共祖先节点，现在相当于是在问 `p` 和 `q` 到最近公共祖先的树枝的距离之和。

不过说实话，这题的难度还是比较大的，需要你认真阅读我写的 [一文秒杀所有二叉树最近公共祖先问题](https://labuladong.online/algo/practice-in-action/lowest-common-ancestor-summary/)，理解 LCA 问题解法逐步演进的原理，然后再来看这道题。

具体看代码注释吧，最好结合 [东哥手把手带你刷二叉树（纲领篇）](https://labuladong.online/algo/essential-technique/binary-tree-summary/) 体悟一下二叉树的遍历顺序，毕竟递归算法不是线性执行的，只要搞明白代码的执行顺序就可以更深刻地理解递归。

**标签：[二叉树](https://labuladong.online/algo/)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    int findDistance(TreeNode* root, int p, int q) {
        lca(root, p, q);
        return res;
    }

private:
    bool found = false;
    int res = 0;

    // 定义：当子树中不包含 p 或 q 时，返回 0；
    // 当子树中仅包含 p 或 q 中的一个时，返回 root 到 p 或 q 的距离；
    // 当子树中同时包含 p 和 q 时，返回一个无意义的值（答案会被存在外部变量 res 中）
    int lca(TreeNode* root, int p, int q) {
        if (found) {
            // found 为 true 时答案已经被记录在全局 res 中
            // 递归函数的返回值已不需要了，此时返回什么值都无所谓
            return 123;
        }
        if (!root) {
            return 0;
        }

        int left = lca(root->left, p, q);
        int right = lca(root->right, p, q);

        if (left == 0 && right == 0) {
            // root 的左右子树都不包含 p 或 q
            if (root->val == p || root->val == q) {
                return 1;
            }
            return 0;
        }

        if (left != 0 && right != 0 && !found) {
            // 当前节点 root 就是 p, q 的最近公共祖先节点
            // 答案已经算出来了，更新全局变量
            res = left + right;
            // 这个递归函数的返回值已经不重要了，让它终止递归
            found = true;
            return 456;
        }

        // 此时 left 和 right 有一个为 0，即只找到了一个节点
        // branch 就是到该节点的距离
        int branch = left == 0 ? right : left;

        if (root->val == p || root->val == q) {
            res = branch;
        }

        return branch + 1;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findDistance(self, root: TreeNode, p: int, q: int) -> int:
        self.found = False
        self.res = 0
        self.lca(root, p, q)
        return self.res

    # 定义：当子树中不包含 p 或 q 时，返回 0；
    # 当子树中仅包含 p 或 q 中的一个时，返回 root 到 p 或 q 的距离；
    # 当子树中同时包含 p 和 q 时，返回一个无意义的值（答案会被存在外部变量 res 中）
    def lca(self, root: TreeNode, p: int, q: int) -> int:
        if self.found:
            # found 为 true 时答案已经被记录在全局 res 中
            # 递归函数的返回值已不需要了，此时返回什么值都无所谓
            return 123
        if root is None:
            return 0

        left = self.lca(root.left, p, q)
        right = self.lca(root.right, p, q)

        if left == 0 and right == 0:
            # root 的左右子树都不包含 p 或 q
            if root.val == p or root.val == q:
                return 1
            return 0

        if left != 0 and right != 0 and not self.found:
            # 当前节点 root 就是 p, q 的最近公共祖先节点
            # 答案已经算出来了，更新全局变量
            self.res = left + right
            # 这个递归函数的返回值已经不重要了，让它终止递归
            self.found = True
            return 456

        # 此时 left 和 right 有一个为 0，即只找到了一个节点
        # branch 就是到该节点的距离
        branch = right if left == 0 else left

        if root.val == p or root.val == q:
            self.res = branch

        return branch + 1
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        lca(root, p, q);
        return res;
    }


    boolean found = false;
    int res = 0;

    // 定义：当子树中不包含 p 或 q 时，返回 0；
    // 当子树中仅包含 p 或 q 中的一个时，返回 root 到 p 或 q 的距离；
    // 当子树中同时包含 p 和 q 时，返回一个无意义的值（答案会被存在外部变量 res 中）
    int lca(TreeNode root, int p, int q) {
        if (found) {
            // found 为 true 时答案已经被记录在全局 res 中
            // 递归函数的返回值已不需要了，此时返回什么值都无所谓
            return 123;
        }
        if (root == null) {
            return 0;
        }

        int left = lca(root.left, p, q);
        int right = lca(root.right, p, q);

        if (left == 0 && right == 0) {
            // root 的左右子树都不包含 p 或 q
            if (root.val == p || root.val == q) {
                return 1;
            }
            return 0;
        }

        if (left != 0 && right != 0 && !found) {
            // 当前节点 root 就是 p, q 的最近公共祖先节点
            // 答案已经算出来了，更新全局变量
            res = left + right;
            // 这个递归函数的返回值已经不重要了，让它终止递归
            found = true;
            return 456;
        }

        // 此时 left 和 right 有一个为 0，即只找到了一个节点
        // branch 就是到该节点的距离
        int branch = left == 0 ? right : left;

        if (root.val == p || root.val == q) {
            res = branch;
        }

        return branch + 1;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findDistance(root *TreeNode, p int, q int) int {
    var found bool = false
    var res int = 0

    // 定义：当子树中不包含 p 或 q 时，返回 0；
    // 当子树中仅包含 p 或 q 中的一个时，返回 root 到 p 或 q 的距离；
    // 当子树中同时包含 p 和 q 时，返回一个无意义的值（答案会被存在外部变量 res 中）
    var lca func(root *TreeNode, p, q int) int
    lca = func(root *TreeNode, p, q int) int {
        if found {
            // found 为 true 时答案已经被记录在全局 res 中
            // 递归函数的返回值已不需要了，此时返回什么值都无所谓
            return 123
        }
        if root == nil {
            return 0
        }

        left := lca(root.Left, p, q)
        right := lca(root.Right, p, q)

        if left == 0 && right == 0 {
            // root 的左右子树都不包含 p 或 q
            if root.Val == p || root.Val == q {
                return 1
            }
            return 0
        }

        if left != 0 && right != 0 && !found {
            // 当前节点 root 就是 p, q 的最近公共祖先节点
            // 答案已经算出来了，更新全局变量
            res = left + right
            // 这个递归函数的返回值已经不重要了，让它终止递归
            found = true
            return 456
        }

        // 此时 left 和 right 有一个为 0，即只找到了一个节点
        // branch 就是到该节点的距离
        branch := 0
        if left == 0 {
            branch = right
        } else {
            branch = left
        }

        if root.Val == p || root.Val == q {
            res = branch
        }

        return branch + 1
    }
    lca(root, p, q)
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var findDistance = function(root, p, q) {
    let found = false;
    let res = 0;

    // 定义：当子树中不包含 p 或 q 时，返回 0；
    // 当子树中仅包含 p 或 q 中的一个时，返回 root 到 p 或 q 的距离；
    // 当子树中同时包含 p 和 q 时，返回一个无意义的值（答案会被存在外部变量 res 中）
    var lca = function(root, p, q) {
        if (found) {
            // found 为 true 时答案已经被记录在全局 res 中
            // 递归函数的返回值已不需要了，此时返回什么值都无所谓
            return 123;
        }
        if (root === null) {
            return 0;
        }

        let left = lca(root.left, p, q);
        let right = lca(root.right, p, q);

        if (left === 0 && right === 0) {
            // root 的左右子树都不包含 p 或 q
            if (root.val === p || root.val === q) {
                return 1;
            }
            return 0;
        }

        if (left !== 0 && right !== 0 && !found) {
            // 当前节点 root 就是 p, q 的最近公共祖先节点
            // 答案已经算出来了，更新全局变量
            res = left + right;
            // 这个递归函数的返回值已经不重要了，让它终止递归
            found = true;
            return 456;
        }

        // 此时 left 和 right 有一个为 0，即只找到了一个节点
        // branch 就是到该节点的距离
        let branch = left === 0 ? right : left;

        if (root.val === p || root.val === q) {
            res = branch;
        }

        return branch + 1;
    };

    lca(root, p, q);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_find-distance-in-a-binary-tree" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-distance-in-a-binary-tree"></div></div>
</details><hr /><br />

</details>
</div>

