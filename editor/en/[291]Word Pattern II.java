
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        return backtrack(pattern, 0, s, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean backtrack(String pattern, int pIndex, String s, int sIndex, Map<Character, String> map, Set<String> set) {
        if (pIndex == pattern.length() && sIndex == s.length()) {
            return true;
        }

        if (pIndex == pattern.length() || sIndex == s.length()) {
            return false;
        }

        char c = pattern.charAt(pIndex);

        if (map.containsKey(c)) {
            String mappedStr = map.get(c);

            if (!s.startsWith(mappedStr, sIndex)) {
                return false;
            }

            return backtrack(pattern, pIndex + 1, s, sIndex + mappedStr.length(), map, set);
        }

        for (int i = sIndex; i < s.length(); i++) {
            String candidate = s.substring(sIndex, i + 1);

            if (set.contains(candidate)) {
                continue;
            }

            map.put(c, candidate);
            set.add(candidate);

            if (backtrack(pattern, pIndex + 1, s, sIndex + candidate.length(), map, set)) {
                return true;
            }

            map.remove(c);
            set.remove(candidate);
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
