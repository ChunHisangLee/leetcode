
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int left = nums[i];
            while (i + 1 < n && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (left != nums[i]) {
                sb = sb.append(left).append("->").append(nums[i]);
                list.add(sb.toString());
                sb.setLength(0);
            } else {
                list.add(String.valueOf(left));
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
