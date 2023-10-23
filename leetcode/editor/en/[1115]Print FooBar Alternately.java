
//leetcode submit region begin(Prohibit modification and deletion)
class FooBar {
    private int n;
    private Semaphore fooJob;
    private Semaphore barJob;

    public FooBar(int n) {
        this.n = n;
        fooJob = new Semaphore(1);
        barJob = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooJob.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barJob.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            barJob.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooJob.release();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
