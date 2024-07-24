//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted((a, b) -> Comparator.comparingInt(num -> getMappedValue(num, mapping)))
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int getMappedValue(int number, int[] mapping) {
        int mappedValue = 0;
        int temp = number;
        int place = 1;

        if (temp == 0) {
            return mapping[0];
        }

        while (temp != 0) {
            mappedValue = place * mapping[temp % 10] + mappedValue;
            place *= 10;
            temp /= 10;
        }

        return mappedValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mappedPairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            mappedPairs[i][0] = nums[i];
            mappedPairs[i][1] = getMappedValue(nums[i], mapping);
        }

        Arrays.sort(mappedPairs, (a, b) -> Integer.compare(a[1], b[1]));
        int[] sortedNums = new int[n];

        for (int i = 0; i < n; i++) {
            sortedNums[i] = mappedPairs[i][0];
        }

        return sortedNums;
    }

    private int getMappedValue(int number, int[] mapping) {
        StringBuilder mappedValue = new StringBuilder();
        String numStr = String.valueOf(number);

        for (char digit : numStr.toCharArray()) {
            mappedValue.append(mapping[digit - '0']);
        }

        return Integer.parseInt(mappedValue.toString());
    }
}
 */