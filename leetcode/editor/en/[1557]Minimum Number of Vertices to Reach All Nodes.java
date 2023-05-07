
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int len = edges.size();
        int[] arr = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            arr[edges.get(i).get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
