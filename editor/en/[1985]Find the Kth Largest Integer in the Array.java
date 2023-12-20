1985
        Find the Kth Largest Integer in the Array
        2022-12-27 15:09:48

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> a.length() == b.length() ? b.compareTo(a) : b.length() - a.length());
        return nums[k - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
