
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        int qLen = queries.length;
        int[] ans = new int[qLen];

        for (int i = 0; i < qLen; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = prefix[ri + 1] - prefix[li];
        }

        return ans;
    }

    private boolean isVowelString(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }

        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
//leetcode submit region end(Prohibit modification and deletion)
