2526
Find Consecutive Integers from a Data Stream
2023-01-08 09:11:06
//leetcode submit region begin(Prohibit modification and deletion)
class DataStream {
    List<Integer>list;
    int k;
    int value;
    int count = 0;
    public DataStream(int value, int k) {
        this.k = k;
        this.value = value;
    }

    public boolean consec(int num) {
        if(num == value){
            count++;
        }else{
            count = 0;
        }
        return count >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
//leetcode submit region end(Prohibit modification and deletion)
