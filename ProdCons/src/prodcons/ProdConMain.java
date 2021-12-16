package prodcons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProdConMain {

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter number of initial producers: ");
		int prodCount = Integer.parseInt(reader.readLine());
		System.out.println(String.format("%d producers will now start producing random values ranged 0-100 every 5 seconds for 1 minute", prodCount));
		System.out.println("Commands: \n1 to create a new consumer \n2 to create a new producer \n3 to create 5 consumers\n4 to stop creating new threads");
		System.out.println("The '3' option to create 5 new Consumer threads is to demonstrate synchronization-safe threads\n\n");
		
		
		Hub hub = new Hub();
		
		for(int i = 0; i < prodCount; i++) {
			new Producer(hub, i);
		}
		
		boolean running = true;
		while(running) {
			int input = Integer.parseInt(reader.readLine());
			
			switch(input) {
				case 1: 
					new Consumer(hub); break;
				case 2: 
					new Producer(hub, -1); break;
				case 3:
					for (int i = 0; i < 5; i++) {
						new Consumer(hub);
					}
					break;
					
					
				default: System.out.println(input + " is invalid");
			}
		}
	}
}
