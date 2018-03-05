package reverse_linkedList;



public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list=new LinkedList();
		list.head=list.new Node(85);
		list.head.next=list.new Node(7);
		list.head.next.next=list.new Node(14);
		list.head.next.next.next=list.new Node(97);
		list.head.next.next.next.next=list.new Node(17);
		list.head.next.next.next.next.next=list.new Node(10);
		list.printList(list.head);
		list.head=list.reverse(list.head);
		list.printList(list.head);
		
		

	}

}
