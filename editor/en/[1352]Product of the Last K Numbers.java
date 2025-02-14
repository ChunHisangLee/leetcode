// leetcode submit region begin(Prohibit modification and deletion)
class ProductOfNumbers {
  private List<Integer> prefix;

  public ProductOfNumbers() {
    prefix = new ArrayList<>();
    prefix.add(1);
  }

  public void add(int num) {
    if (num == 0) {
      prefix.clear();
      prefix.add(1);
    } else {
      int lastProduct = prefix.get(prefix.size() - 1);
      prefix.add(lastProduct * num);
    }
  }

  public int getProduct(int k) {
    int size = prefix.size();
    if (k >= size) {
      return 0;
    }
    return prefix.get(size - 1) / prefix.get(size - 1 - k);
  }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such: ProductOfNumbers obj = new
 * ProductOfNumbers(); obj.add(num); int param_2 = obj.getProduct(k);
 */
// leetcode submit region end(Prohibit modification and deletion)
