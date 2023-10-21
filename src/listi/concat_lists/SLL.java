package listi.concat_lists;

public class SLL {
    private SLLNode head;
    private SLLNode tail;

    public void addNodeEnd(int data) {
        SLLNode newNode = new SLLNode(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void addNodeStart(int data){
        SLLNode newNode = new SLLNode(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

//    public void mergeSLL(SLL list){
//        System.out.println(this.tail.data);
//        SLLNode curr = list.head;
//        SLLNode endC = this.tail;
//
//        while(curr != null){
//            System.out.println(curr.data);
//            endC.next = curr;
//            endC = endC.next;
//            curr = curr.next;
//        }
//    }

    public void mergeSLL(SLL list) {
        if (list.head == null) {
            return;
        }

        if (this.head == null) {
            this.head = list.head;
            this.tail = list.tail;
        } else {
            this.tail.next = list.head;
            this.tail = list.tail;
        }
    }

    public int size(){
        SLLNode curr = this.head;
        int size = 0;
        while (curr != null){
            size++;
            curr = curr.next;
        }
        return size;
    }

    public SLLNode find(int data){
        SLLNode curr = this.head;
        while (curr != null){
            if(curr.data == data){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
    public void mirror(){
        SLLNode curr = this.head;
        this.tail = this.head;
        SLLNode prev = null;
        SLLNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }

    public void display() {
        SLLNode current = head;

        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of singly linked list: ");
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
