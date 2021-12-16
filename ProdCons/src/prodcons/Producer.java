package prodcons;

import java.util.Random;

public class Producer implements Runnable{
	private Hub hub;
	private int threadID;
	
	public Producer(Hub hub, int threadID) {
		this.hub = hub;
		this.threadID = threadID;
		new Thread(this).start();
	}


	@Override
	public void run() {
		for (int i  = 0; i < 20; i++) {
			Random r = new Random();
			int val = r.nextInt(100);
			if (threadID == -1)
				System.out.println("User generated thread produced " + val);
			else
				System.out.println("Producer Thread [ID: " + threadID + "] produced the value " + val);
			hub.put(val);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {e.printStackTrace();}
		}
		
	}

}
