//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<String>> dp = new HashMap<>();
        int n = s.length();

        for (int i = n - 1; i >= 0; i--) {
            List<String> list = new ArrayList<>();

            for (int j = i + 1; j <= n; j++) {
                String word = s.substring(i, j);

                if (wordDict.contains(word)) {
                    addResult(word, list, dp.get(j));
                }
            }

            dp.put(i, list);
        }

        return dp.get(0);
    }

    private void addResult(String word, List<String> list, List<String> prevList) {
        if (prevList == null) {
            list.add(word);
        } else {
            for (String str : prevList) {
                list.add(new StringBuilder(word).append(" ").append(str).toString());
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
