
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            dp.put(num, dp.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, dp.get(num));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
- 5ms
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] dp = new int[max - min + 1];
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i] - min;
            int prev = curr - difference;
            if (prev >= 0 && prev < dp.length) {
                dp[curr] = dp[prev] + 1;
            } else {
                dp[curr] = 1;
            }
            res = Math.max(res, dp[curr]);
        }
        return res;
    }
}

- 52ms
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int res = 0;
        for (int num : arr) {
            dp.put(num, dp.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, dp.get(num));
        }
        return res;
    }
}
 */
