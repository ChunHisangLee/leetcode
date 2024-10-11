
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    public List<String> findStrobogrammatic(int n) {
        Deque<String> dq = new ArrayDeque<>();
        int currLen;
        if (n % 2 == 0) {
            currLen = 0;
            dq.add("");
        } else {
            currLen = 1;
            dq.add("0");
            dq.add("1");
            dq.add("8");
        }
        while (currLen < n) {
            currLen += 2;
            for (int i = dq.size(); i > 0; --i) {
                String number = dq.poll();
                for (char[] pair : pairs) {
                    if (currLen != n || pair[0] != '0') {
                        dq.add(pair[0] + number + pair[1]);
                    }
                }
            }
        }
        List<String> list = new ArrayList<>();
        while (!dq.isEmpty()) {
            list.add(dq.poll());
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
