433
        Minimum Genetic Mutation
        2022-12-08 17:47:05

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        char[] gene = new char[]{'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(endGene)) {
            return -1;
        }
        Set<String> isVisited = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();
        dq.add(startGene);
        isVisited.add(startGene);
        int count = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
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
                        if (!set.contains(str)) {
                            continue;
                        }
                        if (!isVisited.contains(str)) {
                            dq.add(str);
                            isVisited.add(str);
                        }
                    }
                    c[j] = temp;
                }
            }
            count++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
