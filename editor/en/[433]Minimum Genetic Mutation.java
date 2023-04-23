// 433
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = Integer.MAX_VALUE;

    public int minMutation(String start, String end, String[] bank) {
        dfs(new HashSet<String>(), 0, start, end, bank);
        return (count == Integer.MAX_VALUE) ? -1 : count;
    }

    private void dfs(HashSet<String> step, int stepCount, String current, String end, String[] bank) {
        if (current.equals(end))
            count = Math.min(stepCount, count);
        for (String str : bank) {
            int diff = 0;
            for (int i = 0; i < str.length(); i++) {
                if (current.charAt(i) != str.charAt(i)) {
                    if (++diff > 1)
                        break;
                }
            }
            if (diff == 1 && !step.contains(str)) {
                step.add(str);
                dfs(step, stepCount + 1, str, end, bank);
                step.remove(str);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
