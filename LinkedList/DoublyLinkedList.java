package LinkedList;


import javax.swing.plaf.metal.MetalButtonUI;

class NodeDLL{
    int data;
    NodeDLL next;
    NodeDLL back;

    NodeDLL(int data1, NodeDLL next1, NodeDLL back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    NodeDLL(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
public class DoublyLinkedList {

    private static NodeDLL convertArrayToDoublyLinkedList(int[] arr){


        NodeDLL head = new NodeDLL(arr[0]);
        NodeDLL prev = head;

        for(int i = 1; i < arr.length; i++){
            NodeDLL temp = new NodeDLL(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    private static void print(NodeDLL head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // DELETIONS
    private static NodeDLL deleteHead(NodeDLL head){
        if (head == null || head.next == null){
            return null;
        }

        NodeDLL prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;

        return head;
    }

    private static NodeDLL deleteTail(NodeDLL head){
        if(head == null || head.next == null){
            return null;
        }

        NodeDLL tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        NodeDLL prev = tail.back;
        prev.next = null;
        tail.back = null;

        return head;
    }

    private static NodeDLL deleteKthNode(NodeDLL head, int k){
        if(head == null){
            return null;
        }

        int count = 1;
        NodeDLL kNode = head;
        while (kNode != null){
            if(count == k) break;
            count++;
            kNode = kNode.next;
        }

        NodeDLL prev = kNode.back;
        NodeDLL front = kNode.next;

        if(front == null && prev == null){
            return null;

        } else if(prev == null){
            return deleteHead(head);
        }else if(front == null){
            return deleteTail(head);
        }

        prev.next = front;
        front.back = prev;

        kNode.next = null;
        kNode.back = null;

        return head;
    }

    private static void deleteNode(NodeDLL temp){
        NodeDLL prev = temp.back;
        NodeDLL front = temp.next;

        if(front == null){
            prev.next = null;
            front.back = null;
            return;
        }

        prev.next = front;
        front.back = prev;

        temp.back = null;
        temp.next = null;
        return;
    }

    // INSERTIONS
    private static NodeDLL insertBeforeHead(NodeDLL head, int value){
        if(head == null){
           return new NodeDLL(value);
        }

        NodeDLL newHead = new NodeDLL(value, head, null);
        newHead.next = head;

        return newHead;
    }

    private static NodeDLL insertAfterHead(NodeDLL head, int value){
        if(head == null){
            return new NodeDLL(value);
        }

        NodeDLL front = head.next;
        NodeDLL newNode = new NodeDLL(value, front, head);
        front.back = newNode;
        head.next = newNode;

        return head;
    }

    private static NodeDLL insertBeforeTail(NodeDLL head, int value){
        if(head == null){
            return new NodeDLL(value);
        }

        if(head.next == null){
            return insertBeforeHead(head, value);
        }

        NodeDLL tail = head;
        while (tail.next != null){
            tail = tail.next;
        }

        NodeDLL prev = tail.back;
        NodeDLL newNode = new NodeDLL(value, tail, prev);
        prev.next = newNode;
        tail.back = newNode;

        return head;
    }

    private static NodeDLL insertAfterTail(NodeDLL head, int value){
        if(head == null){
            return new NodeDLL(value);
        }

        if(head.next == null){
            return insertAfterHead(head ,value);
        }

        NodeDLL tail =  head;
        while (tail.next != null){
            tail = tail.next;
        }

        NodeDLL newNode = new NodeDLL(value, null, tail);
        tail.next = newNode;

        return head;

    }

    private static NodeDLL insertBeforeKthNode(NodeDLL head, int value, int k){
        if(k == 1){
            return insertBeforeHead(head, value);
        }

        int count = 1;
        NodeDLL temp = head;
        while (temp.next != null){
            if(count == k) break;
            count++;
            temp = temp.next;
        }

        if(temp.next == null){
            return insertBeforeTail(head, value);
        }

        NodeDLL prev = temp.back;

        NodeDLL kNode = new NodeDLL(value, temp, prev);
        temp.back = kNode;
        prev.next = kNode;

        return head;
    }

    private static NodeDLL insertAfterKthNode(NodeDLL head, int value, int k){
        if(k == 1){
            return insertAfterHead(head, value);
        }

        int count = 1;

        NodeDLL temp = head;
        while (temp.next != null){
            if(count == k) break;
            temp = temp.next;
            count++;
        }

       if(temp.next == null){
           return insertAfterTail(head, value);
       }

       NodeDLL front  = temp.next;
       NodeDLL kNode = new NodeDLL(value, front, temp);

       temp.next = kNode;
       front.back = kNode;

       return head;

    }

    private static NodeDLL reverseADoublyLinkedList(NodeDLL head){
        if(head.next == null){
            return head;
        }

        if(head == null){
            return null;
        }

        NodeDLL current = head;
        NodeDLL last = null;

        while (current != null){
            last = current.back;
            current.back = current.next;
            current.next = last;

            current = current.back;
        }

        head = last.back;
        return head;
    }
    public static void main(String[] args) {
        int[] arr = {2, 6, 7, 8};

        NodeDLL head = convertArrayToDoublyLinkedList(arr);

        head = reverseADoublyLinkedList(head);
        print(head);
    }
}
