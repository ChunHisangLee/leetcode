926
        Flip String to Monotone Increasing
        2023-01-17 19:29:44

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFlipsMonoIncr(String s) {
        int count0 = 0;
        int count1 = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                count0++;
            } else {
                count1++;
            }
            count0 = Math.min(count0, count1);
        }
        return count0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
