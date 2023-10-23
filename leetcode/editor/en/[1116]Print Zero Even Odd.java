
//leetcode submit region begin(Prohibit modification and deletion)
class ZeroEvenOdd {
    private int n;
    private Semaphore zeroJob;
    private Semaphore oddJob;
    private Semaphore evenJob;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zeroJob = new Semaphore(1);
        oddJob = new Semaphore(0);
        evenJob = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroJob.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                oddJob.release();
            } else {
                evenJob.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenJob.acquire();
            printNumber.accept(i);
            zeroJob.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddJob.acquire();
            printNumber.accept(i);
            zeroJob.release();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
