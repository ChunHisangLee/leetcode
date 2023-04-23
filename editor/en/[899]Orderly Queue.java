//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String orderlyQueue(String s, int k) {
        String ans = s;
        if (k == 1) {
            for (int i = 0; i < s.length(); i++) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0)
                    ans = temp;
            }
            return ans;
        } else {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            return new String(ch);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
