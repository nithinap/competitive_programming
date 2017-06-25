package challenges;

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class LinkedList {
	Node head = null;
	
    public Node push(int new_data)
    {
 
        /* 1. alloc the Node and put data*/
        Node new_Node = new Node(new_data);
 
        /* 2. Make next of new Node as head */
        new_Node.next = head;
 
        /* 3. Move the head to point to new Node */
        head = new_Node;
        return head;
    }
    
	Node Delete(Node head) {
		Node temp = head;
		int len = 0;
		while (temp != null) {
			temp = temp.next;
			++len;
		}
		int mid = len / 2;
		temp = head;
		len = 0;
		while (len != mid - 1) {
			++len;
			temp = temp.next;
		}

		temp.next = temp.next.next;
		temp.next.next = null;
		temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
		return head;
	}
}


public class DeleteMidLL {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.push(4);
		Node head = ll.push(5);
		ll.Delete(head);
	}
	

}
