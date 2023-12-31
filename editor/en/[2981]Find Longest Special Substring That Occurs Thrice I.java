
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumLength(String s) {
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = i;

            while (j < s.length() && s.charAt(j) == c) {
                j++;
            }

            String str = s.substring(i, j);
            int count = getCount(s, str);

            if (count >= 3) {
                max = Math.max(max, j - i);
            }
        }

        return max;
    }

    private int getCount(String str, String sub) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index++;
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
