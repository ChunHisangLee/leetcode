
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int result = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 0) {
                int curr = map.getOrDefault(num, 0) + 1;
                map.put(num, curr);

                if (curr > max || (curr == max && num < result)) {
                    max = curr;
                    result = num;
                }
            }
        }

        return max > 0 ? result : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
