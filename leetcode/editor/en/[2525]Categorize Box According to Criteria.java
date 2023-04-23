2525
        Categorize Box According to Criteria
        2023-01-08 09:10:47

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long volume = (long) length * width * height;
        boolean bulky = (length >= 1e4 || width >= 1e4 || height >= 1e4 || volume >= 1e9) ? true : false;
        boolean heavy = mass >= 100 ? true : false;

        if (bulky && heavy) {
            return "Both";
        }
        if (bulky) {
            return "Bulky";
        }
        if (heavy) {
            return "Heavy";
        }
        return "Neither";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
