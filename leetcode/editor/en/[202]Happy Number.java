202
        Happy Number
        2023-01-28 09:57:57

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet <>();
        while (!set.contains(n) && n != 1) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int x = n % 10;
                sum += x * x;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(n);
        while (n != 1) {
            int temp = 0;
            while (n != 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = temp;
            if (list.contains(n)) {
                break;
            } else {
                list.add(n);
            }
        }
        return n == 1;
    }
}
 */