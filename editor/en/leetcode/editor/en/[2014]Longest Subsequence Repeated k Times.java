
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        List<Character> allowedChars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= k) {
                allowedChars.add((char) (i + 'a'));
            }
        }
        if (allowedChars.isEmpty()) {
            return "";
        }
        allowedChars.sort((a, b) -> b - a);

        List<String> currentLevel = new ArrayList<>();
        currentLevel.add("");
        String best = "";

        while (true) {
            List<String> nextLevel = new ArrayList<>();
            for (String seq : currentLevel) {
                for (char c : allowedChars) {
                    String cand = seq + c;
                    if (canRepeatK(s, cand, k)) {
                        nextLevel.add(cand);
                    }
                }
            }
            if (nextLevel.isEmpty()) {
                break;
            }
            best = nextLevel.get(0);
            currentLevel = nextLevel;
        }

        return best;
    }

    private boolean canRepeatK(String s, String seq, int k) {
        int n = s.length(), m = seq.length();
        int si = 0;
        for (int rep = 0; rep < k; rep++) {
            for (int j = 0; j < m; j++) {
                char target = seq.charAt(j);
                while (si < n && s.charAt(si) != target) {
                    si++;
                }
                if (si == n) {
                    return false;
                }
                si++;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
