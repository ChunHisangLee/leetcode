
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSpecialInteger(int[] arr) {
        int bar = arr.length / 4;
        int count = 1;
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == result) {
                count++;

                if (count > bar) {
                    return result;
                }
            } else {
                count = 1;
                result = arr[i];
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
