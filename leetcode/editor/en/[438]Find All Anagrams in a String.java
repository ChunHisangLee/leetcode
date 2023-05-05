438
        Find All Anagrams in a String
        2023-02-04 10:02:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();
        int m = cs.length;
        int n = cp.length;
        int[] arrs = new int[26];
        int[] arrp = new int[26];
        List<Integer> list = new ArrayList<>();
        if (m < n) {
            return list;
        }
        for (int i = 0; i < n; i++) {
            arrs[cs[i] - 'a']++;
            arrp[cp[i] - 'a']++;
        }
        for (int i = 0; i <= m - n; i++) {
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (arrs[j] != arrp[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
            if (i + n < m) {
                arrs[cs[i] - 'a']--;
                arrs[cs[i + n] - 'a']++;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
