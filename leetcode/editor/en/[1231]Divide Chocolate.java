1231
Divide Chocolate
2022-12-13 10:03:43
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int people;

    public int maximizeSweetness(int[] sweetness, int k) {
        people = k + 1;
        int left = 0;
        int right = Arrays.stream(sweetness).sum() / people;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(mid, sweetness))
                right = mid - 1;
            else
                left = mid;
        }
        return left;
    }

    private boolean check(int k, int[] sweetness) {
        int curr = 0;
        int count = 0;
        for (int s : sweetness) {
            curr += s;
            if (curr >= k) {
                count++;
                curr = 0;
            }
        }
        return count < people;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
