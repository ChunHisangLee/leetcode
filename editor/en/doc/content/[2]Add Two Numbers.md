<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" /> 
<pre>
<strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,0,8]
<strong>Explanation:</strong> 342 + 465 = 807.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>Output:</strong> [8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li> 
 <li><code>0 &lt;= Node.val &lt;= 9</code></li> 
 <li>It is guaranteed that the list represents a number that does not have leading zeros.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Linked List | Math | Recursion</details><br>

<div>👍 30202, 👎 5946<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://labuladong.online/algo/ds-class/) 和 [递归算法专题课](https://labuladong.online/algo/tree-class/) 限时附赠网站会员；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo-visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

逆序存储很友好了，直接遍历链表就是从个位开始的，符合我们计算加法的习惯顺序。如果是正序存储，那倒要费点脑筋了，可能需要 [翻转链表](https://labuladong.github.io/article/fname.html?fname=递归反转链表的一部分) 或者使用栈来辅助。

这道题主要考察 [链表双指针技巧](https://labuladong.github.io/article/fname.html?fname=链表技巧) 和加法运算过程中对进位的处理。注意这个 `carry` 变量的处理，在我们手动模拟加法过程的时候会经常用到。

**代码中还用到一个链表的算法题中是很常见的「虚拟头结点」技巧，也就是 `dummy` 节点**。你可以试试，如果不使用 `dummy` 虚拟节点，代码会稍显复杂，而有了 `dummy` 节点这个占位符，可以避免处理初始的空指针情况，降低代码的复杂性。

**标签：[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        // 在两条链表上的指针
        ListNode *p1 = l1, *p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode *dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode *p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != nullptr || p2 != nullptr || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != nullptr) {
                val += p1->val;
                p1 = p1->next;
            }
            if (p2 != nullptr) {
                val += p2->val;
                p2 = p2->next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p->next = new ListNode(val);
            p = p->next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy->next;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        # 在两条链表上的指针
        p1, p2 = l1, l2
        # 虚拟头结点（构建新链表时的常用技巧）
        dummy = ListNode(-1)
        # 指针 p 负责构建新链表
        p = dummy
        # 记录进位
        carry = 0
        # 开始执行加法，两条链表走完且没有进位时才能结束循环
        while p1 or p2 or carry:
            # 先加上上次的进位
            val = carry
            if p1:
                val += p1.val
                p1 = p1.next
            if p2:
                val += p2.val
                p2 = p2.next
            # 处理进位情况
            carry, val = divmod(val, 10)
            # 构建新节点
            p.next = ListNode(val)
            p = p.next
        # 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    // 在两条链表上的指针
    p1, p2 := l1, l2
    // 虚拟头结点（构建新链表时的常用技巧）
    dummy := &ListNode{-1, nil}
    // 指针 p 负责构建新链表
    p := dummy
    // 记录进位
    carry := 0
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    for p1 != nil || p2 != nil || carry > 0 {
        // 先加上上次的进位
        val := carry
        if p1 != nil {
            val += p1.Val
            p1 = p1.Next
        }
        if p2 != nil {
            val += p2.Val
            p2 = p2.Next
        }
        // 处理进位情况
        carry = val / 10
        val = val % 10
        // 构建新节点
        p.Next = &ListNode{val, nil}
        p = p.Next
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.Next
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var addTwoNumbers = function(l1, l2) {
    // 在两条链表上的指针
    let p1 = l1, p2 = l2;
    // 虚拟头结点（构建新链表时的常用技巧）
    let dummy = new ListNode(-1);
    // 指针 p 负责构建新链表
    let p = dummy;
    // 记录进位
    let carry = 0;
    // 开始执行加法，两条链表走完且没有进位时才能结束循环
    while (p1 !== null || p2 !== null || carry > 0) {
        // 先加上上次的进位
        let val = carry;
        if (p1 !== null) {
            val += p1.val;
            p1 = p1.next;
        }
        if (p2 !== null) {
            val += p2.val;
            p2 = p2.next;
        }
        // 处理进位情况
        carry = Math.floor(val / 10);
        val = val % 10;
        // 构建新节点
        p.next = new ListNode(val);
        p = p.next;
    }
    // 返回结果链表的头结点（去除虚拟头结点）
    return dummy.next;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_add-two-numbers" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_add-two-numbers"></div></div>
</details><hr /><br />

**类似题目**：
  - [445. 两数相加 II 🟠](/problems/add-two-numbers-ii)
  - [67. 二进制求和 🟢](/problems/add-binary)
  - [剑指 Offer II 025. 链表中的两数相加 🟠](/problems/lMSNwu)

</details>
</div>

