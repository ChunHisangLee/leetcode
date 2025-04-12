// leetcode submit region begin(Prohibit modification and deletion)
class Solution {
  int n, m, k;
  long[] fact;
  // Use a set to record unique frequency encodings.
  HashSet<Long> goodFreqs = new HashSet<>();

  public long countGoodIntegers(int n, int k) {
    this.n = n;
    this.k = k;
    this.m = (n + 1) / 2;
    // Precompute factorials up to n (n<=10) for permutations counting.
    fact = new long[n + 1];
    fact[0] = 1;
    for (int i = 1; i <= n; i++) {
      fact[i] = fact[i - 1] * i;
    }

    // DFS to generate all valid halves.
    int[] half = new int[m];
    dfs(0, half);

    long ans = 0;
    // For each unique frequency vector, compute number of orders.
    for (long code : goodFreqs) {
      int[] freq = decodeFreq(code);
      long total = permutations(n, freq);
      long invalid = 0;
      if (freq[0] > 0) {
        freq[0]--; // fix a zero as first digit
        invalid = permutations(n - 1, freq);
        freq[0]++; // restore for clarity
      }
      ans += (total - invalid);
    }

    return ans;
  }

  // DFS recursively builds the half array.
  private void dfs(int pos, int[] half) {
    if (pos == m) {
      // Build the full palindrome's frequency array and compute mod k.
      int[] freq = new int[10];
      // For even n, the palindrome is half + reverse(half)
      // For odd n, the palindrome is half + reverse(half[0..m-2])
      long modVal = 0;
      // We will build the full number digit-by-digit.
      int totalDigits = n;
      // Fill the left half (all m digits).
      for (int i = 0; i < m; i++) {
        int d = half[i];
        freq[d]++;
        modVal = (modVal * 10 + d) % k;
      }
      // Determine start position for the mirror.
      int mirrorStart = (n % 2 == 0) ? m - 1 : m - 2;
      for (int i = mirrorStart; i >= 0; i--) {
        int d = half[i];
        freq[d]++;
        modVal = (modVal * 10 + d) % k;
      }
      if (modVal % k == 0) {
        // Encode the frequency array into a long and store it.
        long code = encodeFreq(freq);
        goodFreqs.add(code);
      }
      return;
    }

    // For the first digit of half, disallow 0.
    int startDigit = (pos == 0 ? 1 : 0);
    for (int d = startDigit; d < 10; d++) {
      half[pos] = d;
      dfs(pos + 1, half);
    }
  }

  // Compute the number of unique permutations for total 'len' digits given frequency array.
  private long permutations(int len, int[] freq) {
    long ways = fact[len];
    for (int f : freq) {
      ways /= fact[f];
    }
    return ways;
  }

  // Encode frequency vector into a long using base 11.
  // Frequencies are at most n (n<=10), so base 11 is safe.
  private long encodeFreq(int[] freq) {
    long code = 0;
    for (int i = 0; i < 10; i++) {
      code = code * 11 + freq[i];
    }
    return code;
  }

  // Decode a long back into a frequency array.
  private int[] decodeFreq(long code) {
    int[] freq = new int[10];
    for (int i = 9; i >= 0; i--) {
      freq[i] = (int) (code % 11);
      code /= 11;
    }
    return freq;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
