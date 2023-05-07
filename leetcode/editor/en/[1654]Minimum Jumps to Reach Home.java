
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for (int num : forbidden) {
            set.add(num);
        }
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, false));
        set.add(0);
        int count = -1;
        int max = 6000;
        while (!dq.isEmpty()) {
            int size = dq.size();
            count++;
            for (int i = 0; i < size; i++) {
                Node curr = dq.poll();
                if (curr.val == x) {
                    return count;
                }
                int next = 0;
                if (!curr.isBack) {
                    next = curr.val - b;
                    if (next > 0 && !set.contains(next)) {
                        dq.add(new Node(next, true));
                        set.add(next);
                    }
                }
                next = curr.val + a;
                if (next < max && !set.contains(next)) {
                    dq.add(new Node(next, false));
                    set.add(next);
                }
            }
        }
        return -1;
    }
}

class Node {
    int val;
    boolean isBack;

    public Node(int val, boolean isBack) {
        this.val = val;
        this.isBack = isBack;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
