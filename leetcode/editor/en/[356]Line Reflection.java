
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[1])) {
                map.put(point[1], new HashSet<>());
            }
            map.get(point[1]).add(point[0]);
        }
        Integer sum = null;
        for (Set<Integer> set : map.values()) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            int left = 0;
            int right = list.size() - 1;
            while (left <= right) {
                int curr = list.get(left++) + list.get(right--);
                if (sum == null) {
                    sum = curr;
                } else {
                    if (curr != sum) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
