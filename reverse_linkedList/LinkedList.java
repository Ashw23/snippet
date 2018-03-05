package reverse_linkedList;

public class LinkedList {
Node head;
	 class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}
	Node reverse(Node node){
		Node prev=null;
		Node next=null;
		Node current=node;
		while(current!=null){
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		node=prev;
		return node;
		
	}
	void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }}
}
