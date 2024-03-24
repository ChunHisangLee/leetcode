# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        def find_middle(head) -> ListNode:
            fast = slow = head
            while fast and fast.next:
                fast = fast.next.next
                slow = slow.next
            return slow

        def reverse_list(head) -> ListNode:
            prev = None
            while head:
                temp = head.next
                head.next = prev
                prev = head
                head = temp
            return prev

        def merge(first, second) -> None:
            while first and second:
                temp1 = first.next
                temp2 = second.next
                first.next = second
                if temp1 is None:
                    break
                second.next = temp1
                first = temp1
                second = temp2

        middle = find_middle(head)
        end = reverse_list(middle.next)
        middle.next = None
        merge(head, end)
# leetcode submit region end(Prohibit modification and deletion)
