<p>There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array <code>points</code> where <code>points[i] = [x<sub>start</sub>, x<sub>end</sub>]</code> denotes a balloon whose <strong>horizontal diameter</strong> stretches between <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code>. You do not know the exact y-coordinates of the balloons.</p>

<p>Arrows can be shot up <strong>directly vertically</strong> (in the positive y-direction) from different points along the x-axis. A balloon with <code>x<sub>start</sub></code> and <code>x<sub>end</sub></code> is <strong>burst</strong> by an arrow shot at <code>x</code> if <code>x<sub>start</sub> &lt;= x &lt;= x<sub>end</sub></code>. There is <strong>no limit</strong> to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.</p>

<p>Given the array <code>points</code>, return <em>the <strong>minimum</strong> number of arrows that must be shot to burst all balloons</em>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> points = [[10,16],[2,8],[1,6],[7,12]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> points = [[1,2],[3,4],[5,6],[7,8]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> One arrow needs to be shot for each balloon for a total of 4 arrows.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> points = [[1,2],[2,3],[3,4],[4,5]]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= points.length &lt;= 10<sup>5</sup></code></li> 
 <li><code>points[i].length == 2</code></li> 
 <li><code>-2<sup>31</sup> &lt;= x<sub>start</sub> &lt; x<sub>end</sub> &lt;= 2<sup>31</sup> - 1</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Greedy | Sorting</details><br>

<div>👍 6772, 👎 204<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://labuladong.online/algo/ds-class/) 和 [递归算法专题课](https://labuladong.online/algo/tree-class/) 限时附赠网站会员；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo-visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=minimum-number-of-arrows-to-burst-balloons" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 381 页。

区间调度问题是让你计算若干区间中最多有几个互不相交的区间，这道题是区间调度问题的一个简单变体，需要的箭头数量就是不重叠区间的数量。

![](https://labuladong.github.io/pictures/interval/3.jpg)

区间调度问题思路可以分为以下三步：

1、从区间集合 `intvs` 中选择一个区间 `x`，这个 `x` 是在当前所有区间中**结束最早的**（`end` 最小）。

2、把所有与 `x` 区间相交的区间从区间集合 `intvs` 中删除。

3、重复步骤 1 和 2，直到 `intvs` 为空为止。之前选出的那些 `x` 就是最大不相交子集。

**详细题解：[贪心算法之区间调度问题](https://labuladong.github.io/article/fname.html?fname=贪心算法之区间调度问题)**

**标签：[区间问题](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122021012031569922)，排序**

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
    // 区间调度问题
    int findMinArrowShots(vector<vector<int>>& intvs) {
        if (intvs.size() == 0) return 0;
        // 按 end 升序排序
        sort(intvs.begin(), intvs.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (auto& interval : intvs) {
            int start = interval[0];
            // 把 >= 改成 > 就行了
            if (start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

# 区间调度问题
class Solution:
    def findMinArrowShots(self, intvs: List[List[int]]) -> int:
        if not intvs:
            return 0
        # 按 end 升序排序
        intvs.sort(key=lambda x: x[1])
        # 至少有一个区间不相交
        count = 1
        # 排序后，第一个区间就是 x
        x_end = intvs[0][1]
        for interval in intvs:
            start = interval[0]
            # 把 >= 改成 > 就行了
            if start > x_end:
                count += 1
                x_end = interval[1]
        return count
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 区间调度问题
    public int findMinArrowShots(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            // 把 >= 改成 > 就行了
            if (start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

import (
    "fmt"
    "sort"
)

// findMinArrowShots 是区间调度问题的解决方案
func findMinArrowShots(intvs [][]int) int {
    if len(intvs) == 0 {
        return 0
    }
    // 按 end 升序排序
    sort.Slice(intvs, func(i, j int) bool {
        return intvs[i][1] < intvs[j][1]
    })
    // 至少有一个区间不相交
    count := 1
    // 排序后，第一个区间就是 x
    xEnd := intvs[0][1]
    for _, interval := range intvs {
        start := interval[0]
        // 把 >= 改成 > 就行了
        if start > xEnd {
            count++
            xEnd = interval[1]
        }
    }
    return count
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[][]} intvs
 * @return {number}
 */
var findMinArrowShots = function(intvs) {
    if (intvs.length == 0) return 0;
    // 按 end 升序排序
    intvs.sort((a, b) => { return a[1] - b[1]; });
    // 至少有一个区间不相交
    let count = 1;
    // 排序后，第一个区间就是 x
    let xEnd = intvs[0][1];
    for (let interval of intvs) {
        let start = interval[0];
        // 把 >= 改成 > 就行了
        if (start > xEnd) {
            count++;
            xEnd = interval[1];
        }
    }
    return count;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_minimum-number-of-arrows-to-burst-balloons" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-number-of-arrows-to-burst-balloons"></div></div>
</details><hr /><br />

**类似题目**：
  - [435. 无重叠区间 🟠](/problems/non-overlapping-intervals)

</details>
</div>

