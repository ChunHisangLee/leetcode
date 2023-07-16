
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int m = people.size();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int curr = 0;
            for (String str : people.get(i)) {
                curr |= 1 << map.get(str);
            }
            for (int prev = 0; prev < dp.length; prev++) {
                if (dp[prev] == null) {
                    continue;
                }
                int comb = prev | curr;
                if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
