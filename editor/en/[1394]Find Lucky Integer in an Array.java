
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                max = Math.max(max,entry.getKey());
            }
        }

        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
