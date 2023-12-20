1342
        Number of Steps to Reduce a Number to Zero
        2022-12-05 18:17:53

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0)
                num /= 2;
            else
                num -= 1;
            count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
