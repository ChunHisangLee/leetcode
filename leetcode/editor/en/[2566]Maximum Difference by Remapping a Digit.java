2566
Maximum Difference by Remapping a Digit
2023-02-19 22:37:42
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMaxDifference(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        int maxD = -1;
        int minD = -1;
        int min = 0;
        int max = 0;
        while (num > 0) {
            list.addFirst(num % 10);
            num /= 10;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 9) {
                maxD = list.get(i);
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                minD = list.get(i);
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == maxD) {
                max = max * 10 + 9;
            } else {
                max = max * 10 + list.get(i);
            }
            if (list.get(i) == minD) {
                min = min * 10 + 0;
            } else {
                min = min * 10 + list.get(i);
            }
        }
        return max - min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
