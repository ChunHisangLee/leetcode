
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String currentWord = words[i];
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (words[j].contains(currentWord)) {
                    result.add(currentWord);
                    break;
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
