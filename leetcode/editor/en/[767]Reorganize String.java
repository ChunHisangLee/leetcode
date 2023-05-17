
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        int max = 0;
        int letter = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                letter = i;
            }
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        int index = 0;
        char[] res = new char[s.length()];
        while (arr[letter] > 0) {
            res[index] = (char) (letter + 'a');
            index += 2;
            arr[letter]--;
        }
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0) {
                if (index >= s.length()) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                arr[i]--;
            }
        }
        return String.valueOf(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
