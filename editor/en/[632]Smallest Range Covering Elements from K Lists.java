
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).isEmpty()) {
                return new int[]{};
            }

            int val = nums.get(i).get(0);
            minHeap.offer(new Element(val, i, 0));
            currentMax = Math.max(currentMax, val);
        }

        int start = -100000;
        int end = 100000;

        while (true) {
            Element minElement = minHeap.poll();
            int currentStart = minElement.value;

            if (currentMax - currentStart < end - start || (currentMax - currentStart == end - start && currentStart < start)) {
                start = currentStart;
                end = currentMax;
            }

            if (minElement.elementIndex + 1 < nums.get(minElement.listIndex).size()) {
                int nextIndex = minElement.elementIndex + 1;
                int nextValue = nums.get(minElement.listIndex).get(nextIndex);
                minHeap.offer(new Element(nextValue, minElement.listIndex, nextIndex));

                if (nextValue > currentMax) {
                    currentMax = nextValue;
                }
            } else {
                break;
            }
        }

        return new int[]{start, end};
    }
}

class Element {
    int value;
    int listIndex;
    int elementIndex;

    Element(int value, int listIndex, int elementIndex) {
        this.value = value;
        this.listIndex = listIndex;
        this.elementIndex = elementIndex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
