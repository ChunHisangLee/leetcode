127
        Word Ladder
        2023-02-01 22:38:21

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Deque<String> dq = new ArrayDeque<>();
        dq.add(beginWord);
        Set<String> isVisited = new HashSet<>();
        isVisited.add(beginWord);
        int count = 1;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                String word = dq.poll();
                if (word.equals(endWord)) {
                    return count;
                }
                for (int j = 0; j < word.length(); j++) {
                    char[] c = word.toCharArray();
                    for (char k = 'a'; k <= 'z'; k++) {
                        c[j] = k;
                        String str = new String(c);
                        if (set.contains(str) && !isVisited.contains(str)) {
                            dq.add(str);
                            isVisited.add(str);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
