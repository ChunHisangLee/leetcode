
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minEnd(int n, int x) {
        ArrayList<Integer> shifts = new ArrayList<>();
        long curr = x;
        long calc = n - 1;

        for(int i = 0; i < 32; i++) {
            if((x & (1 << i)) == 0) {
                shifts.add(i);
            }
        }

        for(int i = 32; i < 64; i++) {
            shifts.add(i);
        }

        for(int i = 0; calc > 0; i++, calc >>= 1) {
            curr += (calc & 1L) << shifts.get(i);
        }

        return curr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
