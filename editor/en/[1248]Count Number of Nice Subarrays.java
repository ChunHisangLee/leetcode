//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int result = 0;

        for (int num : nums) {
            if (num % 2 != 0) {
                count++;
            }

            if (map.containsKey(count - k)) {
                result += map.get(count - k);
            }

            map.put(count, map.getOrDefault(count, 0) + 1);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return getCount(nums, k) - getCount(nums, k - 1);
    }

    private int getCount(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        int count = 0;

        for (int left = 0, right = 0; right < n; right++) {
            count += nums[right] % 2;

            while (count > k) {
                count -= nums[left] % 2;
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}
 */