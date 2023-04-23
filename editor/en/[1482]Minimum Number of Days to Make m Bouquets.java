class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length || m * k < 0) {
            return -1;
        }

        //int min = Collections.min(Arrays.asList(bloomDay));
        //int max = Collections.max(Arrays.asList(bloomDay));

        int min = 0;
        int max = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] > max) max = bloomDay[i];
        }

        while (max > min + 1) {
            int mid = min + (max - min) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                max = mid;
            } else {
                min = mid;
            }
        }

        return max;

    }

    public boolean isValid(int[] bloomDay, int m, int k, int day) {
        int bPicked = 0;
        int contiguous = 1;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                //If this is a contiguous streak of Trues
                if (contiguous == k) {
                    bPicked++;
                    //If there are valid number of bouquets
                    if (bPicked == m) {
                        return true;
                    }
                    contiguous = 1;
                } else {
                    contiguous++;
                }
            } else {
                contiguous = 1;
            }
        }
        return false;
    }
}