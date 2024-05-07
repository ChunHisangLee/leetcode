# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def doubleIt(self, head: Optional[ListNode]) -> Optional[ListNode]:
        def reversedList(node):
            prev = None
            current = node
            next = None
            while current:
                next = current.next
                current.next = prev
                prev = current
                current = next
            return prev

        reversed = reversedList(head)
        current = reversed
        prev = None
        carry = 0

        while current:
            sum = current.val * 2 + carry
            current.val = sum % 10
            carry = sum // 10
            prev = current
            current = current.next

        if carry > 0:
            prev.next = ListNode(carry)

        return reversedList(reversed)
# leetcode submit region end(Prohibit modification and deletion)
