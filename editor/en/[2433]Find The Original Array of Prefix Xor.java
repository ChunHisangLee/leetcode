
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];

        arr[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
