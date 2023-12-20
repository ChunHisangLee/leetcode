//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int test = minutesToTest / minutesToDie;
        int count = 0;

        while (Math.pow(test + 1, count) < buckets) {
            count++;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
