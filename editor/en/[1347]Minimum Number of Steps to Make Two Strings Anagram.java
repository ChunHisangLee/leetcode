
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSteps(String s, String t) {
        int[] countS = getCount(new int[26], s);
        int[] countT = getCount(new int[26], t);
        int count = 0;

        for (int i = 0; i < countS.length; i++) {
            if (countT[i] < countS[i]) {
                count += countS[i] - countT[i];
            }
        }

        return count;
    }

    private int[] getCount(int[] arr, String s) {
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
