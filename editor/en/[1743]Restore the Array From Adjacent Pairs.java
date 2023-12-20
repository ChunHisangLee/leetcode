
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int root = 0;

        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];

            if (!map.containsKey(x)) {
                map.put(x, new ArrayList<>());
            }

            if (!map.containsKey(y)) {
                map.put(y, new ArrayList<>());
            }

            map.get(x).add(y);
            map.get(y).add(x);
        }

        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                root = key;
                break;
            }
        }

        int curr = root;
        int[] result = new int[map.size()];
        result[0] = root;
        int prev = Integer.MAX_VALUE;

        for (int i = 1; i < map.size(); i++) {
            for (int neighbor : map.get(curr)) {
                if (neighbor != prev) {
                    result[i] = neighbor;
                    prev = curr;
                    curr = neighbor;
                    break;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
