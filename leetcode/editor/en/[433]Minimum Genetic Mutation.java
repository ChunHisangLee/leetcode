433
        Minimum Genetic Mutation
        2022-12-08 17:47:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] gene = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        Set<String> visited = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();
        int count = -1;
        dq.add(startGene);
        visited.add(startGene);
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                String curr = dq.poll();
                if (curr.equals(endGene)) {
                    return count;
                }
                char[] c = curr.toCharArray();
                for (int j = 0; j < c.length; j++) {
                    char temp = c[j];
                    for (char g : gene) {
                        c[j] = g;
                        String str = String.valueOf(c);
                        if (!visited.contains(str) && set.contains(str)) {
                            dq.add(str);
                            visited.add(str);
                        }
                    }
                    c[j] = temp;
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
