
//leetcode submit region begin(Prohibit modification and deletion)
class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Deque<Integer>> map;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);
        map.computeIfAbsent(f, i -> new ArrayDeque<>()).push(val);
    }

    public int pop() {
        int x = map.get(maxFreq).pop();
        freq.put(x, maxFreq - 1);
        if (map.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return x;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
//leetcode submit region end(Prohibit modification and deletion)
