
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftDiff = new int[n + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                shiftDiff[start]++;
                shiftDiff[end + 1]--;
            } else {
                shiftDiff[start]--;
                shiftDiff[end + 1]++;
            }
        }

        int[] cumulativeShifts = new int[n];
        int shift = 0;
        for (int i = 0; i < n; i++) {
            shift += shiftDiff[i];
            cumulativeShifts[i] = shift;
        }

        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            int newChar = ((s.charAt(i) - 'a') + cumulativeShifts[i]) % 26;
            if (newChar < 0) {
                newChar += 26;
            }
            result[i] = (char) ('a' + newChar);
        }

        return new String(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
