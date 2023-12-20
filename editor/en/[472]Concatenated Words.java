472
        Concatenated Words
        2023-01-27 09:27:09

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (form(word, set)) {
                list.add(word);
            }
        }
        return list;
    }

    boolean form(String word, Set<String> set) {
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (set.contains(left)) {
                if (set.contains(right) || form(right, set)) {
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
