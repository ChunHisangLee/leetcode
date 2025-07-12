
//leetcode submit region begin(Prohibit modification and deletion)
class WordDistance {
    Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            String key = wordsDict[i];

            if (map.containsKey(key)) {
                map.get(key).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(key, list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);

            if (index1 < index2) {
                min = Math.min(min, index2 - index1);
                i++;
            } else {
                min = Math.min(min, index1 - index2);
                j++;
            }
        }

        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
//leetcode submit region end(Prohibit modification and deletion)
