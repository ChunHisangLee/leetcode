// 1346
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || num % 2 == 0 && set.contains(num / 2))
                return true;
            set.add(num);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
