//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;

        for (int freq : map.values()) {
            if (maxFreq < freq) {
                maxFreq = freq;
            }
        }

        int count = 0;

        for (int num : map.values()) {
            if (maxFreq == num) {
                count += num;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
