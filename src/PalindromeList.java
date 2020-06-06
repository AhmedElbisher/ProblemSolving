/*
Given a singly linked list, determine if its a palindrome. Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:

Expected solution is linear in time and constant in space.
For example,

List 1-->2-->1 is a palindrome.
List 1-->2-->3 is not a palindrome.

 */

public class PalindromeList {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }


    public int lPalin(ListNode A) {

        int size = 0 ;
        ListNode currNode= new ListNode(0) ;
        ListNode tail= new ListNode(0) ;
        ListNode prev= new ListNode(0) ;
        ListNode fut= new ListNode(0) ;

        if(A != null && A.next !=null ) currNode = A;
        else return 1;


        while(currNode.next != null) {             //determine the size
            size ++;
            currNode = currNode.next;
        }
        size ++;
        tail= currNode;                            //keep track of the tail

        int mid;
        if(size % 2 ==0 ) {
            mid = size /2;
        }else {
            mid = size/2 +1;
        }


        currNode = A;
        for(int i =0 ; i < mid ; i++ ) {
            if(i == mid-1) prev = currNode;
            currNode=currNode.next;
        }
        if(currNode.next != null) {fut=currNode.next; }


        while(currNode.next != null) {
            currNode.next=prev;
            prev=currNode;
            currNode=fut;
            fut=currNode.next;
        }
        currNode.next = prev;

        for(int i=0;i<mid ; i++) {
            if(currNode.val != A.val) return 0;
            A=A.next;
            currNode=currNode.next;
        }

        return 1;
    }

    }
