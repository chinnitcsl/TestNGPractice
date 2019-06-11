import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Deque<Integer> q = new LinkedList<Integer>();
		
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q);
		System.out.println(q);
		q.poll();
		System.out.println(q);
		System.out.println(q.offer(4));
		System.out.println(q);
		//q.clear();
		System.out.println(q.element());
		q.poll();
		q.addFirst(1);
		q.addLast(5);
		System.out.println(q.getFirst());
		System.out.println(q);
		
		

	}

}

