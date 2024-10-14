
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int previousTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int functionId = Integer.parseInt(parts[0]);
            String type = parts[1];
            int timestamp = Integer.parseInt(parts[2]);

            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += timestamp - previousTime;
                }

                stack.push(functionId);
                previousTime = timestamp;
            } else {
                result[stack.pop()] += timestamp - previousTime + 1;
                previousTime = timestamp + 1;
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
