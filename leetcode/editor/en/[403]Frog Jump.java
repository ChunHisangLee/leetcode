403
        Frog Jump
        2022-12-26 11:04:53

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(stones[0]).add(1);
        for (int stone : stones) {
            for (int jump : dp.get(stone)) {
                if (jump > 0 && dp.containsKey(stone + jump)) {
                    dp.get(stone + jump).add(jump - 1);
                    dp.get(stone + jump).add(jump);
                    dp.get(stone + jump).add(jump + 1);
                }
            }
        }
        return dp.get(stones[stones.length - 1]).size() > 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
Top - Down - 10 ms
class Solution {
    Boolean[][] dp;
    int n;

    public boolean canCross(int[] stones) {
        n = stones.length;
        dp = new Boolean[n + 1][n + 1];
        return dyP(stones, 0, 0);
    }

    private boolean dyP(int[] stones, int index, int prev) {
        if (index == n - 1) {
            return true;
        }
        if (dp[index][prev] != null) {
            return dp[index][prev];
        }
        int max = stones[index] + prev + 1;
        for (int next = index + 1; next < n && stones[next] <= max; next++) {
            if (stones[next] == stones[index] + prev - 1) {
                if (dyP(stones, next, prev - 1)) {
                    return true;
                }
            }
            if (stones[next] == stones[index] + prev) {
                if (dyP(stones, next, prev)) {
                    return true;
                }
            }
            if (stones[next] == stones[index] + prev + 1) {
                if (dyP(stones, next, prev + 1)) {
                    return true;
                }
            }
        }
        return dp[index][prev] = false;
    }
}

- 57 ms
class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }
        dp.get(stones[0]).add(1);
        for (int stone : stones) {
            for (int jump : dp.get(stone)) {
                if (jump != 0 && dp.containsKey(stone + jump)) {
                    dp.get(stone + jump).add(jump - 1);
                    dp.get(stone + jump).add(jump);
                    dp.get(stone + jump).add(jump + 1);
                }
            }
        }
        return !dp.get(stones[stones.length - 1]).isEmpty();
    }
}
 */