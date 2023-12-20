1656
        Design an Ordered Stream
        2023-03-07 20:26:21

//leetcode submit region begin(Prohibit modification and deletion)
class OrderedStream {
    String[] data;
    int index;
    int n;

    public OrderedStream(int n) {
        index = 0;
        this.n = n;
        data = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> list = new ArrayList<>();
        data[idKey - 1] = value;
        while (index < n && data[index] != null) {
            list.add(data[index]);
            index++;
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
