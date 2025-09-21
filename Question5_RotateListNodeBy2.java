public class RotateList {

    public static void main(String[] args) {

        // Test 1: Normal rotation
        // Expected: "ID_A05"->"ID_A06"->"ID_A01"->"ID_A02"->"ID_A03"->"ID_A04"->null
        System.out.println("Test 1: Rotate by 2");
        ListNode head1 = buildList(new String[]{"ID_A01","ID_A02","ID_A03","ID_A04","ID_A05","ID_A06"});
        ListNode rotated1 = rotateRight(head1, 2);
        printList(rotated1);

        // Test 2: Rotate by 0 (should stay same)
        // Expected: "A"->"B"->"C"->null
        System.out.println("\nTest 2: Rotate by 0");
        ListNode head2 = buildList(new String[]{"A","B","C"});
        ListNode rotated2 = rotateRight(head2, 0);
        printList(rotated2);

        // Test 3: Rotate empty list
        // Expected: null
        System.out.println("\nTest 3: Empty list");
        ListNode rotated3 = rotateRight(null, 3);
        printList(rotated3);

        // Test 4: Rotate list with 1 element
        // Expected: "ONLY"->null
        System.out.println("\nTest 4: Single element list");
        ListNode head4 = buildList(new String[]{"ONLY"});
        ListNode rotated4 = rotateRight(head4, 5);
        printList(rotated4);

        // Test 5: Rotate by multiple of length (n = length)
        // Expected: "X"->"Y"->"Z"->null
        System.out.println("\nTest 5: Rotate by length");
        ListNode head5 = buildList(new String[]{"X","Y","Z"});
        ListNode rotated5 = rotateRight(head5, 3);
        printList(rotated5);

        // Test 6: Rotate by more than length
        // Expected: "2"->"3"->"1"->null
        System.out.println("\nTest 6: Rotate by more than length (n=5)");
        ListNode head6 = buildList(new String[]{"1","2","3"});
        ListNode rotated6 = rotateRight(head6, 5);
        printList(rotated6);

    }

    // Definition of a singly linked list node
    static class ListNode {
        String val;    // value stored in the node
        ListNode next; // reference to the next node

        ListNode(String val) {
            this.val = val;
            this.next = null;
        }
    }


     // Handle edge cases: empty list, single element, or n=0.
     // Find the length of the list and connect the last node to the head (make it circular).
     // Calculate the new head position using modulo (n % length).
     // Traverse to the new tail and break the circular link.
     // Return the new head.
    public static ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head; // no rotation needed
        }

        // Step 1: Find length and last node
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Step 2: Connect last node to head
        temp.next = head;

        // Step 3: Find actual rotation steps (handle n > length)
        n = n % length;
        int stepsToNewHead = length - n;

        // Step 4: Move to the new tail
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break circle and set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // Prints all nodes in the linked list in order.
    // Format: "val"->"val"->...->null
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print("\"" + current.val + "\"->");
            current = current.next;
        }
        System.out.println("null");
    }


    // Builds a linked list from an array of string values.
    // Returns the head of the newly created list.
    public static ListNode buildList(String[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
}
