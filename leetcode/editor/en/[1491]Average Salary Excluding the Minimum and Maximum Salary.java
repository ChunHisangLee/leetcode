1491
        Average Salary Excluding the Minimum and Maximum Salary
        2023-02-26 15:22:20

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double average(int[] salary) {
        int sum = Arrays.stream(salary).sum();
        int max = Arrays.stream(salary).max().getAsInt();
        int min = Arrays.stream(salary).min().getAsInt();
        return (double) (sum - max - min) / (salary.length - 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
