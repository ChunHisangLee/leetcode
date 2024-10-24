
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxUniqueSplit(String s) {
        Set<String> used = new HashSet<>();
        int[] maxCount = {0};
        backtrack(s, 0, used, 0, maxCount);
        return maxCount[0];
    }

    private void backtrack(String s, int start, Set<String> used, int count, int[] maxCount) {
        if (start == s.length()) {
            maxCount[0] = Math.max(maxCount[0], count);
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);

            if (!used.contains(substring)) {
                used.add(substring);
                backtrack(s, end, used, count + 1, maxCount);
                used.remove(substring);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
