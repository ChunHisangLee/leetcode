
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                sb.append(currentState.substring(0, i))
                        .append("--")
                        .append(currentState.substring(i + 2));
                list.add(sb.toString());
                sb.setLength(0);
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
