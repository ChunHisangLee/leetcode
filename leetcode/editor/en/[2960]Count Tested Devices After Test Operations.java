
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int count = 0;

        for (int num : batteryPercentages) {
            if (num > count) {
                count++;
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
