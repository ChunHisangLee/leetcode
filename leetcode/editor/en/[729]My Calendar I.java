
//leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar {
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = map.lowerKey(end);
        if ((prev == null || map.get(prev) <= start)) {
            map.put(start, end);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
//leetcode submit region end(Prohibit modification and deletion)
