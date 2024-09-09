//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(0, 0);
        PolyNode curr = dummy;

        while (poly1 != null && poly2 != null) {
            if (poly1.power == poly2.power) {
                int sumCoeff = poly1.coefficient + poly2.coefficient;

                if (sumCoeff != 0) {
                    curr.next = new PolyNode(sumCoeff, poly1.power);
                    curr = curr.next;
                }

                poly1 = poly1.next;
                poly2 = poly2.next;
            } else if (poly1.power > poly2.power) {
                curr.next = new PolyNode(poly1.coefficient, poly1.power);
                curr = curr.next;
                poly1 = poly1.next;
            } else {
                curr.next = new PolyNode(poly2.coefficient, poly2.power);
                curr = curr.next;
                poly2 = poly2.next;
            }
        }

        if (poly1 != null) {
            curr.next = poly1;
        }

        if (poly2 != null) {
            curr.next = poly2;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
