
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isSymmetric(int num) {
        String str = Integer.toString(num);
        int n = str.length();
        if (n % 2 != 0) {
            return false;
        }
        int mid = n / 2;
        int firstHalfSum = 0;
        int secondHalfSum = 0;
        for (int i = 0; i < mid; i++) {
            firstHalfSum += str.charAt(i) - '0';
            secondHalfSum += str.charAt(n - 1 - i) - '0';
        }
        return firstHalfSum == secondHalfSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
