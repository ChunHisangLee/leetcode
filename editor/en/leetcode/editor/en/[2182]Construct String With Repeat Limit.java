
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int i=0;i<26;i++) {
            if(count[i] > 0) {
                pq.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        char lastChar = 0;
        int lastCount = 0;

        while(!pq.isEmpty()) {
            int current = pq.poll();
            char currentChar = (char)(current + 'a');

            if(currentChar != lastChar) {
                int appendTimes = Math.min(count[current], repeatLimit);

                for(int i=0;i<appendTimes;i++) {
                    sb.append(currentChar);
                }

                lastChar = currentChar;
                lastCount = appendTimes;
                count[current] -= appendTimes;

                if(count[current] > 0) {
                    pq.offer(current);
                }
            }
            else {
                if(lastCount == repeatLimit) {
                    if(pq.isEmpty()) {
                        break;
                    }

                    int next = pq.poll();
                    char nextChar = (char)(next + 'a');
                    sb.append(nextChar);
                    count[next]--;
                    lastChar = nextChar;
                    lastCount = 1;

                    if(count[next] > 0) {
                        pq.offer(next);
                    }

                    pq.offer(current);
                }
                else {
                    int appendTimes = Math.min(count[current], repeatLimit - lastCount);

                    for(int i=0;i<appendTimes;i++) {
                        sb.append(currentChar);
                    }

                    lastCount += appendTimes;
                    count[current] -= appendTimes;

                    if(count[current] > 0) {
                        pq.offer(current);
                    }
                }
            }
        }

        return sb.toString();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
