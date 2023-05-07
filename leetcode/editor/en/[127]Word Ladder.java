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
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        return search(begin, end, set, true, 1);
    }

    private int search(Set<String> begin, Set<String> end, Set<String> set, boolean isForward, int curr) {
        if (begin.isEmpty() || end.isEmpty()) {
            return 0;
        }
        curr++;
        set.removeAll(begin);
        Set<String> next = new HashSet<>();
        for (String str : begin) {
            char[] c = str.toCharArray();
            for (int i = 0; i < c.length; i++) {
                char ch = c[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    c[i] = j;
                    String temp = new String(c);
                    if (!set.contains(temp)) {
                        continue;
                    }
                    if (end.contains(temp)) {
                        return curr;
                    }
                    next.add(temp);
                }
                c[i] = ch;
            }
        }
        return next.size() > end.size() ? search(end, next, set, false, curr) : search(next, end, set, true, curr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
