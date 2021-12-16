package prodcons;

public class Consumer implements Runnable{
	private Hub hub;
	
	public Consumer(Hub hub) {
		this.hub = hub;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		int retrievedValue = hub.get();	
		System.out.println("User generated thread consumed " + retrievedValue);
	}
}
