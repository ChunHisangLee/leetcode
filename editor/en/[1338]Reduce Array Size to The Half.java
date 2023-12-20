1338
        Reduce Array Size to The Half
        2022-12-11 01:50:03

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = arr.length;
        int target = n / 2;
        int res = 0;
        int[] freq = new int[map.size()];
        int len = 0;
        for (int num : map.keySet()) {
            freq[len++] = map.get(num);
        }
        Arrays.sort(freq);
        int i = len - 1;
        while (n > target) {
            n -= freq[i];
            res++;
            i--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
