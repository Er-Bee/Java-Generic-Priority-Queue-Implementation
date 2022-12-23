import java.util.ArrayList;
import java.util.Iterator;

//generic priority queue implementation
public class PriorityQueue<T> {
	private ArrayList<Integer> priorities;
	private ArrayList<T> queueList;
	// we want the object at index m in 'queueList' have its priority saved in 'priorities' at the same index (m).
	// for example, if we're given 3 objects: object A with priority 4, object B with priority 1, and object C with priority 5
	// queueList will look like:	BAC
	// priorities will look like:	145
	
	private int MAXPRIO = 10;
	private final int MINPRIO = 1;
	
	public PriorityQueue(int n) {	// build new priority queue.
		if(n >= MINPRIO && n <= MAXPRIO)
			MAXPRIO = n;
		queueList = new ArrayList<T>();
		priorities = new ArrayList<>();
	}
	
	public void add(T obj, int prio) {	// adds an object to the list considering it's priority.
		int practicalPrio = prio;	// if given priority is out of the specified range (1...min(10,n)), set its priority to the max. 
		if(prio > this.MAXPRIO || prio < MINPRIO)
			practicalPrio = this.MAXPRIO;
		
		if (this.queueList.isEmpty()) {	// if list is empty, just insert the object and the priority.
			this.queueList.add(obj);
			this.priorities.add(practicalPrio);
		}
		else {	// list isn't empty, check where the given object needs to be considering it's priority.
			if(practicalPrio == MAXPRIO) {
				this.priorities.add(practicalPrio);
				this.queueList.add(obj);
				return;
			}
			int last = this.priorities.indexOf(MAXPRIO);
			if (last == -1)	// look for index of first object with lowest priority, if none exist, save the last index that exists in list.
				last = this.priorities.size();
			int index = last;
			for (int i = 0; i < last; i++) {
				if (practicalPrio < priorities.get(i)) {
					index = i;
					break;
				}
			}
			this.priorities.add(index, practicalPrio);
			this.queueList.add(index, obj);
		}
	}
	
	
	
	public T poll() {	// removes and returns object of the highest priority.
		if (this.queueList.isEmpty())
			return null;
		this.priorities.remove(0); // remove the first element which is the one with the highest priority.
		return this.queueList.remove(0);
	}
	
	public boolean contains(T obj) {	// return boolean value whether list contains an object that's equal to obj.
		return this.queueList.contains(obj);
	}
	
	public boolean remove(T obj) {	// returns true of succesfully removed the first instance of obj in the list. else returns false.
		int firstIndex = this.queueList.indexOf(obj);
		if(firstIndex == -1)
			return false;
		this.priorities.remove(firstIndex);
		this.queueList.remove(firstIndex);
		return true;
	}
	
	public int size() {	// returning the amount of objects in the list.
		return this.queueList.size();
	}
	
	public Iterator<T> iterator() {	// returning an iterator for all objects in the list.
		return this.queueList.iterator();
	}
	
}
