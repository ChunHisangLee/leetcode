269
        Alien Dictionary
        2023-02-16 11:43:41

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alienOrder(String[] words) {
        List<List<Character>> list = new ArrayList<>();
        final int N = 26;
        int[] inDegree = new int[N];
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
            inDegree[i] = -1;
        }
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (inDegree[c - 'a'] == -1) {
                    inDegree[c - 'a'] = 0;
                    count++;
                    break;
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
            int n = Math.min(s1.length(), s2.length());
            for (int j = 0; j < n; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    list.get(s1.charAt(j) - 'a').add(s2.charAt(j));
                    inDegree[s2.charAt(j) - 'a']++;
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
