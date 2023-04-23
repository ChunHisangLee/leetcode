438
        Find All Anagrams in a String
        2023-02-04 10:02:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arrS = new int[26];
        int[] arrP = new int[26];
        int m = s.length();
        int n = p.length();
        List<Integer> list = new ArrayList<>();
        char[] chS = s.toCharArray();
        char[] chP = p.toCharArray();
        if (m < n) {
            return list;
        }
        for (int i = 0; i < n; i++) {
            arrS[chS[i] - 'a']++;
            arrP[chP[i] - 'a']++;
        }
        for (int i = 0; i <= m - n; i++) {
            boolean isAnagram = true;
            for (int j = 0; j < 26; j++) {
                if (arrS[j] != arrP[j]) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) {
                list.add(i);
            }
            if (i + n >= m) {
                break;
            }
            arrS[chS[i] - 'a']--;
            arrS[chS[i + n] - 'a']++;
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
