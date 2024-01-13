
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSteps(String s, String t) {
        int[] countS = getCount(s);
        int[] countT = getCount(t);
        int count = 0;

        for (int i = 0; i < countS.length; i++) {
            if (countT[i] < countS[i]) {
                count += countS[i] - countT[i];
            }
        }

        return count;
    }

    private int[] getCount(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
