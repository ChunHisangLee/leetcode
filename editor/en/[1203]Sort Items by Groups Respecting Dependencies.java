/*
還不會
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> groupGraph = new ArrayList<>();
        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        int[] indegreeItem = new int[n];
        int[] indegreeGroup = new int[m];
        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int beforeItem : beforeItems.get(i)) {
                itemGraph.get(beforeItem).add(i);
                indegreeItem[i]++;
                if (group[i] != group[beforeItem]) {
                    indegreeGroup[group[i]]++;
                    groupGraph.get(group[beforeItem]).add(group[i]);
                }
            }
        }
        int[] sortedGroups = topologicalSort(m, groupGraph, indegreeGroup);
        int[] sortedItems = topologicalSort(n, itemGraph, indegreeItem);
        if (sortedGroups.length == 0 || sortedItems.length == 0) {
            return new int[0];
        }
        List<Integer>[] tmp = new List[m];
        for (int i = 0; i < m; i++) {
            tmp[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            tmp[group[sortedItems[i]]].add(sortedItems[i]);
        }
        int[] result = new int[n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j : tmp[sortedGroups[i]]) {
                result[count++] = j;
            }
        }
        return result;
    }

    private int[] topologicalSort(int n, List<List<Integer>> graph, int[] indegree) {
        boolean[] visited = new boolean[n];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            sortedArray[count++] = node;
            for (int nei : graph.get(node)) {
                if (--indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return count == n ? sortedArray : new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
