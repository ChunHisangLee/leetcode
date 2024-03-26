# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        dummy = ListNode(0)
        dummy.next = list1
        prev = dummy

        for _ in range(a):
            prev = prev.next

        end = prev

        for _ in range(a, b + 1):
            end = end.next

        prev.next = list2

        while list2.next:
            list2 = list2.next

        list2.next = end.next
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
