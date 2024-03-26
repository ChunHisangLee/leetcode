public class Solution {
    public ListNode frequenciesOfElements(ListNode head) {
        ListNode node = head;
        Map<Integer, Integer> map = getFrequency(head);
        return getFrequencyList(map);
    }

    private Map<Integer, Integer> getFrequency(ListNode node) {
        Map<Integer, Integer> map = new HashMap<>();

        while (node != null) {
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);
            node = node.next;
        }

        return map;
    }

    private ListNode getFrequencyList(Map<Integer, Integer> map) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        for (int num : map.values()) {
            result.next = new ListNode(num);
            result = result.next;
        }

        return dummy.next;
    }
}