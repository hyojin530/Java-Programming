package HW3_1;

public class Bakery1 {
	//declare an static integer variable to count the number of breads in bakery
	private static int total = 0;
	//declare an static boolean variable to end the game
	public static boolean end_game = false;
	
	//synchronized method used in Consumer class to get 5 breads
	public synchronized void get(int who) {
		if(end_game == true) {	//if end_game is true,
			notifyAll();		//wake up all the threads
			return;				//end the method
		}
		
		while(total<5) {	//when total is less than 5,
			try {
				wait();		//thread will be in waiting state
			} catch(InterruptedException ex) {	
				System.out.println(ex);	//catch an interrupted exception
			}
		}

		//subtract 5 from total because consumer took 5 breads
		total -= 5;	
		//print out which consumer got the breads and how much bread is left in bakery
		System.out.println("Consumer "+who+" got: 5 (Total # of Breads = "+total+")");
		notifyAll();	//wake up all the other threads
		return;			//end the method
	}
	
	//synchronized method used in Producer class to put some bread
	public synchronized void put(int who, int put_bread) {
		if(end_game == true) {	//if end_game is true,
			notifyAll();		//wake up all the other threads
			return;				//end the method
		}

		//add put_bread to total
		total += put_bread;
		//print out which producer put how much bread and how much bread is in bakery
		System.out.println("Producer "+who+" put: "+put_bread+" (Total # of Breads = "+total+")");
		notifyAll();	//wake up all the other threads
		return;			//end the method
	}
}
