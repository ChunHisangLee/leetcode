
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();

        for (int stick : sticks) {
            pq.offer(stick);
        }

        int result=0;

        while (pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            int sum=first+second;
            result+=sum;
            pq.offer(sum);
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
