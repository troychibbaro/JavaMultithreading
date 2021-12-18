package prodcons;

import java.util.ArrayList;
import java.util.Stack;

public class Hub {
	private Stack<Integer> ints = new Stack<Integer>();
	private final int MAX_SIZE = 100;
	
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
		while(ints.size() <= MAX_SIZE) {
			try {
				wait();
			} catch (InterruptedException e){}
		}
		ints.add(number);
		notifyAll();
	}
}
