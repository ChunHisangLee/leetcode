<p>Given an integer array <code>nums</code> of length <code>n</code> where all the integers of <code>nums</code> are in the range <code>[1, n]</code> and each integer appears <strong>once</strong> or <strong>twice</strong>, return <em>an array of all the integers that appears <strong>twice</strong></em>.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)&nbsp;</code>time and uses only constant extra space.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<pre><strong>Input:</strong> nums = [4,3,2,7,8,2,3,1]
<strong>Output:</strong> [2,3]
</pre>
<p><strong class="example">Example 2:</strong></p> 
<pre><strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong> [1]
</pre>
<p><strong class="example">Example 3:</strong></p> 
<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> []
</pre> 
<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>n == nums.length</code></li> 
 <li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= n</code></li> 
 <li>Each element in <code>nums</code> appears <strong>once</strong> or <strong>twice</strong>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table</details><br>

<div>👍 9594, 👎 347<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://labuladong.online/algo/ds-class/) 和 [递归算法专题课](https://labuladong.online/algo/tree-class/) 限时附赠网站会员；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo-visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题就用常规的解法做吧，用哈希集合很容易找到 `nums` 中那些重复的元素。

不用额外的存储空间的解法我也写了，因为题目说 `nums` 中的元素取值都在 `[1, n]` 之间，即元素本身就和索引成映射关系，所以可以用 `nums` 本身模拟哈希集合的效果，详解你可以看下 [如何寻找缺失和重复的元素](https://labuladong.github.io/article/fname.html?fname=缺失和重复的元素)。

> 注意：用乘 -1 的方式给索引做标记的前提是，`nums` 中的元素都为正数，不能包含 0，否则无法区分该索引是否被标记。

**标签：哈希表，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

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
    vector<int> findDuplicates(vector<int>& nums) {
        int n = nums.size();
        vector<int> res;
        // 用数组模拟哈希集合
        vector<int> seen(n + 1);
        for (int num : nums) {
            if (seen[num] == 0) {
                // 添加到哈希集合
                seen[num] = 1;
            } else {
                // 找到重复元素
                res.push_back(num);
            }
        }
        return res;
    }
};

class Solution2 {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> res;
        for (int num : nums) {
            // 注意索引，元素大小从 1 开始，有一位索引偏移
            if (nums[abs(num) - 1] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                res.push_back(abs(num));
            } else {
                // 把索引 num - 1 置为负数
                nums[abs(num) - 1] *= -1;
            }
        }

        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []
        # 用数组模拟哈希集合
        seen = [0] * (n + 1)
        for num in nums:
            if seen[num] == 0:
                # 添加到哈希集合
                seen[num] = 1
            else:
                # 找到重复元素
                res.append(num)
        return res


class Solution2:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []
        for num in nums:
            # 注意索引，元素大小从 1 开始，有一位索引偏移
            if nums[abs(num) - 1] < 0:
                # 之前已经把对应索引的元素变成负数了，
                # 这说明 num 重复出现了两次
                res.append(abs(num))
            else:
                # 把索引 num - 1 置为负数
                nums[abs(num) - 1] *= -1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new LinkedList<>();
        // 用数组模拟哈希集合
        int[] seen = new int[n + 1];
        for (int num : nums) {
            if (seen[num] == 0) {
                // 添加到哈希集合
                seen[num] = 1;
            } else {
                // 找到重复元素
                res.add(num);
            }
        }
        return res;
    }
}

class Solution2 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int num : nums) {
            // 注意索引，nums 中元素大小从 1 开始，
            // 而索引是从 0 开始的，所以有一位索引偏移
            if (nums[Math.abs(num) - 1] < 0) {
                // 之前已经把对应索引的元素变成负数了，
                // 这说明 num 重复出现了两次
                res.add(Math.abs(num));
            } else {
                // 把索引 num - 1 置为负数
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findDuplicates(nums []int) []int {
    n := len(nums)
    res := make([]int, 0)
    // 用数组模拟哈希集合
    seen := make([]int, n+1)
    for _, num := range nums {
        if seen[num] == 0 {
            // 添加到哈希集合
            seen[num] = 1
        } else {
            // 找到重复元素
            res = append(res, num)
        }
    }
    return res
}

func findDuplicates2(nums []int) []int {
    res := make([]int, 0)
    for _, num := range nums {
        // 注意索引，元素大小从 1 开始，有一位索引偏移
        if nums[abs(num)-1] < 0 {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            res = append(res, abs(num))
        } else {
            // 把索引 num - 1 置为负数
            nums[abs(num)-1] *= -1
        }
    }

    return res
}

func abs(a int) int {
    if a < 0 {
        return -a
    }
    return a
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var findDuplicates = function(nums) {
    const n = nums.length;
    const res = [];
    // 用数组模拟哈希集合
    const seen = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        const num = nums[i];
        if (seen[num] === 0) {
            // 添加到哈希集合
            seen[num] = 1;
        } else {
            // 找到重复元素
            res.push(num);
        }
    }
    return res;
};

var findDuplicates2 = function(nums) {
    const res = [];
    for (let i = 0; i < nums.length; i++) {
        const num = Math.abs(nums[i]);
        // 注意索引，元素大小从 1 开始，有一位索引偏移
        if (nums[num - 1] < 0) {
            // 之前已经把对应索引的元素变成负数了，
            // 这说明 num 重复出现了两次
            res.push(num);
        } else {
            // 把索引 num - 1 置为负数
            nums[num - 1] *= -1;
        }
    }

    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_find-all-duplicates-in-an-array" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-all-duplicates-in-an-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [448. 找到所有数组中消失的数字 🟢](/problems/find-all-numbers-disappeared-in-an-array)
  - [剑指 Offer 03. 数组中重复的数字 🟢](/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof)

</details>
</div>

