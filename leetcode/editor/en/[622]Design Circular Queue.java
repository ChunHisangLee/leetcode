622
        Design Circular Queue
        2022-12-20 09:34:03

//leetcode submit region begin(Prohibit modification and deletion)
class MyCircularQueue {
    int[] arr;
    int index;
    int count;
    int capacity;

    public MyCircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        index = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[(index + count) % capacity] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        index = (index + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        return count == 0 ? -1 : arr[index];
    }

    public int Rear() {
        return count == 0 ? -1 : arr[(index + count - 1) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
