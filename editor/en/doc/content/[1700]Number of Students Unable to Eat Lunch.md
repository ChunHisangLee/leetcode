<p>The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers <code>0</code> and <code>1</code> respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.</p>

<p>The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a <strong>stack</strong>. At each step:</p>

<ul> 
 <li>If the student at the front of the queue <strong>prefers</strong> the sandwich on the top of the stack, they will <strong>take it</strong> and leave the queue.</li> 
 <li>Otherwise, they will <strong>leave it</strong> and go to the queue's end.</li> 
</ul>

<p>This continues until none of the queue students want to take the top sandwich and are thus unable to eat.</p>

<p>You are given two integer arrays <code>students</code> and <code>sandwiches</code> where <code>sandwiches[i]</code> is the type of the <code>i<sup>​​​​​​th</sup></code> sandwich in the stack (<code>i = 0</code> is the top of the stack) and <code>students[j]</code> is the preference of the <code>j<sup>​​​​​​th</sup></code> student in the initial queue (<code>j = 0</code> is the front of the queue). Return <em>the number of students that are unable to eat.</em></p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> students = [1,1,0,0], sandwiches = [0,1,0,1]
<strong>Output:</strong> 0<strong> 
Explanation:</strong>
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= students.length, sandwiches.length &lt;= 100</code></li> 
 <li><code>students.length == sandwiches.length</code></li> 
 <li><code>sandwiches[i]</code> is <code>0</code> or <code>1</code>.</li> 
 <li><code>students[i]</code> is <code>0</code> or <code>1</code>.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Stack | Queue | Simulation</details><br>

<div>👍 1662, 👎 133<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

因为学生队伍可以循环，所以理论上栈顶的那个三明治可以被所有（剩下还没吃饭的）学生挑选。

所以，当剩下的学生都不想要最上面的三明治的时候，就进入死循环，他们都吃不上饭了。即以下情况：

1、剩下的所有学生都想吃 `1`，但栈顶是 `0`。

2、剩下的所有学生都想吃 `0`，但栈顶是 `1`。

所以我们先统计所有学生对 `0` 和 `1` 的需求，然后顺序遍历三明治栈的顺序，即可得知以上两种可能是否会发生。

**标签：[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，模拟**

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
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        //studentCount [0 or 1] 分别代表吃 0 和吃 1的学生数量
        vector<int> studentCount(2, 0);
        for (int type : students) {
            studentCount[type]++;
        }
        //遍历三明治栈，若栈顶的三明治无法被取走，则剩下的人都吃不上了
        for (int type : sandwiches) {
            if (studentCount[type] == 0) {
                //两种喜好加起来就是剩下的学生数量
                return studentCount[0] + studentCount[1];
            }
            studentCount[type]--;
        }
        return 0;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        # studentCount[0 or 1] 分别代表吃 0 和吃 1的学生数量
        studentCount = [0,0]
        for type in students:
            studentCount[type] += 1
        # 遍历三明治栈，若栈顶的三明治无法被取走，则剩下的人都吃不上了
        for type in sandwiches:
            if studentCount[type] == 0:
                # 两种喜好加起来就是剩下的学生数量
                return studentCount[0] + studentCount[1]
            studentCount[type] -= 1
        return 0
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // studentCount[0 or 1] 分别代表吃 0 和吃 1的学生数量
        int[] studentCount = new int[2];
        for (int type : students) {
            studentCount[type]++;
        }
        // 遍历三明治栈，若栈顶的三明治无法被取走，则剩下的人都吃不上了
        for (int type : sandwiches) {
            if (studentCount[type] == 0) {
                // 两种喜好加起来就是剩下的学生数量
                return studentCount[0] + studentCount[1];
            }
            studentCount[type]--;
        }
        return 0;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func countStudents(students []int, sandwiches []int) int {
    // studentCount[0 or 1] 分别代表吃 0 和吃 1的学生数量
    studentCount := [2]int{0, 0}
    for _, type_ := range students {
        studentCount[type_]++
    }
    // 遍历三明治栈，若栈顶的三明治无法被取走，则剩下的人都吃不上了
    for _, type_ := range sandwiches {
        if studentCount[type_] == 0 {
            // 两种喜好加起来就是剩下的学生数量
            return studentCount[0] + studentCount[1]
        }
        studentCount[type_]--
    }
    return 0
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var countStudents = function(students, sandwiches) {
    // studentCount[0 or 1] 分别代表吃 0 和吃 1的学生数量
    var studentCount = new Array(2).fill(0);
    for (var type of students) {
        studentCount[type]++;
    }
    // 遍历三明治栈，若栈顶的三明治无法被取走，则剩下的人都吃不上了
    for (var type of sandwiches) {
        if (studentCount[type] == 0) {
            // 两种喜好加起来就是剩下的学生数量
            return studentCount[0] + studentCount[1];
        }
        studentCount[type]--;
    }
    return 0;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌈🌈 算法可视化 🌈🌈</strong></summary><div id="data_number-of-students-unable-to-eat-lunch" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_number-of-students-unable-to-eat-lunch"></div></div>
</details><hr /><br />

</details>
</div>

