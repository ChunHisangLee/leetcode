//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfWays(String s) {
        long count0 = 0;
        long count1 = 0;
        long count01 = 0;
        long count10 = 0;
        long result = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '0') {
                count0++;
                result += count01;
                count10 += count1;
            } else {
                count1++;
                result += count10;
                count01 += count0;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
