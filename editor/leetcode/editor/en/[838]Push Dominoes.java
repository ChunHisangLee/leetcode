// leetcode submit region begin(Prohibit modification and deletion)
class Solution {

  public String pushDominoes(String dominoes) {
    int n = dominoes.length();
    StringBuilder symbols = new StringBuilder();
    symbols.append('L').append(dominoes).append('R');

    char[] result = symbols.toString().toCharArray();

    int i = 0;
    for (int j = 1; j < result.length; ++j) {
      if (result[j] == '.') continue;
      if (result[i] == result[j]) {
        for (int k = i + 1; k < j; ++k) {
          result[k] = result[i];
        }
      } else if (result[i] == 'R' && result[j] == 'L') {
        int left = i + 1, right = j - 1;
        while (left < right) {
          result[left++] = 'R';
          result[right--] = 'L';
        }
      }
      i = j;
    }

    return new String(result, 1, n);
  }
}

// leetcode submit region end(Prohibit modification and deletion)
