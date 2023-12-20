1941
        Check if All Characters Have Equal Number of Occurrences
        2022-11-27 16:44:46

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
