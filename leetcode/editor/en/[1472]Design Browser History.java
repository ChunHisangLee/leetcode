

//leetcode submit region begin(Prohibit modification and deletion)
class BrowserHistory {
    List<String> list;
    int curr;
    int last;

    public BrowserHistory(String homepage) {
        list = new ArrayList<>(Arrays.asList(homepage));
        curr = 0;
        last = 0;
    }

    public void visit(String url) {
        curr++;
        if (list.size() > curr) {
            list.set(curr, url);
        } else {
            list.add(url);
        }
        last = curr;
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return list.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(last, curr + steps);
        return list.get(curr);
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
