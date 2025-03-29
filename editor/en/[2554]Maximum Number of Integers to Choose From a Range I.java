
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> bannedSet = new HashSet<>();

        for (int num : banned) {
            if (num >= 1 && num <= n) {
                bannedSet.add(num);
            }
        }

        int count = 0;
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }

            if (sum + i > maxSum) {
                break;
            }

            sum += i;
            count++;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
