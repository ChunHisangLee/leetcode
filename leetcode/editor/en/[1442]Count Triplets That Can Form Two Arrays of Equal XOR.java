
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prefix[i] == prefix[j + 1]) {
                    count += (j - i);
                }
            }
        }

        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];
        int count = 0;

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prefix[i] == prefix[j + 1]) {
                    count += (j - i);
                }
            }
        }

        return count;
    }
}
 */