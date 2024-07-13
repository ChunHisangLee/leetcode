//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(indices, (a, b) -> positions[a] - positions[b]);
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> survivors = new ArrayList<>();
        int[] finalHealths = new int[n];

        for (int idx : indices) {
            char dir = directions.charAt(idx);
            int health = healths[idx];

            if (dir == 'R') {
                stack.push(idx);
            } else {
                while (!stack.isEmpty() && health > 0) {
                    int topIdx = stack.peek();
                    int topHealth = healths[topIdx];

                    if (topHealth == health) {
                        stack.pop();
                        health = 0;
                    } else if (topHealth > health) {
                        healths[topIdx] -= 1;
                        health = 0;
                    } else {
                        stack.pop();
                        health -= 1;
                    }
                }

                if (health > 0) {
                    finalHealths[idx] = health;
                    survivors.add(idx);
                }
            }
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            finalHealths[idx] = healths[idx];
            survivors.add(idx);
        }

        return survivors.stream()
                .sorted()
                .map(idx -> finalHealths[idx])
                .collect(Collectors.toList());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
