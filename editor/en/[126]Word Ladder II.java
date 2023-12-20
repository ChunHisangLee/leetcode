126
        Word Ladder II
        2023-02-01 22:38:23
/*
還不會
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> res;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Deque<String> dq = new ArrayDeque<>();
        dq.add(beginWord);
        Map<String, List<String>> map = new HashMap<>();
        boolean find = false;
        while (!dq.isEmpty()) {
            int size = dq.size();
            HashSet<String> set = new HashSet<>();
            while (size-- > 0) {
                String curr = dq.poll();
                if (curr.equals(endWord)) {
                    find = true;
                    continue;
                }
                List<String> nexts = convert(curr, dict);
                for (String next : nexts) {
                    if (set.add(next)) {
                        map.putIfAbsent(next, new ArrayList<>());
                        dq.add(next);
                    }
                    map.get(next).add(curr);
                }
            }
            dict.removeAll(set);
            if (find) {
                List<String> path = new ArrayList<>();
                path.add(endWord);
                dfs(map, path, endWord, beginWord);
                break;
            }
        }
        return res;

    }

    private void dfs(Map<String, List<String>> map, List<String> path, String curr, String end) {
        if (curr.equals(end)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse((temp));
            res.add(temp);
            return;
        }
        for (String next : map.get(curr)) {
            path.add(next);
            dfs(map, path, next, end);
            path.remove(path.size() - 1);
        }
    }

    private List<String> convert(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String str = String.valueOf(chars);
                if (c != temp && dict.contains(str)) {
                    res.add(str);
                }
            }
            chars[i] = temp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
