
//leetcode submit region begin(Prohibit modification and deletion)
class Foo {
    private Semaphore firstJob;
    private Semaphore secondJob;


    public Foo() {
        firstJob = new Semaphore(0);
        secondJob = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "firstJob". Do not change or remove this line.
        printFirst.run();
        firstJob.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstJob.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondJob.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondJob.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
