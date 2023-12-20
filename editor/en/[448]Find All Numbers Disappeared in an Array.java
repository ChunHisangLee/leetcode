
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int[] arr = new int[n + 1];

        for (int num : nums) {
            arr[num]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }
}
 */
