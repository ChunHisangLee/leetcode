<p>An <strong>ugly number</strong> is a positive integer that is divisible by <code>a</code>, <code>b</code>, or <code>c</code>.</p>

<p>Given four integers <code>n</code>, <code>a</code>, <code>b</code>, and <code>c</code>, return the <code>n<sup>th</sup></code> <strong>ugly number</strong>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 3, a = 2, b = 3, c = 5
<strong>Output:</strong> 4
<strong>Explanation:</strong> The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3<sup>rd</sup> is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 4, a = 2, b = 3, c = 4
<strong>Output:</strong> 6
<strong>Explanation:</strong> The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4<sup>th</sup> is 6.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 5, a = 2, b = 11, c = 13
<strong>Output:</strong> 10
<strong>Explanation:</strong> The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5<sup>th</sup> is 10.
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n, a, b, c &lt;= 10<sup>9</sup></code></li> 
 <li><code>1 &lt;= a * b * c &lt;= 10<sup>18</sup></code></li> 
 <li>It is guaranteed that the result will be in range <code>[1, 2 * 10<sup>9</sup>]</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Math | Binary Search | Number Theory</details><br>

<div>👍 939, 👎 444<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://mp.weixin.qq.com/s/NF8mmVyXVfC1ehdMOsO7Cw' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.0；第 13 期刷题打卡 [开始报名](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q)。**



<p><strong><a href="https://labuladong.github.io/article?qno=1201" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [264. 丑数 II](/problems/ugly-number-ii) 有些类似，你把第 264 题合并有序链表的解法照搬过来稍微改改就能解决这道题，代码我写在 `Solution2` 里面了。

但是注意题目给的数据规模，`a, b, c, n` 都是非常大的数字，如果用合并有序链表的思路，其复杂度是 O(N)，对于这么大的数据规模来说也是比较慢的，应该会超时，无法通过一些测试用例。

这道题的正确解法难度比较大，难点在于你要把一些数学知识和 [二分搜索技巧](https://labuladong.github.io/article/fname.html?fname=二分查找详解) 结合起来才能高效解决这个问题。

首先，根据 [二分查找的实际运用](https://labuladong.github.io/article/fname.html?fname=二分运用) 中讲到的二分搜索运用方法，我们可以抽象出一个单调递增的函数 `f`：

`f(num, a, b, c)` 计算 `[1..num]` 中，能够整除 `a` 或 `b` 或 `c` 的数字的个数，显然函数 `f` 的返回值是随着 `num` 的增加而增加的（单调递增）。

**题目让我们求第 `n` 个能够整除 `a` 或 `b` 或 `c` 的数字是什么，也就是说我们要找到一个 `num`，使得 `f(num, a, b, c) == n`**。

有了上述思路，就可以按照 [二分查找的实际运用](https://labuladong.github.io/article/fname.html?fname=二分运用) 中给出的模板运用二分搜索算法了。

关键说一下函数 `f` 怎么实现，这里面涉及集合论定理以及最小公因数、最小公倍数的计算方法。

首先，`[1..num]` 中，我把能够整除 `a` 的数字归为集合 `A`，能够整除 `b` 的数字归为集合 `B`，能够整除 `c` 的数字归为集合 `C`，那么 `len(A) = num / a, len(B) = num / b, len(C) = num / c`，这个很好理解。

但是 `f(num, a, b, c)` 的值肯定不是 `num / a + num / b + num / c` 这么简单，因为你注意有些数字可能可以被 `a, b, c` 中的两个数或三个数同时整除，如下图：

![](https://labuladong.github.io/algo/images/丑数/1.jpg)

**按照集合论的算法，这个集合中的元素应该是：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C**。结合上图应该很好理解。

问题来了，`A, B, C` 三个集合的元素个数我们已经算出来了，但如何计算像 `A ∩ B` 这种交集的元素个数呢？

其实也很容易想明白，`A ∩ B` 的元素个数就是 `n / lcm(a, b)`，其中 `lcm` 是计算最小公倍数（Least Common Multiple）的函数。

类似的，`A ∩ B ∩ C` 的元素个数就是 `n / lcm(lcm(a, b), c)` 的值。

现在的问题是，最小公倍数怎么求？

直接记住定理吧：`lcm(a, b) = a * b / gcd(a, b)`，其中 `gcd` 是计算最大公因数（Greatest Common Divisor）的函数。

现在的问题是，最大公因数怎么求？

这应该是经典算法了，我们一般叫辗转相除算法（或者欧几里得算法）。

好了，套娃终于套完了，我们可以把上述思路翻译成解法，注意本题数据规模比较大，有时候需要用 `long` 类型防止 `int` 溢出，具体看我的代码实现以及注释吧。

**详细题解：[丑数系列算法详解](https://labuladong.github.io/article/fname.html?fname=丑数)**

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)，[链表双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120596033251475465)**

## 解法代码

```java
// 二分搜索 + 数学解法
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // 题目说本题结果在 [1, 2 * 10^9] 范围内，
        // 所以就按照这个范围初始化两端都闭的搜索区间
        int left = 1, right = (int) 2e9;
        // 搜索左侧边界的二分搜索
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (f(mid, a, b, c) < n) {
                // [1..mid] 中的元素个数不足 n，所以目标在右侧
                left = mid + 1;
            } else {
                // [1..mid] 中的元素个数大于 n，所以目标在左侧
                right = mid - 1;
            }
        }
        return left;
    }

    // 计算 [1..num] 之间有多少个能够被 a 或 b 或 c 整除的数字
    long f(int num, int a, int b, int c) {
        long setA = num / a, setB = num / b, setC = num / c;
        long setAB = num / lcm(a, b);
        long setAC = num / lcm(a, c);
        long setBC = num / lcm(b, c);
        long setABC = num / lcm(lcm(a, b), c);
        // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
        return setA + setB + setC - setAB - setAC - setBC + setABC;/**<extend up -400>

![](https://labuladong.github.io/algo/images/丑数/1.jpg)
*/
    }

    // 计算最大公因数（辗转相除/欧几里得算法）
    long gcd(long a, long b) {
        if (a < b) {
            // 保证 a > b
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 最小公倍数
    long lcm(long a, long b) {
        // 最小公倍数就是乘积除以最大公因数
        return a * b / gcd(a, b);
    }
}

// 用合并单链表的思路（超时）
class Solution2 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // 可以理解为三个有序链表的头结点的值
        long productA = a, productB = b, productC = c;
        // 可以理解为合并之后的有序链表上的指针
        int p = 1;

        long min = -666;

        // 开始合并三个有序链表，获取第 n 个节点的值
        while (p <= n) {
            // 取三个链表的最小结点
            min = Math.min(Math.min(productA, productB), productC);
            p++;
            // 前进最小结点对应链表的指针
            if (min == productA) {
                productA += a;
            }
            if (min == productB) {
                productB += b;
            }
            if (min == productC) {
                productC += c;
            }
        }
        return (int) min;
    }
}
```

**类似题目**：
  - [263. 丑数 🟢](/problems/ugly-number)
  - [264. 丑数 II 🟠](/problems/ugly-number-ii)
  - [313. 超级丑数 🟠](/problems/super-ugly-number)

</details>
</div>



