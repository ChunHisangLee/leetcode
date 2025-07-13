
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] required = new int[26];

        for (String word : words2) {
            int[] freq = getFrequency(word);
            for (int i = 0; i < 26; i++) {
                if (freq[i] > required[i]) {
                    required[i] = freq[i];
                }
            }
        }

        List<String> universalWords = new ArrayList<>();

        for (String word : words1) {
            int[] freq = getFrequency(word);
            if (isUniversal(freq, required)) {
                universalWords.add(word);
            }
        }

        return universalWords;
    }

    private int[] getFrequency(String word) {
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        return freq;
    }

    private boolean isUniversal(int[] wordFreq, int[] requiredFreq) {
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] < requiredFreq[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
