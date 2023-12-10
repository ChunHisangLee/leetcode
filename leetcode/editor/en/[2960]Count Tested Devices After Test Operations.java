
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;

        for (int num : batteryPercentages) {
            count += num > count ? 1 : 0;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
