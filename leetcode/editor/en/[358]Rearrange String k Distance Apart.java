
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                maxHeap.offer(new int[]{i, count[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<int[]> waitQueue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            sb.append((char) (curr[0] + 'a'));
            curr[1]--;
            waitQueue.offer(curr);
            if (waitQueue.size() < k) {
                continue;
            }
            int[] front = waitQueue.poll();
            if (front[1] > 0) {
                maxHeap.offer(front);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)
