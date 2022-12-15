class Node {
    public int item ;
    public Node next;
    Node(int item){
        this.item =item;
    }
}
class Deque {
    Node head ;
    Node tail ;
    // construct an empty deque
    public Deque(){
    }
    // return true if the deque is empty, otherwise, return false
    public boolean isEmpty(){
        return (head ==null);
    }

    // add the item to the head
    public void addFirst(int item){
        Node newNode = new Node(item);
        Node tmp;
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tmp = head;
            head = newNode;
            head.next =tmp;
        }
    }

    // add the item to the tail
    public void addLast(int item){
        Node newNode = new Node(item);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            Node tmp ;
            tmp = tail;
            tail =newNode;
            tmp.next =tail;
        }
    }

    // remove and return the item from the head
    public int removeFirst(){
        if(head == null)
            return -1;
        Node tmp = head;
        head = head.next;
        return head.item;
    }

    // remove and return the item from the tail
    public int removeLast(){
        if(head == null)
            return -1;
        Node tmp = tail;
        Node tmp2 = head;

        while(true)
        {
            if(tmp2.next.next == null)
            {
                tmp2 = tmp2.next;
                break;
            }
        }
        tail =tmp2;
        tail.next =null;
        return tmp.item;

    }

}

class Main {
    static public void main(String[] arg){
        Deque deque = new Deque();
        deque.addFirst(1);
        deque.addFirst(2);
        System.out.println(deque.removeLast());
    }
}
