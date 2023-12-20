1998
        GCD Sort of an Array
        2023-03-03 14:18:28

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] arr;

    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
            max = Math.max(max, num);
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        arr = new int[max + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        boolean[] flag = new boolean[max + 1];
        for (int i = 2; i * 2 <= max; i++) {
            if (!flag[i]) {
                for (int j = 2; i * j <= max; j++) {
                    if (set.contains(i * j)) {
                        union(i, i * j);
                    }
                    flag[i * j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (find(nums[i]) != find(sorted[i])) {
                return false;
            }
        }
        return true;
    }

    private int find(int x) {
        return arr[x] == x ? x : (arr[x] = find(arr[x]));
    }

    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            arr[x] = y;
        }
    }
}

class UnionFind {


    public UnionFind(int n) {

    }


}
//leetcode submit region end(Prohibit modification and deletion)
