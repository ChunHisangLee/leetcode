
//leetcode submit region begin(Prohibit modification and deletion)
/*
refer algo below

Time complexity:
O(nlogn) for change
O(1) for find

Space complexity:
O(n)

*/

class NumberContainers {
    Map<Integer, Integer> numbers;
    Map<Integer, PriorityQueue<Integer>> map;

    public NumberContainers() {
        numbers = new HashMap<>();
        map = new HashMap<>();
    }


    public void change(int index, int number) {
        if (numbers.containsKey(index)) {
            int temp = numbers.get(index);

            if (temp == number) {
                return;
            }
            map.get(temp).remove(index);
        }
        numbers.put(index, number);
        map.putIfAbsent(number, new PriorityQueue<Integer>());
        map.get(number).add(index);
    }

    public int find(int number) {
        if (!map.containsKey(number) || map.get(number).size() == 0) {
            return -1;
        }

        return map.get(number).peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(keyIndex,number);
 * int param_2 = obj.find(number);
 */
//leetcode submit region end(Prohibit modification and deletion)
