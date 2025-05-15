
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = words.length;

        if (n == 0 || m == 0) {
            return res;
        }

        int len = words[0].length();
        int window = len * m;

        if (n < window) {
            return res;
        }

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> currentMap = new HashMap<>();

            for (int j = i; j <= n - len; j += len) {
                String word = s.substring(j, j + len);

                if (wordCountMap.containsKey(word)) {
                    currentMap.put(word, currentMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentMap.get(word) > wordCountMap.get(word)) {
                        String leftWord = s.substring(left, left + len);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += len;
                    }

                    if (count == m) {
                        res.add(left);
                        String leftWord = s.substring(left, left + len);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += len;
                    }
                } else {
                    currentMap.clear();
                    count = 0;
                    left = j + len;
                }
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
