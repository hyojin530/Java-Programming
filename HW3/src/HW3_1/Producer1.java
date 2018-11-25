package HW3_1;

//Producer inherits from a superclass of Thread
public class Producer1 extends Thread {
	private Bakery1 bakery;	//declare an instance of Bakery
	private int number;		//declare an integer variable
	
	//constructor with two parameters
	public Producer1(Bakery1 bakery, int number) {
		this.bakery = bakery;	//set bakery variable
		this.number = number;	//set number variable
	}
	
	public void run() {
		for(;;) {
			//generate 1~10 breads randomly
			int put_bread = (int)(Math.ceil((Math.random()*10)));
			//store generated breads in the bakery
			bakery.put(number, put_bread);
			
			if(Bakery1.end_game == true) {	//if end_game is true,
				break;						//break the loop statement
			}
			
			try {	//make the thread sleep for 0~100 milliseconds randomly
				sleep((int)(Math.random()*100));
			} catch(InterruptedException ex) {	//catch an interrupted exception
				System.out.println(ex);
			}
		}
	}
}
