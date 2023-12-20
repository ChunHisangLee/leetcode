1231
        Divide Chocolate
        2022-12-13 10:03:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int people = k + 1;
        int left = 0;
        int right = 0;
        for (int num : sweetness) {
            right += num;
        }
        right /= people;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (isCheck(sweetness, mid, people)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    private boolean isCheck(int[] sweetness, int mid, int people) {
        int count = 0;
        int sum = 0;
        for (int num : sweetness) {
            sum += num;
            if (sum >= mid) {
                count++;
                sum = 0;
            }
        }
        return count >= people;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
