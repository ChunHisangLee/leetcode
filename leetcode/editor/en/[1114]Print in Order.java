
//leetcode submit region begin(Prohibit modification and deletion)
class Foo {
    private int currNum;
    public Foo() {
        currNum=1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (currNum != 1) {
                wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            currNum++;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (currNum != 2) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            currNum++;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (currNum != 3) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            currNum++;
            notifyAll();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
