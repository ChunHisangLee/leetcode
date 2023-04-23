1056
        Confusing Number
        2023-01-02 09:18:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean confusingNumber(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);
        int nCopy = n;
        int revNum = 0;
        while (nCopy > 0) {
            int res = nCopy % 10;
            if (!map.containsKey(res)) {
                return false;
            }
            revNum = revNum * 10 + map.get(res);
            nCopy /= 10;
        }
        return revNum != n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
