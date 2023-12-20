1200
        Minimum Absolute Difference
        2022-12-17 10:01:04

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int currDiff = arr[i + 1] - arr[i];
            if (currDiff == minDiff) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (currDiff < minDiff) {
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
                minDiff = currDiff;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
