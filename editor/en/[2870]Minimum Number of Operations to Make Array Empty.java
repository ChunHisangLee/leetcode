
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0;

        while (left < nums.length) {
            int right = left;

            while (right < nums.length && nums[left] == nums[right]) {
                right++;
            }

            int num = right - left;

            if (num == 1) {
                return -1;
            }

            count += (int) Math.ceil(num / 3.0);
            left = right;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.values()) {
            if (num == 1) {
                return -1;
            }

            count += (int) Math.ceil(num / 3.0);
        }

        return count;
    }
}
 */