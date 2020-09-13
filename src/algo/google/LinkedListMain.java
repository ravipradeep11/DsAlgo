package algo.google;

import com.leetds.ListNode;

public class LinkedListMain {
    public static void main(String[] args){

        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

    }
    //1->2->3->4->5
    // 1 3 5 2 4-- 1 3 4 5 2 -- 1 3 5 2 4
    // 1 2 3 4 --     1 3 4 2
    public ListNode oddEvenList(ListNode head) {
        if(head.next==null||head.next.next==null) return head;
        ListNode firstnode=head.next;
        ListNode tail=head;
        while(tail.next!=null) tail=tail.next;
        boolean isOdd=true;
        return null;


    }
}
