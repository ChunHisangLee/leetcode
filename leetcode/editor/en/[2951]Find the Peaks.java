
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                list.add(i);
            }
        }

        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
