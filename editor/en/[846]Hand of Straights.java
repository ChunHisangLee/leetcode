
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> countMap = new TreeMap<>();

        for (int num : hand) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            int count = countMap.get(key);

            if (count > 0) {
                for (int i = 1; i < groupSize; i++) {
                    int nextKey = key + i;

                    if (countMap.getOrDefault(nextKey, 0) < count) {
                        return false;
                    }

                    countMap.put(nextKey, countMap.get(nextKey) - count);
                }
            }
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
