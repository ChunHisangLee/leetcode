
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    map.computeIfAbsent(i, k -> new ArrayList<Integer>()).add(j);
                    map.computeIfAbsent(j, k -> new ArrayList<Integer>()).add(i);
                }
            }
        }

        boolean[] isVisited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                dfs(i, map, isVisited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int node, Map<Integer, List<Integer>> map, boolean[] isVisited) {
        isVisited[node] = true;
        if (!map.containsKey(node)) {
            return;
        }
        for (int neighbor : map.get(node)) {
            if (!isVisited[neighbor]) {
                isVisited[neighbor] = true;
                dfs(neighbor, map, isVisited);
            }
        }
    }

    public boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
