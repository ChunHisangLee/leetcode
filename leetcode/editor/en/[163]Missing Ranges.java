163
        Missing Ranges
        2023-01-01 09:58:49

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            if (num > lower) {
                list.add(String.valueOf(lower) + ((num - lower > 1) ? ("->" + String.valueOf(num - 1)) : ""));
            }
            if (num == upper) {
                return list;
            }
            lower = num + 1;
        }

        if (lower <= upper) {
            list.add(String.valueOf(lower) + ((upper - lower > 0) ? ("->" + String.valueOf(upper)) : ""));
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
