package HW3_1;

public class HW3_1 {

	public static void main(String[] args) {
		Bakery1 bakery = new Bakery1();				//create an Bakery instance bakery
		Producer1 pro1 = new Producer1(bakery, 1);	//create an Producer instance pro1
		Producer1 pro2 = new Producer1(bakery, 2);	//create an Producer instance pro2
		Consumer1 con1 = new Consumer1(bakery, 1);	//create an Consumer instance con1
		Consumer1 con2 = new Consumer1(bakery, 2);	//create an Consumer instance con2
		
		pro1.start();	//make a new thread in pro1
		pro2.start();	//make a new thread in pro2
		con1.start();	//make a new thread in con1
		con2.start();	//make a new thread in con2
		
	}
	
}
