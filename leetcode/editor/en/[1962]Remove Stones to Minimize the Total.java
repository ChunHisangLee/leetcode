1962
        Remove Stones to Minimize the Total
        2022-12-09 14:55:46

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            pq.add(pile);
        }
        for (int i = 0; i < k; i++) {
            int temp = pq.remove();
            temp -= temp / 2;
            pq.add(temp);
        }
        int res = 0;
        for (int num : pq) {
            res += num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
