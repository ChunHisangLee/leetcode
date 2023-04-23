

//leetcode submit region begin(Prohibit modification and deletion)
class BrowserHistory {
    Deque<String> dqBack;
    Deque<String> dqForward;
    String homepage;

    public BrowserHistory(String homepage) {
        dqBack = new ArrayDeque<>();
        dqForward = new ArrayDeque<>();
        this.homepage = homepage;
    }

    public void visit(String url) {
        dqBack.push(homepage);
        homepage = url;
        dqForward.clear();
    }

    public String back(int steps) {
        while (steps > 0 && !dqBack.isEmpty()) {
            dqForward.push(homepage);
            homepage = dqBack.pop();
            steps--;
        }
        return homepage;
    }

    public String forward(int steps) {
        while (steps > 0 && !dqForward.isEmpty()) {
            dqBack.push(homepage);
            homepage = dqForward.pop();
            steps--;
        }
        return homepage;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
//leetcode submit region end(Prohibit modification and deletion)
