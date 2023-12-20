
//leetcode submit region begin(Prohibit modification and deletion)
class H2O {
    Semaphore hydrogenJob;
    Semaphore oxygenJob;

    public H2O() {
        hydrogenJob = new Semaphore(2);
        oxygenJob = new Semaphore(0);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenJob.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        oxygenJob.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenJob.acquire(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        hydrogenJob.release(2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
