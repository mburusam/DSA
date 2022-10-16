

/*
Datastructures and algorithms
 Learning
@Author smburu
 */
public class SinglyLinkedList {

    private ListNode head;


    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next =null;
        }
    }


    public void display(){
        ListNode current = head;
        while (current !=null){
            System.out.print(current.data +"-->");
            current =current.next;
        }
        System.out.println("NULL");
    }

    public int length(){
        if(head ==null)return 0;
        ListNode current= head;
        int count=0;

        while (current!=null){
            count++;
            current=current.next;
        }
        return count;
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next =head;
        head=newNode;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head=newNode;
            return;
        }
        ListNode current= head;
        while (current.next !=null){
            current =current.next;
        }

        current.next=newNode;

    }

    public void insertPosition(int pos, int data){
        ListNode newNode = new ListNode(data);
        int length = length();
        if (pos < 1 || pos > length){
            throw new IllegalArgumentException();
        }
        if (pos == 1){
            newNode.next =head;
            head=newNode;
        }else {
            ListNode previous =head;
            int count =1;
            while (count< pos-1){
                previous =previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next=current;
            previous.next=newNode;
        }




    }


    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(20);
        ListNode second = new ListNode(40);
        ListNode third = new ListNode(60);
        ListNode fourth = new ListNode(80);

        sll.head.next =second;
        second.next=third;
        third.next=fourth;

        sll.display();
        sll.insertFirst(10);
        System.out.println( sll.length());

        sll.display();
        sll.insertLast(25);
        sll.insertLast(35);
        sll.insertPosition(4,33);

        sll.display();

    }


}

