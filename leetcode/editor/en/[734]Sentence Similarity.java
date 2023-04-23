734
        Sentence Similarity
        2023-02-01 11:26:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> pair : similarPairs) {
            map.computeIfAbsent(pair.get(0), value -> new HashSet<>()).add(pair.get(1));
            map.computeIfAbsent(pair.get(1), value -> new HashSet<>()).add(pair.get(0));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            }
            if (map.containsKey(sentence1[i]) && map.get(sentence1[i]).contains(sentence2[i])) {
                continue;
            }
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
