136
        Single Number
        2022-12-15 13:47:11

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumOfSet = 0;
        int sum = 0;
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
                sumOfSet += num;
            }
            sum += num;
        }
        return sumOfSet * 2 - sum;
    }
}
 */