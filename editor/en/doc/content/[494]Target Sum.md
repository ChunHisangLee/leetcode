<p>You are given an integer array <code>nums</code> and an integer <code>target</code>.</p>

<p>You want to build an <strong>expression</strong> out of nums by adding one of the symbols <code>'+'</code> and <code>'-'</code> before each integer in nums and then concatenate all the integers.</p>

<ul> 
 <li>For example, if <code>nums = [2, 1]</code>, you can add a <code>'+'</code> before <code>2</code> and a <code>'-'</code> before <code>1</code> and concatenate them to build the expression <code>"+2-1"</code>.</li> 
</ul>

<p>Return the number of different <strong>expressions</strong> that you can build, which evaluates to <code>target</code>.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,1,1], target = 3
<strong>Output:</strong> 5
<strong>Explanation:</strong> There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1], target = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 20</code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 1000</code></li> 
 <li><code>0 &lt;= sum(nums[i]) &lt;= 1000</code></li> 
 <li><code>-1000 &lt;= target &lt;= 1000</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Dynamic Programming | Backtracking</details><br>

<div>👍 10666, 👎 354<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**



<p><strong><a href="https://labuladong.online/algo/slug.html?slug=target-sum" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 207 页。

这题有多种解法，可以用回溯算法剪枝求解，也可以用转化成背包问题求解，这里用前者吧，容易理解一些，背包问题解法可以查看详细题解。

对于每一个 1，要么加正号，要么加负号，把所有情况穷举出来，即可计算结果。

**详细题解：[目标和问题：背包问题的变体](https://labuladong.github.io/article/fname.html?fname=targetSum)**

**标签：[二维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122017695998050308)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，[回溯算法](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122002916411604996)，[背包问题](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122018870755491844)**

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
    int findTargetSumWays(vector<int>& nums, int target) {
        if (nums.empty()) return 0;
        return dp(nums, 0, target);
    }

    // 备忘录
    unordered_map<string, int> memo;

    int dp(vector<int>& nums, int i, int remain) {
        // base case
        if (i == nums.size()) {
            if (remain == 0) return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        string key = to_string(i) + "," + to_string(remain);
        // 避免重复计算
        if (memo.count(key)) {
            return memo[key];
        }
        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo[key] = result;
        return result;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        if len(nums) == 0: return 0
        # 调用备忘录函数
        return self.dp(nums, 0, target, {})

    def dp(self, nums, i, remain, memo): 
        # base case
        if i == len(nums):
            if remain == 0: return 1
            return 0
        # 把它俩转成字符串才能作为哈希表的键
        key = str(i) + "," + str(remain)
        # 避免重复计算
        if key in memo:
            return memo[key]
        # 还是穷举
        result = self.dp(nums, i + 1, remain - nums[i], memo) + self.dp(nums, i + 1, remain + nums[i], memo)
        # 记入备忘录
        memo[key] = result
        return result
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
    }

    // 备忘录
    HashMap<String, Integer> memo = new HashMap<>();

    int dp(int[] nums, int i, int remain) {
        // base case
        if (i == nums.length) {
            if (remain == 0) return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + remain;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);
        // 记入备忘录
        memo.put(key, result);
        return result;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func findTargetSumWays(nums []int, target int) int {
    // 如果nums为空，则直接返回0
    if len(nums) == 0 {
        return 0
    }
    // 定义备忘录
    memo := make(map[string]int)
    // 调用DP函数
    return dp(nums, 0, target, memo)
}

func dp(nums []int, i, remain int, memo map[string]int) int {
    // base case
    if i == len(nums) {
        if remain == 0 {
            return 1
        }
        return 0
    }
    // 把它俩转成字符串才能作为哈希表的键
    key := strconv.Itoa(i) + "," + strconv.Itoa(remain)
    // 避免重复计算
    if val, ok := memo[key]; ok {
        return val
    }
    // 还是穷举
    result := dp(nums, i+1, remain-nums[i], memo) + dp(nums, i+1, remain+nums[i], memo)
    // 记入备忘录
    memo[key] = result
    return result
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

// 传入一个整数数组和目标值target，求有多少种方法使得数组中的元素之和为target，每个元素可以选择加或者减
var findTargetSumWays = function (nums, target) {
  // 数组长度为0直接返回0
  if (nums.length === 0) return 0;

  // 备忘录哈希表，记录已经计算过的子问题的结果，避免重复计算
  const memo = new Map();

  // 递归函数
  const dp = (nums, i, remain) => {
    // 如果已经遍历到了数组的末尾，判断remain是否等于0，如果等于0则返回1，否则返回0
    if (i === nums.length) {
      if (remain === 0) return 1;
      return 0;
    }

    // 用i和remain作为键，判断是否已经计算过这个子问题，如果已经计算，则直接返回结果，否则继续计算
    const key = i + "," + remain;

    if (memo.has(key)) {
      return memo.get(key);
    }

    // 分别递归计算加上和减去当前元素后能够得到目标值的方案数量，相加得到当前子问题的解
    const result =
      dp(nums, i + 1, remain - nums[i]) + dp(nums, i + 1, remain + nums[i]);

    // 把计算结果存入备忘录
    memo.set(key, result);

    // 返回当前子问题的解
    return result;
  };

  // 从0开始遍历数组，计算从每个索引开始的子问题，最终得到问题的解
  return dp(nums, 0, target);
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_target-sum" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_target-sum"></div></div>
</details><hr /><br />

**类似题目**：
  - [剑指 Offer II 102. 加减的目标值 🟠](/problems/YaVDxD)

</details>
</div>

