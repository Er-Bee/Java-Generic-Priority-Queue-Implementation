import java.util.Iterator;

public class PQTester {
	public static void main(String []args) {
		// סעיף ב
		PriorityQueue pq = new PriorityQueue(10);
		pq.add("last", 10);
		pq.add("first", 1);
		pq.add("tied with first", 1);
		pq.add("second", 2);
		
		System.out.println("original strings:");
		Iterator iter = pq.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		System.out.println("adding string \"third\" with priority of 3");
		pq.add("third", 3);
		iter = pq.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println();
		
		System.out.println("emptying out the first two string using poll(), removing the last string using remove()");
		pq.poll();
		pq.poll();
		pq.remove("last");
		iter = pq.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		System.out.println();
		
		// סעיף ג
		CustomerTicket A = new CustomerTicket("John Doe", "not sweet enough", 1111);
		CustomerTicket B = new CustomerTicket("John Doe", "not sweet enough", 1111);
		CustomerTicket C = new CustomerTicket("Jane Doe", "too sweet", 2222);
		CustomerTicket D = new CustomerTicket("Jimothy Doe", "too cold", 3333);
		CustomerTicket E = new CustomerTicket("Jannet Doe", "wrong dish", 4444);
		
		PriorityQueue pqDoe = new PriorityQueue(5);
		pqDoe.add(B, 3);
		pqDoe.add(C, 4);
		pqDoe.add(D, 1);
		pqDoe.add(E, 2);
		
		System.out.println("tickets in order of priority:");
		iter = pqDoe.iterator();
		while(iter.hasNext()) {
			System.out.println(((CustomerTicket)iter.next()).getTicket());
		}
		
		System.out.println();
		
		System.out.println("polling first ticket:");
		CustomerTicket polled = (CustomerTicket)pqDoe.poll();
		System.out.println(polled.getTicket());
		System.out.println("\ntickets left, in order of priority:");
		iter = pqDoe.iterator();
		while(iter.hasNext()) {
			System.out.println(((CustomerTicket)iter.next()).getTicket());
		}
		
		System.out.println();
		
		System.out.println("in the most recent list above, look for a ticket using contains() and remove it using remove():");
		System.out.println("is there a ticket in the queue from John Doe saying: \"not sweet enough\"?: " + pqDoe.contains(A));
		pqDoe.remove(A);
		System.out.println("\nafter removal, tickets in order of priority look like this:");
		iter = pqDoe.iterator();
		while(iter.hasNext()) {
			System.out.println(((CustomerTicket)iter.next()).getTicket());
		}
	}
}
