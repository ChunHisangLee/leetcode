
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution {
    public int shareCandies(int[] candies, int k) {
        int n = candies.length;

        if (k == 0) {
            int totalUnique = 0;
            int[] total_freq = new int[100001];

            for (int flavor : candies) {
                if (total_freq[flavor] == 0) {
                    totalUnique++;
                }

                total_freq[flavor]++;
            }

            return totalUnique;
        }

        if (k > n) {
            return 0;
        }

        int[] total_freq = new int[100001];

        for (int flavor : candies) {
            total_freq[flavor]++;
        }

        int total_unique_flavors = 0;

        for (int i = 0; i < total_freq.length; i++) {
            if (total_freq[i] > 0) {
                total_unique_flavors++;
            }
        }

        int[] window_freq = new int[100001];
        int current_flavors_entirely_in_window = 0;

        for (int i = 0; i < k; i++) {
            int flavor = candies[i];
            window_freq[flavor]++;

            if (window_freq[flavor] == total_freq[flavor]) {
                current_flavors_entirely_in_window++;
            }
        }

        int min_flavors_entirely_in_window = current_flavors_entirely_in_window;

        for (int i = k; i < n; i++) {
            int left_flavor = candies[i - k];

            if (window_freq[left_flavor] == total_freq[left_flavor]) {
                current_flavors_entirely_in_window--;
            }

            window_freq[left_flavor]--;

            if (window_freq[left_flavor] == total_freq[left_flavor]) {
                current_flavors_entirely_in_window++;
            }

            int right_flavor = candies[i];
            window_freq[right_flavor]++;

            if (window_freq[right_flavor] == total_freq[right_flavor]) {
                current_flavors_entirely_in_window++;
            } else if (window_freq[right_flavor] == total_freq[right_flavor] + 1) {
                current_flavors_entirely_in_window--;
            }

            if (current_flavors_entirely_in_window < min_flavors_entirely_in_window) {
                min_flavors_entirely_in_window = current_flavors_entirely_in_window;
            }
        }

        return total_unique_flavors - min_flavors_entirely_in_window;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
