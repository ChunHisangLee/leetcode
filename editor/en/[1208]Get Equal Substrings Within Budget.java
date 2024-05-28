
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int start = 0;
        int maxLength = 0;
        int currCost = 0;

        for (int end = 0; end < s.length(); end++) {
            currCost += Math.abs(s.charAt(end) - t.charAt(end));

            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
