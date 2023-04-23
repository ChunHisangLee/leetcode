1010
        Pairs of Songs With Total Durations Divisible by 60
        2023-03-05 22:39:07

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int count = 0;
        for (int item : time) {
            int num = item % 60;
            if (num == 0) {
                count += arr[0];
            } else {
                count += arr[60 - num];
            }
            arr[num]++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
