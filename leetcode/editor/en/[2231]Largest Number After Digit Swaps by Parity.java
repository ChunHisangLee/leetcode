
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestInteger(int num) {
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        int reference = num;
        int result = 0;
        int multiply = 1;

        while (num > 0) {
            int temp = num % 10;

            if (temp % 2 == 1) {
                odd.add(temp);
            } else {
                even.add(temp);
            }

            num /= 10;
        }

        while (reference > 0) {
            int temp = reference % 10;

            if (temp % 2 == 1) {
                result = odd.poll() * multiply + result;
            } else {
                result = even.poll() * multiply + result;
            }

            reference /= 10;
            multiply *= 10;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
