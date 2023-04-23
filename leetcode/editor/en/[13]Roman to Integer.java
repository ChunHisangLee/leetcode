13
        Roman to Integer
        2023-01-01 01:03:17

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int num = 0;
        int temp = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }
            if (num < temp) {
                res -= num;
            } else {
                res += num;
            }
            temp = num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
