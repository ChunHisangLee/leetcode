1189
        Maximum Number of Balloons
        2022-11-27 23:02:21

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;
        for (char ch : text.toCharArray()) {
            switch (ch) {
                case 'b':
                    b++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'l':
                    l++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'n':
                    n++;
                    break;
            }
        }
        l /= 2;
        o /= 2;
        int min = b;
        min = Math.min(Math.min(Math.min(Math.min(min, n), o), l), a);
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
