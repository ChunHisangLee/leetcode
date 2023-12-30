
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isSubsequence(s, p, removable, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left - 1;
    }

    private boolean isSubsequence(String s, String p, int[] removable, int k) {
        boolean[] removed = new boolean[s.length()];

        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j < p.length() && !removed[i] && s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }

        return j == p.length();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
