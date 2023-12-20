205
        Isomorphic Strings
        2023-01-28 12:16:23

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] chS = s.toCharArray();
        char[] chT = t.toCharArray();
        for (int i = 0; i < chS.length; i++) {
            if (!map.containsKey(chS[i])) {
                if (set.contains(chT[i])) {
                    return false;
                }
                map.put(chS[i], chT[i]);
                set.add(chT[i]);
            }
            if (map.get(chS[i]) != chT[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
