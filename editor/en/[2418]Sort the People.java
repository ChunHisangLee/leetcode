
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        return IntStream.range(0, names.length)
                .boxed()
                .sorted((a, b) -> heights[b] - heights[a])
                .map(i -> names[i])
                .toArray(String[]::new);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
