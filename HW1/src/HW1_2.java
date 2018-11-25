import java.util.Scanner;
public class HW1_2 {

	public static void main(String[] args) {
		System.out.println("[HW #1_2] Student ID 1771022 : Hyojin Moon\n");
		
		Scanner input = new Scanner(System.in);
		
		//get maximum integer and answer of the questions
		System.out.println("Choose maximum integer n: ");
		int max_num = input.nextInt();
		System.out.println("Redundancy is allowed (y: 1 or n: 2)?");
		int ans_rdd = input.nextInt();
		System.out.println("Order is considered (y: 1 or n: 2)?");
		int ans_ord = input.nextInt();
		
		int num=0;
		
		System.out.println("\n=== Result ===");
		
		//print out all possible combinations and calculate the number of combinations
		for(int i=1; i<=max_num; i++) {
			for(int j=1; j<=max_num; j++) {
				if((ans_ord==2)&&(i<=j)) {					//when order is not allowed
					if(ans_rdd==2) {						//and redundancy is also not allowed
						if(i!=j) {
							System.out.println(i+" "+j);
							num++;
						}
					} else {								//order is not allowed but redundancy is allowed
						System.out.println(i+" "+j);
						num++;
					}
				} 
				
				if(ans_ord==1) {							//when order is allowed
					if(ans_rdd==2) {						//but redundancy is not allowed
						if(i!=j) {
							System.out.println(i+" "+j);
							num++;
						}
					} else {								//order is allowed and redundancy is also allowed
						System.out.println(i+" "+j);
						num++;
					}
				}
			}
		}
		
		//print out the total number of combinations
		System.out.println("=> Total # of combinations = "+num);	
		
		//print out whether redundancy is allowed or not and order should be considered or not for the combinations
		if(ans_ord==2) {
			if(ans_rdd==2)
				System.out.println("(Redundancy: n & Order: n)");
			else 
				System.out.println("(Redundancy: y & Order: n)");
		} 
		if(ans_ord==1) {
			if(ans_rdd==2) 
				System.out.println("(Redundancy: n & Order: y)");
			else 
				System.out.println("(Redundancy: y & Order: y)");
		}
		
		
	}

}
