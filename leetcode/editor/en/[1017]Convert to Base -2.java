
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 1);
            n = -(n >> 1);
        }
        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}

//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public String base2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n & 1);
            n = (n >> 1);
        }
        return sb.length() > 0 ? sb.reverse().toString() : "0";
    }
}
 */