package prodcons;

import java.util.ArrayList;
import java.util.Stack;

public class Hub {
	private Stack<Integer> ints = new Stack<Integer>();
	private boolean available = false;
	
	public synchronized int get() {
		while(ints.size() == 0) {
			try {
				wait();
			}catch (InterruptedException e) {}
		}

		notifyAll();
		if (ints.size() != 0) {
			return ints.pop();
		}
		else {
			return 0;
		}
	}
	
	public synchronized void put(int number) {
		ints.add(number);
		notifyAll();
	}
}
