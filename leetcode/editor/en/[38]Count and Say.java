38
        Count and Say
        2023-01-07 13:56:43

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            String next = "";
            for (int j = 0, k = 0; j < res.length(); j = k) {
                while (k < res.length() && res.charAt(k) == res.charAt(j)) {
                    k++;
                }
                next += Integer.toString(k - j) + res.charAt(j);
            }
            res = next;
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
