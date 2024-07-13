
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder remainingString = new StringBuilder();
        int result = 0;

        if (x > y) {
            result += processString(s, 'a', 'b', x, remainingString);
            result += processString(remainingString.toString(), 'b', 'a', y, new StringBuilder());
        } else {
            result += processString(s, 'b', 'a', y, remainingString);
            result += processString(remainingString.toString(), 'a', 'b', x, new StringBuilder());
        }

        return result;
    }

    private int processString(String s, char first, char second, int points, StringBuilder remainingString) {
        int score = 0;
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first && c == second) {
                stack.pop();
                score += points;
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            remainingString.append(stack.pollLast());
        }

        return score;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
