# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        def findMiddle(head) -> ListNode:
            fast = slow = head
            while fast and fast.next:
                fast = fast.next.next
                slow = slow.next
            return slow

        def reverseList(head) -> ListNode:
            prev = None
            while head:
                next_node = head.next
                head.next = prev
                prev = head
                head = next_node
            return prev

        def checkPalindrome(head, end) -> bool:
            p1 = head
            p2 = end
            isPalindrome = True
            while p2:
                if p1.val != p2.val:
                    isPalindrome = False
                    break
                p1 = p1.next
                p2 = p2.next
            return isPalindrome

        if not head or not head.next:
            return True

        middle = findMiddle(head)
        reversed_head = reverseList(middle)
        return checkPalindrome(head, reversed_head)

# leetcode submit region end(Prohibit modification and deletion)
