
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            int currLength = 1;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String newWord = sb.toString();
                currLength = Math.max(currLength, dp.getOrDefault(newWord, 0) + 1);
            }

            dp.put(word, currLength);
            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    Map<String, Integer> memo;
    Set<String> wordSet;

    public int longestStrChain(String[] words) {
        memo = new HashMap<>();
        wordSet = new HashSet<>();
        int result = 0;

        Collections.addAll(wordSet, words);

        for (String word : words) {
            result = Math.max(result, dfs(word));
        }

        return result;
    }

    private int dfs(String word) {
        if (memo.containsKey(word)) {
            return memo.get(word);
        }

        int maxLength = 1;
        StringBuilder sb = new StringBuilder(word);

        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();

            if (wordSet.contains(newWord)) {
                int currLength = 1 + dfs(newWord);
                maxLength = Math.max(maxLength, currLength);
            }

            sb.insert(i, word.charAt(i));
        }

        memo.put(word, maxLength);
        return maxLength;
    }
}

class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 1;

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            int currLength = 1;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(i);
                String newWord = sb.toString();
                int prevLength = dp.getOrDefault(newWord, 0);
                currLength = Math.max(currLength, prevLength + 1);
            }

            dp.put(word, currLength);
            maxLength = Math.max(maxLength, currLength);
        }

        return maxLength;
    }
}
 */