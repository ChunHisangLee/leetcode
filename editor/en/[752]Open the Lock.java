752
        Open the Lock
        2022-12-08 10:45:49

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for (String dead : deadends) {
            set.add(dead);
        }
        if (set.contains("0000")) {
            return -1;
        }
        Deque<String> dq = new ArrayDeque<>();
        dq.add("0000");
        int count = -1;
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                String curr = dq.poll();
                if (curr.equals(target)) {
                    return count;
                }
                char[] c = curr.toCharArray();
                for (int j = 0; j < c.length; j++) {
                    char temp = c[j];
                    c[j] = temp == '0' ? '9' : (char) (temp - 1);
                    String str = String.valueOf(c);
                    if (!set.contains(str)) {
                        set.add(str);
                        dq.add(str);
                    }
                    c[j] = temp == '9' ? '0' : (char) (temp + 1);
                    str = String.valueOf(c);
                    if (!set.contains(str)) {
                        set.add(str);
                        dq.add(str);
                    }
                    c[j] = temp;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
