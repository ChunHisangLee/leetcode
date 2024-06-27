
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> countMap = new TreeMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            int count = countMap.get(key);

            if (count > 0) {
                for (int i = 1; i < k; i++) {
                    int nextKey = key + i;

                    if (countMap.getOrDefault(nextKey, 0) < count) {
                        return false;
                    }

                    countMap.put(nextKey, countMap.get(nextKey) - count);
                }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
