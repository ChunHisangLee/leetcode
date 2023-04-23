
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
