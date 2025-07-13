
//leetcode submit region begin(Prohibit modification and deletion)

public class Solution {
    public int possibleStringCount(String word) {
        int count = 1;
        int n = word.length();

        for (int i = 0; i < n; ) {
            char c = word.charAt(i);
            int j = i + 1;

            while (j < n && word.charAt(j) == c) {
                j++;
            }

            int len = j - i;

            if (len > 1) {
                count += len - 1;
            }

            i = j;
        }

        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
