//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            Character mappedToT = map1.get(sc);
            Character mappedToS = map2.get(tc);

            if (mappedToT == null) {
                map1.put(sc, tc);
            } else if (!mappedToT.equals(tc)) {
                return false;
            }

            if (mappedToS == null) {
                map2.put(tc, sc);
            } else if (!mappedToS.equals(sc)) {
                return false;
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
