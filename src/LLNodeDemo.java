package joshua;
class LLNode{
	private int data;
	private LLNode next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LLNode getNext() {
		return next;
	}
	public void setNext(LLNode next) {
		this.next = next;
	}
	public LLNode(int data) {
		this.data = data;
		this.next = null;
	}
	
}

public class LLnodeDemo {

	LLNode create(LLNode head , int data ) {
		LLNode h = head;
		LLNode p = h;
		LLNode q = h;
		LLNode newNode = null;
		
		if(h == null) {
			h = new LLNode(data);
		}
		else {
			while(p!= null) {
				q= p;
				p = p.getNext();
			}
			newNode = new LLNode(data);
			q.setNext(newNode);
		}
		return h;
	}
	
	 public static void printNode(LLNode p, LLNode q) {
		while(p!= null) {
			q= p;
			System.out.println("-->"+ q.getData());
			p = p.getNext();
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LLNode node1 = new LLNode(10);
		LLNode node2 = new LLNode(20);
		LLNode node3 = new LLNode(30);
		LLNode node4 = new LLNode(40);
		LLNode head = null;
		LLNode p = null;
		LLNode q = null;
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		
		head = node1;
//		p = node1;
//		q= node1;
//		while(p!=null) {
//			q=p;
//			System.out.println("-->"+q.getData());
//			p = p.getNext();
//			
//		}
		
		printNode(node1, node1);
	}

}
