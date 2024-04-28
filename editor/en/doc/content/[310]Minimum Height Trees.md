<p>A tree is an undirected graph in which any two vertices are connected by&nbsp;<i>exactly</i>&nbsp;one path. In other words, any connected graph without simple cycles is a tree.</p>

<p>Given a tree of <code>n</code> nodes&nbsp;labelled from <code>0</code> to <code>n - 1</code>, and an array of&nbsp;<code>n - 1</code>&nbsp;<code>edges</code> where <code>edges[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> indicates that there is an undirected edge between the two nodes&nbsp;<code>a<sub>i</sub></code> and&nbsp;<code>b<sub>i</sub></code> in the tree,&nbsp;you can choose any node of the tree as the root. When you select a node <code>x</code> as the root, the result tree has height <code>h</code>. Among all possible rooted trees, those with minimum height (i.e. <code>min(h)</code>)&nbsp; are called <strong>minimum height trees</strong> (MHTs).</p>

<p>Return <em>a list of all <strong>MHTs'</strong> root labels</em>.&nbsp;You can return the answer in <strong>any order</strong>.</p>

<p>The <strong>height</strong> of a rooted tree is the number of edges on the longest downward path between the root and a leaf.</p>

<p>&nbsp;</p> 
<p><strong class="example">Example 1:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/e1.jpg" style="width: 800px; height: 213px;" /> 
<pre>
<strong>Input:</strong> n = 4, edges = [[1,0],[1,2],[1,3]]
<strong>Output:</strong> [1]
<strong>Explanation:</strong> As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
</pre>

<p><strong class="example">Example 2:</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/01/e2.jpg" style="width: 800px; height: 321px;" /> 
<pre>
<strong>Input:</strong> n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
<strong>Output:</strong> [3,4]
</pre>

<p>&nbsp;</p> 
<p><strong>Constraints:</strong></p>

<ul> 
 <li><code>1 &lt;= n &lt;= 2 * 10<sup>4</sup></code></li> 
 <li><code>edges.length == n - 1</code></li> 
 <li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt; n</code></li> 
 <li><code>a<sub>i</sub> != b<sub>i</sub></code></li> 
 <li>All the pairs <code>(a<sub>i</sub>, b<sub>i</sub>)</code> are distinct.</li> 
 <li>The given input is <strong>guaranteed</strong> to be a tree and there will be <strong>no repeated</strong> edges.</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>Depth-First Search | Breadth-First Search | Graph | Topological Sort</details><br>

<div>👍 7482, 👎 330<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：算法可视化编辑器上线，[点击体验](https://labuladong.online/algo/intro/visualize/)！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

我认为这道题非常有意思，关于图的题目，我已经写了如下的算法：

1、[图论算法基础](https://labuladong.online/algo/fname.html?fname=图)

2、[二分图判定算法](https://labuladong.online/algo/fname.html?fname=二分图)

3、[环检测和拓扑排序算法](https://labuladong.online/algo/fname.html?fname=拓扑排序)

4、[Dijkstra 最短路径算法](https://labuladong.online/algo/fname.html?fname=dijkstra算法)

5、[Union Find 并查集算法](https://labuladong.online/algo/fname.html?fname=UnionFind算法详解)

6、[Kruskal 最小生成树算法](https://labuladong.online/algo/fname.html?fname=kruskal)

这道题肯定要用到 [图论算法基础](https://labuladong.online/algo/fname.html?fname=图) 中讲的图的编程表示（邻接表/邻接矩阵），感觉和 [拓扑排序算法](https://labuladong.online/algo/fname.html?fname=拓扑排序) 和 [Kruskal 最小生成树算法](https://labuladong.online/algo/fname.html?fname=kruskal) 又有点关系。

实际上这道题用标准的 [BFS 算法框架](https://labuladong.online/algo/fname.html?fname=BFS框架) 就可以解决，只是需要一些改变。我直接说解题思路，很容易理解：

1、首先，我们按照 [图论算法基础](https://labuladong.online/algo/fname.html?fname=图) 中所讲的，把题目输入的 `edges` 转换成邻接表。

2、然后，我们从叶子节点开始，一层一层地删除叶子节点（每删除一层叶子节点，就会产生新的叶子节点），直到剩下的节点数小于等于 2 个为止。之所以是 2 个而不是 1 个，是因为如果输入的这幅图两边完全对称，可能出现两个节点都可以作为根节点的情况。

![](https://labuladong.github.io/pictures/短题解/310.jpg)

3、最后剩下的这些节点，就是我们要找的最小高度树的根节点。

如何一层一层删除所有叶子节点呢？只要用 [BFS 算法](https://labuladong.online/algo/fname.html?fname=BFS框架)，借助一个队列就可以了，具体实现看代码吧。

肯定有读者会问，这种题怎么能想出来呢？实际上这种题可以理解为类似冒泡排序这种套路题，找最近叶子节点就从根开始 BFS，找根节点的话就从叶子开始 BFS，你记住这种处理方式就好了，一般不会有什么变体。

**标签：[BFS 算法](https://labuladong.online/algo/)，[图论算法](https://labuladong.online/algo/)**

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
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        // 1、构建邻接表
        vector<vector<int>> graph(n);
        for (auto& edge : edges) {
            // 无向图，等同于双向图
            graph[edge[0]].push_back(edge[1]);
            graph[edge[1]].push_back(edge[0]);
        }

        // 2、找到所有的叶子节点
        vector<int> leaves;
        for (int i = 0; i < n; i++) {
            if (graph[i].size() == 1) {
                leaves.push_back(i);
            }
        }

        // 3、不断删除叶子节点，直到剩下的节点数小于等于 2 个
        int remainNodeNum = n;
        while (remainNodeNum > 2) {
            // 删除当前叶子节点，计算新的叶子节点
            remainNodeNum -= leaves.size();
            vector<int> newLeaves;
            for (auto leaf : leaves) {
                // 将被删除的叶子节点的邻接节点的度减 1
                int neighbor = graph[leaf][0];
                graph[neighbor].erase(find(graph[neighbor].begin(), graph[neighbor].end(), leaf));
                // 如果邻接节点的度为 1，说明它也变成了叶子节点
                if (graph[neighbor].size() == 1) {
                    newLeaves.push_back(neighbor);
                }
            }
            leaves = newLeaves;
        }

        // 最后剩下的节点就是根节点
        return leaves;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        # 1、构建邻接表
        graph = [[] for _ in range(n)]
        for edge in edges:
            # 无向图，等同于双向图
            graph[edge[0]].append(edge[1])
            graph[edge[1]].append(edge[0])

        # 2、找到所有的叶子节点
        leaves = []
        for i in range(n):
            if len(graph[i]) == 1:
                leaves.append(i)

        # 3、不断删除叶子节点，直到剩下的节点数小于等于 2 个
        remainNodeNum = n
        while remainNodeNum > 2:
            # 删除当前叶子节点，计算新的叶子节点
            remainNodeNum -= len(leaves)
            newLeaves = []
            for leaf in leaves:
                # 将被删除的叶子节点的邻接节点的度减 1
                neighbor = graph[leaf][0]
                graph[neighbor].remove(leaf)
                # 如果邻接节点的度为 1，说明它也变成了叶子节点
                if len(graph[neighbor]) == 1:
                    newLeaves.append(neighbor)
            
            leaves = newLeaves

        # 最后剩下的节点就是根节点
        return leaves
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // 1、构建邻接表
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            // 无向图，等同于双向图
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 2、找到所有的叶子节点
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        // 3、不断删除叶子节点，直到剩下的节点数小于等于 2 个
        int remainNodeNum = n;
        while (remainNodeNum > 2) {
            // 删除当前叶子节点，计算新的叶子节点
            remainNodeNum -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                // 将被删除的叶子节点的邻接节点的度减 1
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove(leaf);
                // 如果邻接节点的度为 1，说明它也变成了叶子节点
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
        }

        // 最后剩下的节点就是根节点
        return leaves;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

func findMinHeightTrees(n int, edges [][]int) []int {
    // 1、构建邻接表
    graph := make([][]int, n)
    for i := 0; i < n; i++ {
        graph[i] = []int{}
    }
    for _, edge := range edges {
        // 无向图，等同于双向图
        graph[edge[0]] = append(graph[edge[0]], edge[1])
        graph[edge[1]] = append(graph[edge[1]], edge[0])
    }

    // 2、找到所有的叶子节点
    leaves := []int{}
    for i := 0; i < n; i++ {
        if len(graph[i]) == 1 {
            leaves = append(leaves, i)
        }
    }

    // 3、不断删除叶子节点，直到剩下的节点数小于等于 2 个
    remainNodeNum := n
    for remainNodeNum > 2 {
        // 删除当前叶子节点，计算新的叶子节点
        remainNodeNum -= len(leaves)
        newLeaves := []int{}
        for _, leaf := range leaves {
            // 将被删除的叶子节点的邻接节点的度减 1
            neighbor := graph[leaf][0]
            graph[neighbor] = removeElement(graph[neighbor], leaf)
            // 如果邻接节点的度为 1，说明它也变成了叶子节点
            if len(graph[neighbor]) == 1 {
                newLeaves = append(newLeaves, neighbor)
            }
        }
        leaves = newLeaves
    }

    // 最后剩下的节点就是根节点
    return leaves
}

// 删除切片中的元素
func removeElement(slice []int, elem int) []int {
    index := -1
    for i, v := range slice {
        if v == elem {
            index = i
            break
        }
    }
    if index == -1 {
        return slice
    }
    return append(slice[:index], slice[index+1:]...)
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

var findMinHeightTrees = function(n, edges) {
    // 1、构建邻接表
    let graph = new Array(n);
    for(let i = 0; i < n; i++) {
        graph[i] = [];
    }
    for(let edge of edges) {
        // 无向图，等同于双向图
        graph[edge[0]].push(edge[1]);
        graph[edge[1]].push(edge[0]);
    }

    // 2、找到所有的叶子节点
    let leaves = [];
    for(let i = 0; i < n; i++) {
        if(graph[i].length === 1) {
            leaves.push(i);
        }
    }

    // 3、不断删除叶子节点，直到剩下的节点数小于等于 2 个
    let remainNodeNum = n;
    while(remainNodeNum > 2) {
        // 删除当前叶子节点，计算新的叶子节点
        remainNodeNum -= leaves.length;
        let newLeaves = [];
        for(let leaf of leaves) {
            // 将被删除的叶子节点的邻接节点的度减 1
            let neighbor = graph[leaf][0];
            graph[neighbor].splice(graph[neighbor].indexOf(leaf), 1);
            // 如果邻接节点的度为 1，说明它也变成了叶子节点
            if(graph[neighbor].length === 1) {
                newLeaves.push(neighbor);
            }
        }
        leaves = newLeaves;
    }

    // 最后剩下的节点就是根节点
    return leaves;
};
```

</div></div>
</div></div>

</details>
</div>

