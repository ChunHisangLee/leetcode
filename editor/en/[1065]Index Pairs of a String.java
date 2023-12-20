
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String word : words) {
            int index = text.indexOf(word);
            while (index != -1) {
                list.add(new int[]{index, index + word.length() - 1});
                index = text.indexOf(word, index + 1);
            }
        }
        Collections.sort(list, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return list.toArray(new int[list.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
