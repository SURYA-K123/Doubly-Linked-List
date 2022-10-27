class DoublyLinkedList
{
    Node head;
    Node tail;
    class Node
    {
        int data;
        Node prev;
        Node next;
        Node(int data)
        {
            this.data=data;
            Node prev=null;
            Node next=null;
        }
    }
    void push(DoublyLinkedList list,int val)
    {
        Node a=new Node(val);
        if(list.head==null)
        {
            list.head=a;
            list.tail=a;
            return;
        }
        a.next=list.head;
        list.head.prev=a;
        list.head=a;
    }
    void delete(DoublyLinkedList list,int val)
    {
        if(list.head==null)
        {
            System.out.println("List is empty nothing to delete");
            return;
        }
        if (list.head.data==val)
        {
            list.head=list.head.next;
            list.head.prev.next=null;
            list.head.prev=null;
        }
        else if (list.tail.data==val)
        {
            list.tail=list.tail.prev;
            list.tail.next.prev=null;
            list.tail.next=null;
        }
        else
        {
            Node a=list.head;
            while(a.next!=list.tail && a.data!=val)
            {
                a=a.next;
            }
            if(a.data==val)
            {
                a.prev.next=a.next;
                a.next.prev=a.prev;
                return;
            }
            System.out.println(val + " not found");
        }
    }
    void append(DoublyLinkedList list,int val)
    {
        Node a=list.tail;
        Node b= new Node(val);
        if(a==null)
        {
            list.head=a;
            list.tail=a;
            return;
        }
        a.next=b;
        b.prev=a;
        list.tail=b;
    }
    void insertAfter(DoublyLinkedList list,int data1,int data2)
    {
        if(list.head==null)
        {
            System.out.println("Nothing to be inserted");
            return;
        }
        Node a= new Node(data2);
        Node b=list.head;
        while(b.next!=null && b.data !=data1 )
        {
            b=b.next;
        }
        if(b.data==data1)
        {
            a.next=b.next;
            a.prev=b;
            b.next.prev=a;
            b.next=a;
            return;
        }
        System.out.println(data1+" not found");
    }
    void printFromFront(DoublyLinkedList list)
    {
        Node a=list.head;
        System.out.println("Printing list from front :");
        while (a!=null)
        {
            System.out.print(a.data+" ");
            a=a.next;
        }
        System.out.println("");
    }
    void printFromLast(DoublyLinkedList list)
    {
        Node a=list.tail;
        System.out.println("Printing list from last :");
        while(a!=null)
        {
            System.out.print(a.data+" ");
            a=a.prev;
        }
    }
    public static void main(String[] args)
    {
        DoublyLinkedList list= new DoublyLinkedList();
        list.push(list,3);
        list.push(list,8);
        list.push(list,10);
        list.push(list,18);
        list.insertAfter(list ,8,80);
        list.insertAfter(list ,80,800);
        list.append(list,30);
        list.append(list,300);
        list.delete(list,300);
        list.delete(list,18);
        list.delete(list,800);
        list.printFromFront(list);
        list.printFromLast(list);
    }
}
