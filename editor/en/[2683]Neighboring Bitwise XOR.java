
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        if (isValid(derived, 0)) {
            return true;
        }
        return isValid(derived, 1);
    }

    private boolean isValid(int[] derived, int firstValue) {
        int n = derived.length;
        int[] original = new int[n];
        original[0] = firstValue;

        for (int i = 0; i < n - 1; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }

        int expectedFirst = derived[n - 1] ^ original[n - 1];
        return expectedFirst == original[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
