
//leetcode submit region begin(Prohibit modification and deletion)
class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();

        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        freq2.put(oldVal, freq2.get(oldVal) - 1);

        if (freq2.get(oldVal) == 0) {
            freq2.remove(oldVal);
        }

        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
        nums2[index] = newVal;
    }

    public int count(int tot) {
        int count = 0;

        for (int num1 : nums1) {
            int target = tot - num1;
            count += freq2.getOrDefault(target, 0);
        }

        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
//leetcode submit region end(Prohibit modification and deletion)
