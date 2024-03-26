//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = getCount(s);
        appendString(order, count, sb);
        appendString(alphabetString(), count, sb);
        return sb.toString();
    }

    private int[] getCount(String s) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        return count;
    }

    private void appendString(String s, int[] count, StringBuilder sb) {
        for (char c : s.toCharArray()) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }
    }

    private String alphabetString() {
        return "abcdefghijklmnopqrstuvwxyz";
    }
}
//leetcode submit region end(Prohibit modification and deletion)