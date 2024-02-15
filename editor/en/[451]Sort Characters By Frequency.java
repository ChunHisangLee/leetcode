//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String frequencySort(String s) {
        int[]arr = new int[128];

        for (char c : s.toCharArray()) {
            arr[c]++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> arr[b] - arr[a]);

        for (int i = 0; i < 128; i++) {
            if (arr[i] > 0) {
                pq.offer((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char c = pq.poll();

            for (int i = 0; i < arr[c]; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
