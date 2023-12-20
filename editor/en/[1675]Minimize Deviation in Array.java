1675
        Minimize Deviation in Array
        2023-02-24 09:32:00

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                set.add(num * 2);
            } else {
                set.add(num);
            }
        }
        int minDiff = set.last() - set.first();
        while (set.last() % 2 == 0) {
            set.add(set.last() / 2);
            set.remove(set.last());
            minDiff = Math.min(minDiff, set.last() - set.first());
        }
        return minDiff;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
