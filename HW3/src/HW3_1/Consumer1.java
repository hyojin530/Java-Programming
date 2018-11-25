package HW3_1;

//Consumer inherits from a superclass of Thread
public class Consumer1 extends Thread {
	private Bakery1 bakery;	//declare an instance of Bakery
	private int number;		//declare an integer variable 
	public int get_bread = 0;	//declare an integer variable to count the number of breads obtained
	
	public Consumer1(Bakery1 bakery, int number) {
		this.bakery = bakery;	//set bakery variable
		this.number = number;	//set number variable
	}
	
	public void run() {
		for(;;) {
			bakery.get(number); //get 5 breads from bakery
			
			if(Bakery1.end_game == true) {	//if end_game is true,
				break;						//break out of the for loop
			}
			
			get_bread += 5;	//count the number of breads obtained
			
			//if consumer get 20 breads,
			if(get_bread == 20) {	
				//set end_game to true
				Bakery1.end_game = true;	
				//notify that the game is done
				System.out.println("\n: Done"); 
				//print out the winner of the game
				System.out.println("=> Consumer "+number+" won the game! (first ate 20 breads)");
				//break out of the for loop
				break;
			}
			
			try {	//make the thread sleep for 0~100 milliseconds randomly
				sleep((int)(Math.random()*100));
			} catch(InterruptedException ex) {	//catch an interrupted exception
				System.out.println(ex);
			}
		}
		
	}
}
