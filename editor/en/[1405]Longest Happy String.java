//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Element> pq = new PriorityQueue<>((e1, e2) -> e2.count - e1.count);

        if (a > 0) {
            pq.offer(new Element('a', a));
        }

        if (b > 0) {
            pq.offer(new Element('b', b));
        }

        if (c > 0) {
            pq.offer(new Element('c', c));
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            Element first = pq.poll();
            int len = result.length();

            if (len >= 2 && result.charAt(len - 1) == first.ch && result.charAt(len - 2) == first.ch) {
                if (pq.isEmpty()) {
                    break;
                }

                Element second = pq.poll();
                result.append(second.ch);
                second.count--;

                if (second.count > 0) {
                    pq.offer(second);
                }

                pq.offer(first);
            } else {
                result.append(first.ch);
                first.count--;

                if (first.count > 0) {
                    pq.offer(first);
                }
            }
        }

        return result.toString();
    }

    private static class Element {
        char ch;
        int count;

        Element(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
