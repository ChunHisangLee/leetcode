//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximum69Number(int num) {
        if (num / 1000 == 6)
            num = num - 6000 + 9000;
        else if ((num / 100) % 10 == 6)
            num = num - 600 + 900;
        else if ((num / 10) % 10 == 6)
            num = num - 60 + 90;
        else if (num % 10 == 6)
            num = num - 6 + 9;
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
