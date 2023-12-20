967
        Numbers With Same Consecutive Differences
        2022-12-14 10:05:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        for(int i=1;i<10;i++){
            curr.add(i);
        }
        for (int i = 2; i <= n; i++) {
            List<Integer> next = new ArrayList<>();
            for (int x : curr) {
                int y = x % 10;
                if (y + k < 10)
                    next.add(x * 10 + y + k);
                if (k > 0 && y - k >= 0)
                    next.add(x * 10 + y - k);
            }
            curr = next;
        }
        int[]res = new int[curr.size()];
        for(int i=0;i<res.length;i++){
            res[i]=curr.get(i);
        }
        return res;
        //return curr.stream().mapToInt(j->j).toArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
