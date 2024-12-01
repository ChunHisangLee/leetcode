
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int x : arr) {
            if (seen.contains(2 * x)) {
                return true;
            }

            if (x % 2 == 0 && seen.contains(x / 2)) {
                return true;
            }

            seen.add(x);
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
