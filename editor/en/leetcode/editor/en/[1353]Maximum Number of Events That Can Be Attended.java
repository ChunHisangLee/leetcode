
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        // Step 1: 先依照開始日排序
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        // Step 2: 使用最小堆儲存所有可以參加但還沒參加的活動的結束日
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = events.length;
        int res = 0; // 參加的活動數量
        int day = 0; // 當前天數
        int i = 0;   // events 的索引

        // 遍歷所有天數，只要還有活動沒加入heap或heap不空
        while (i < n || !minHeap.isEmpty()) {
            // 如果 heap 為空，就將 day 跳到下一個活動開始日
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }
            // 將所有「開始日 <= day」的活動的結束日加入 heap
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }
            // 移除所有結束日 < day 的活動（已過期）
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }
            // 如果還有可以參加的活動，參加一場
            if (!minHeap.isEmpty()) {
                minHeap.poll(); // 參加結束日最早的那場
                res++;
                day++; // 進入下一天
            }
        }
        return res;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
