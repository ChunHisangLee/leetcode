1491
        Average Salary Excluding the Minimum and Maximum Salary
        2023-02-26 15:22:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : salary) {
            sum += num;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return (double) (sum - max - min) / (n - 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
