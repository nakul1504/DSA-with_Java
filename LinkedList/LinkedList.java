package LinkedList;

class Node{
    int data;
    Node next;

    Node(int data1, Node next1){
        this.data = data1;
        this.next = next1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}

// Linked List
public class LinkedList {

    private static Node convertArrayToLinkedList(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;

        for(int i=1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    private static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    private static int lengthOfLinkedList(Node head){
        int count = 0;

        Node temp = head;

        // Traversal of a linked list
        while(temp != null){
            temp = temp.next;
            count++;
        }

        return count;
    }

    private static int checkIfValuePresent(Node head, int value){
        Node temp = head;

        // Traversal of a linked list
        while(temp != null){
            if(temp.data == value) return 1;
            temp = temp.next;
        }

        return 0;
    }

    // DELETION

    private static Node deleteHead(Node head){
        if(head == null) return head;
        head = head.next;
        return head;
    }

    private static Node deleteTail(Node head){
        if(head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
        return head;
    }

    private static Node deleteKthElement(Node head, int k){
        if(head == null) return head;
        if(k == 1){
            head = head.next;
            return head;
        }

        int cnt = 1;
        Node temp = head;
        Node prev = null;

        while (temp != null){
            if(cnt == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            cnt++;
        }
        return head;
    }

    private static Node deleteElementByValue(Node head, int value){
        if(head == null) return head;
        if(head.data == value){
            head = head.next;
            return head;
        }


        Node temp = head;
        Node prev = null;

        while (temp != null){
            if(temp.data == value){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    // INSERTION

    private static Node insertHead(Node head, int value){
        if(head == null){
            return new Node(value);
        }
        Node temp = new Node(value, head);
        return temp;
    }

    private static Node insertTail(Node head, int value){
        if(head == null){
            return new Node(value);
        }

        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        Node newNode = new Node(value);
        temp.next = newNode;

        return head;
    }

    private static Node insertAtKthPosition(Node head, int k ,int value){
        if (head == null) {
            if (k == 1) {
                return new Node(value);
            }else{
                return null;
            }
        }

        if(k == 1){
            Node temp = new Node(value, head);
            return temp;
        }

        int count = 1;
        Node temp = head;
        while (temp != null){
            if(count == k-1){
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
            count++;
        }

        return head;
    }


    private static Node insertBeforeTheElement(Node head, int element ,int value){
        if (head == null) {
            return null;
        }

        if(head.data == element){
            Node temp = new Node(value, head);
            return temp;
        }

        Node temp = head;
        while (temp != null){
            if(temp.next.data == element){
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }

        return head;
    }

    private static Node insertAfterTheElement(Node head, int element, int value){
        if(head == null){
            return null;
        }

        if(head.data == element){
            Node newNode = new Node(value);
            head.next = newNode;
            return head;
        }

        Node temp = head;
        while (temp != null){
            if(temp.data == element){
                Node newNode = new Node(value);
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }

            temp = temp.next;
        }

        return head;
    }

    private static Node findMiddleOfALinkedList(Node head){
        if(head == null){
            return null;
        }
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node findMiddleOfALinkedListModified(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head;

        fast = fast.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static Node mergeTwoSortedLists(Node head1, Node head2){
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while(head1 != null && head2 != null){
            if (head1.data < head2.data){
                temp.next = head1;
                temp = head1;
                head1 = head1.next;
            }else{
                temp.next = head2;
                temp = head2;
                head2 = head2.next;
            }
        }

        if (head1 != null){
            temp.next = head1;
        }else{
            temp.next = head2;
        }

        return dummyNode.next;
    }

    private static Node sortALinkedList(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node middleNode = findMiddleOfALinkedListModified(head);
        Node rightNode = middleNode.next;
        middleNode.next = null;

        Node leftNode = head;

        leftNode = sortALinkedList(leftNode);
        rightNode = sortALinkedList(rightNode);

        return mergeTwoSortedLists(leftNode, rightNode);
    }

    private static Node reverseALinkedList(Node head){
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }

    private static Node reverseALinkedListRecursively(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseALinkedList(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newHead;
    }

    private static Node sortAListOf0s1sAnd2s(Node head){
        if (head == null || head.next == null){
            return head;
        }

        Node zeroHead = new Node(-1);
        Node zero = zeroHead;

        Node oneHead = new Node(-1);
        Node one = oneHead;

        Node twoHead = new Node(-1);
        Node two = twoHead;

        Node temp = head;

        while (temp != null){
            if (temp.data == 0){
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            }else {
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }

    private static int helper(Node temp){
        if(temp == null){
            return 1;
        }

        int carry = helper(temp.next);

        temp.data = temp.data + carry;
        if(temp.data < 10){
            return 0;
        }
        temp.data = 0;
        return 1;
    }

    private static Node add1toALinkedList(Node head){
        if (head == null){
            return null;
        }

        int carry = helper(head);

        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arr = {9,9};

        // Conversion of array to a Linked list
        Node head = convertArrayToLinkedList(arr);

        head = add1toALinkedList(head);
        printLinkedList(head);
    }
}
