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
        int num = n;
        int revNum = 0;
        while (num > 0) {
            int key = num % 10;
            if (!map.containsKey(key)) {
                return false;
            }
            revNum = revNum * 10 + map.get(key);
            num /= 10;
        }
        return revNum != n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
