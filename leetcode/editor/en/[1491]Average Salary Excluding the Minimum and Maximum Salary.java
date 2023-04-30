1491
        Average Salary Excluding the Minimum and Maximum Salary
        2023-02-26 15:22:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : salary) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }
        double res = (double) (sum - min - max) / (n - 2);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
