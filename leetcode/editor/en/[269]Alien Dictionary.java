269
        Alien Dictionary
        2023-02-16 11:43:41

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alienOrder(String[] words) {
        List<List<Character>> list = new ArrayList<>();
        int[] inDegree = new int[26];
        for (int i = 0; i < 26; i++) {
            list.add(new ArrayList<>());
            inDegree[i] = -1;
        }
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] == -1) {
                    inDegree[c - 'a'] = 0;
                    count++;
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    list.get(word1.charAt(j) - 'a').add(word2.charAt(j));
                    inDegree[word2.charAt(j) - 'a']++;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (inDegree[c - 'a'] == 0) {
                dq.add(c);
            }
        }
        while (!dq.isEmpty()) {
            char c = dq.poll();
            sb.append(c);
            for (char ch : list.get(c - 'a')) {
                inDegree[ch - 'a']--;
                if (inDegree[ch - 'a'] == 0) {
                    dq.add(ch);
                }
            }
        }
        return sb.length() == count ? sb.toString() : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
