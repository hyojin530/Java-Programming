import java.util.Scanner;
public class HW1_1 {

	public static void main(String[] args) {
		System.out.println("[HW #1_1] Student ID 1771022 : Hyojin Moon\n");
		
		int num;
		Scanner input = new Scanner(System.in);
		
		//take a number and if input is equal to or less than zero, repeat the statement using do-while
		do {
			System.out.print("How many numbers: ");
			num = input.nextInt();
		} while(num<=0);
		
		//set variables for calculation
		double min=0, max=0, sum=0, sum_sqr=0, mean, std;
		
		//take numbers for calculation and calculate a few things at the same time
		System.out.format("Enter %d numbers:\n", num);
		for(int i=0; i<num; i++) {
			double num_in = input.nextDouble();
			if(i==0) {				//when get the first number, put the number into min and max variables for the following comparisons
				min = num_in;
				max = num_in;
			} else {				//compare numbers to get the minimum and maximum results
				if(num_in<min) {
					min = num_in;
				}
				if(num_in>max) {
					max = num_in;
				}
			}
			
			//calculate the sum and the sum of squares
			sum += num_in;					
			sum_sqr += (num_in)*(num_in);	
		}
		
		//calculate mean and standard deviation
		mean = (sum/num);
		std = Math.sqrt((sum_sqr/num)-(mean*mean));
		
		//print the results
		System.out.println("\n=== Results ===");
		System.out.println("Min: "+min);
		System.out.println("Max: "+max);
		System.out.format("Mean: %.2f\n", mean);
		System.out.format("Standard Deviation = %.2f\n", std);
	}

}
