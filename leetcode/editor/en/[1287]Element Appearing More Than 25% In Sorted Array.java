
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSpecialInteger(int[] arr) {
        int bar = arr.length / 4;
        int result = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == result) {
                count++;
            } else {
                result = arr[i];
                count = 1;
            }

            if (count > bar) {
                return arr[i];
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
