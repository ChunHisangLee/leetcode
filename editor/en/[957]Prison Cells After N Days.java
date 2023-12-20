
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> map = new HashMap<>();
        while (n > 0) {
            int[] cells2 = new int[8];
            map.put(Arrays.toString(cells), n);
            n--;
            for (int i = 1; i < 7; i++) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            if (map.containsKey(Arrays.toString(cells))) {
                n %= map.get(Arrays.toString(cells)) - n;
            }
        }
        return cells;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
