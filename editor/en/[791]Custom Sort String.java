class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a'] > 0) {
                sb.append(c);
                count[c - 'a']--;
            }
        }

        return sb.toString();
    }
}