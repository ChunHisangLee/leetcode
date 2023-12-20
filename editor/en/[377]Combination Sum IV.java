377
        Combination Sum IV
        2023-02-23 15:28:24

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, Integer> map;

    public int combinationSum4(int[] nums, int target) {
        map = new HashMap<>();
        return dyP(nums, target);
    }

    private int dyP(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += dyP(nums, target - num);
            }
        }
        map.put(target, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
- 1ms
class Solution {
    Map<Integer, Integer> map;

    public int combinationSum4(int[] nums, int target) {
        map = new HashMap<>();
        return dyP(nums, target);
    }

    private int dyP(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int num : nums) {
            if (target >= num) {
                res += dyP(nums, target - num);
            }
        }
        map.put(target, res);
        return res;
    }
}

- 1ms
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
 */