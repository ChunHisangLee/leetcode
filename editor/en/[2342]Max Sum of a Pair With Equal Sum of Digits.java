2342
        Max Sum of a Pair With Equal Sum of Digits
        2022-11-28 14:16:35

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (map.containsKey(digitSum))
                ans = Math.max(ans, num + map.get(digitSum));
            map.put(digitSum, Math.max(map.getOrDefault(digitSum, 0), num));
        }
        return ans;
    }

    private int getDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
