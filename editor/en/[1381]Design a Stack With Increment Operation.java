
//leetcode submit region begin(Prohibit modification and deletion)
class CustomStack {
    private int[] stack;
    private int[] inc;
    private int maxSize;
    private int stackPointer;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.stackPointer = 0;
    }
    
    public void push(int x) {
        if (stackPointer < maxSize) {
            stack[stackPointer] = x;
            inc[stackPointer] = 0;
            stackPointer++;
        }
    }

    public int pop() {
        if (stackPointer == 0) {
            return -1;
        }

        stackPointer--;

        if (stackPointer > 0) {
            inc[stackPointer - 1] += inc[stackPointer];
        }

        int res = stack[stackPointer] + inc[stackPointer];
        inc[stackPointer] = 0;
        return res;
    }
    
    public void increment(int k, int val) {
        int idx = Math.min(k, stackPointer) - 1;

        if (idx >= 0) {
            inc[idx] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
//leetcode submit region end(Prohibit modification and deletion)
