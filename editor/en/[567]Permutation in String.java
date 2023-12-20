567
        Permutation in String
        2023-02-04 09:39:55

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[] arrS1 = new int[26];
        int[] arrS2 = new int[26];
        char[] chS1 = s1.toCharArray();
        char[] chS2 = s2.toCharArray();
        if (m > n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            arrS1[chS1[i] - 'a']++;
            arrS2[chS2[i] - 'a']++;
        }
        for (int i = 0; i <= n - m; i++) {
            boolean isPer = true;
            for (int j = 0; j < 26; j++) {
                if (arrS1[j] != arrS2[j]) {
                    isPer = false;
                    break;
                }
            }
            if (isPer) {
                return true;
            }
            if (i + m >= n) {
                break;
            }
            arrS2[chS2[i] - 'a']--;
            arrS2[chS2[i + m] - 'a']++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
