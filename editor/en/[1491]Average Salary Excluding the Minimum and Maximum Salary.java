
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        double avg = 0;
        for (int item : salary) {
            sum += item;
            if (item > max)
                max = item;
            if (item < min)
                min = item;
        }
        avg = (double) (sum - max - min) / (salary.length - 2);
        return avg;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
