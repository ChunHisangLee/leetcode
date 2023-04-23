// 438
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] window = new int[26];
        int[] arrP = new int[26];
        int lenP = p.length();
        int lenS = s.length();
        if (lenS < lenP)
            return new ArrayList<>();

        for (char ch : p.toCharArray()) {
            arrP[ch - 'a']++;
        }
        char[] chForS = s.toCharArray();
        for (int i = 0; i < lenS; i++) {
            window[chForS[i] - 'a']++;
            if (i >= lenP)
                window[chForS[i - lenP] - 'a']--;
            boolean find = true;
            for (int j = 0; j < 26; j++) {
                if (arrP[j] != window[j]) {
                    find = false;
                    break;
                }
            }
            if (find)
                res.add(i - lenP + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
