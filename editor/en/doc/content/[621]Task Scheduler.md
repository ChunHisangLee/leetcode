<p>You are given an array of CPU <code>tasks</code>, each represented by letters&nbsp;A&nbsp;to Z, and a cooling time, <code>n</code>. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: <strong>identical</strong> tasks must be separated by at least <code>n</code> intervals due to cooling time.</p>

<p>​Return the <em>minimum number of intervals</em> required to complete all tasks.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p>

<div class="example-block" style="
    border-color: var(--border-tertiary);
    border-left-width: 2px;
    color: var(--text-secondary);
    font-size: .875rem;
    margin-bottom: 1rem;
    margin-top: 1rem;
    overflow: visible;
    padding-left: 1rem;
"> 
 <p><strong>Input:</strong> <span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">tasks = ["A","A","A","B","B","B"], n = 2</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io" style="
font-family: Menlo,sans-serif;
font-size: 0.85rem;
">8</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; idle -&gt; A -&gt; B -&gt; idle -&gt; A -&gt; B.</p>

<p>After completing task A, you must wait two cycles before doing A again. The same applies to task B. In the 3<sup>rd</sup> interval, neither A nor B can be done, so you idle. By the 4<sup>th</sup> cycle, you can do A again as 2 intervals have passed.</p>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block" style="
    border-color: var(--border-tertiary);
    border-left-width: 2px;
    color: var(--text-secondary);
    font-size: .875rem;
    margin-bottom: 1rem;
    margin-top: 1rem;
    overflow: visible;
    padding-left: 1rem;
"> 
 <p><strong>Input:</strong> <span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">tasks = ["A","C","A","B","D","B"], n = 1</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">6</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; C -&gt; D -&gt; A -&gt; B.</p>

<p>With a cooling interval of 1, you can repeat a task after just one other task.</p>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block" style="
    border-color: var(--border-tertiary);
    border-left-width: 2px;
    color: var(--text-secondary);
    font-size: .875rem;
    margin-bottom: 1rem;
    margin-top: 1rem;
    overflow: visible;
    padding-left: 1rem;
"> 
 <p><strong>Input:</strong> <span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">tasks = ["A","A","A", "B","B","B"], n = 3</span></p> 
</div>

<p><strong>Output:</strong> <span class="example-io" style="
    font-family: Menlo,sans-serif;
    font-size: 0.85rem;
">10</span></p>

<p><strong>Explanation:</strong> A possible sequence is: A -&gt; B -&gt; idle -&gt; idle -&gt; A -&gt; B -&gt; idle -&gt; idle -&gt; A -&gt; B.</p>

<p>There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.</p>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= tasks.length &lt;= 10<sup>4</sup></code></li> 
 <li><code>tasks[i]</code> is an uppercase English letter.</li> 
 <li><code>0 &lt;= n &lt;= 100</code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Array | Hash Table | Greedy | Sorting | Heap (Priority Queue) | Counting</details><br>

<div>👍 9424, 👎 1959<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://labuladong.online/algo/ds-class/) 和 [递归算法专题课](https://labuladong.online/algo/tree-class/) 限时附赠网站会员；算法可视化编辑器上线，[点击体验](https://labuladong.online/algo-visualize/)！**

</div>

