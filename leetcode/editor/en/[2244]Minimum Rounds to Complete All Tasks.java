2244
        Minimum Rounds to Complete All Tasks
        2023-01-04 09:36:45

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        int left = 0;
        while (left < tasks.length) {
            int right = left + 1;
            while (right < tasks.length && tasks[right] == tasks[left]) {
                right++;
            }
            if (right == left + 1) {
                return -1;
            }
            if ((right - left) % 3 == 0) {
                res += (right - left) / 3;
            } else {
                res += (right - left) / 3 + 1;
            }
            left = right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            }
            if (count % 3 == 0) {
                res += count / 3;
            } else {
                res += count / 3 + 1;
            }
        }
        return res;
    }
}
 */