
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Pair[] sortedNums = new Pair[n];
        for(int i = 0; i < n; i++) {
            sortedNums[i] = new Pair(nums[i], i);
        }
        Arrays.sort(sortedNums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if(a.value != b.value){
                    return Integer.compare(a.value, b.value);
                } else {
                    return Integer.compare(a.index, b.index);
                }
            }
        });

        int[] result = new int[n];
        System.arraycopy(nums, 0, result, 0, n);

        int start = 0;
        for(int i = 1; i <= n; i++) {
            if(i < n && (long)(sortedNums[i].value) - (long)(sortedNums[i-1].value) <= (long)limit) {
                continue;
            } else {
                if(start < i) {
                    int size = i - start;
                    int[] indices = new int[size];
                    int[] values = new int[size];
                    for(int j = start; j < i; j++) {
                        indices[j - start] = sortedNums[j].index;
                        values[j - start] = sortedNums[j].value;
                    }
                    Arrays.sort(indices);
                    Arrays.sort(values);
                    for(int j = 0; j < size; j++) {
                        result[indices[j]] = values[j];
                    }
                }
                start = i;
            }
        }
        return result;
    }

    class Pair {
        int value;
        int index;
        Pair(int v, int i){
            value = v;
            index = i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
