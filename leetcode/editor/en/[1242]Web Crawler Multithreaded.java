
/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 * public List<String> getUrls(String url) {}
 * }
 */

/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 * public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    static int working = 0;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        final Lock lock = new ReentrantLock();
        final Condition cv = lock.newCondition();
        Deque<String> deque = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);
        deque.offer(startUrl);

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Thread producer = new Thread(() -> {
                while (true) {
                    lock.lock();
                    while (deque.isEmpty() && working != 0) {
                        try {
                            cv.await();
                        } catch (Exception e) {
                        }
                    }

                    if (deque.isEmpty()) {
                        lock.unlock();
                        return;
                    }

                    String url = deque.poll();
                    working++;
                    lock.unlock();
                    List<String> newUrls = htmlParser.getUrls(url);
                    lock.lock();
                    for (String newUrl : newUrls) {
                        if (this.checkHostname(startUrl, newUrl) && !visited.contains(newUrl)) {
                            visited.add(newUrl);
                            deque.offer(newUrl);
                        }
                    }
                    working--;
                    cv.signalAll();
                    lock.unlock();
                }
            });
            producer.start();
            threads.add(producer);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (Exception e) {
            }
        }

        return new ArrayList<String>(visited);
    }

    private boolean checkHostname(String startUrl, String newUrl) {
        startUrl = startUrl.substring(7).split("/")[0];
        newUrl = newUrl.substring(7).split("/")[0];
        return startUrl.equals(newUrl);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
