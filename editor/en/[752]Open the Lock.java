//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));

        if (set.contains("0000")) {
            return -1;
        }

        Deque<String> deque = new ArrayDeque<>();
        deque.add("0000");
        set.add("0000");
        int count = 0;

        while (!deque.isEmpty()) {
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                String curr = deque.poll();

                if (curr.equals(target)) {
                    return count;
                }

                List<String> nextStates = getNextStates(curr);

                for (String state : nextStates) {
                    if (!set.contains(state)) {
                        set.add(state);
                        deque.add(state);
                    }
                }
            }

            count++;
        }

        return -1;
    }

    private List<String> getNextStates(String curr) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = curr.toCharArray();

        for (int i = 0; i < 4; i++) {
            char currChar = chars[i];
            chars[i] = currChar == '9' ? '0' : (char) (currChar + 1);
            nextStates.add(new String(chars));
            chars[i] = currChar == '0' ? '9' : (char) (currChar - 1);
            nextStates.add(new String(chars));
            chars[i] = currChar;
        }

        return nextStates;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
