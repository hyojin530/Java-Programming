import java.util.Scanner;
import java.util.ArrayList;

public class HW2_Test2 {

	public static void main(String[] args) {
		System.out.println("[HW #2_Test2]\n");
		System.out.println("Student ID 1771022: Hyojin Moon");
		
		//make an ArrayList to save the MySet instances generated in do-while loop
		ArrayList<MySet> created_sets = new ArrayList<MySet>();
		
		char set_name = 'A';	//declare a set_name variable
		int menu_num;			//declare a menu_num variable
		Scanner input = new Scanner(System.in);	//use Scanner to get the menu_num
		
		//use do-while loop to print out the menu at least once
		do {
			//first, print out current status
			System.out.println("\n\n[Current status]\n");	
			System.out.print("=> ");
			
			if(created_sets.size()==0) {	//if there is no MySet instance in created_sets
				System.out.print("None");	//print out "None"
			} 
			else {
				//print out all the sets(MySet instances) in created_sets
				for(int i=0; i<created_sets.size(); i++) {	
					System.out.print((char)(i+65)+" = ");	//ASCII code of 'A' is 65, so using (i+65)
					(created_sets.get(i)).Print();			//using Print() method in MySet
					if(i==(created_sets.size()-1)) {		//after printing the last set,
					}										//do not print ", "
					else System.out.print(", ");			//except for the last, print ", " between Print()
				}
			}
			
			//print the menu 1~10
			System.out.print("\n\n==== Menu ====\n\n"
					+ "1) Create a new empty set\n"
					+ "2) Create a new set from an existing set\n"
					+ "3) Insert number to a set\n"
					+ "4) Delete number from a set\n"
					+ "5) Query the union of two sets\n"
					+ "6) Query the intersection of two sets\n"
					+ "7) Query the difference of two sets\n"
					+ "8) Query the size of a set\n"
					+ "9) Print all the elements in a set\n"
					+ "10) Exit\n"
					+ "--------------------------------------------\n\n"
					+ "? ");
			
			menu_num = input.nextInt();	//get a number of the menu using menu_num variable
			
			//execute the program according to the menu_num
			switch(menu_num) {
			
			case 1:	//create a new empty set
				MySet new_set = new MySet();	//create a new empty set(MySet instance)
				created_sets.add(new_set);		//add the new set to the ArrayList created_sets
				
				System.out.print("\n=> Set "+(char)set_name+" is created");	//notify the new set is created
				set_name++;	//increase the ASCII code of set_name variable for the next new set
				break; //exit the switch statement
				
			case 2:	//create a new set from an existing set
				System.out.print("From which set?: ");	//ask which set
				char from_set = input.next().charAt(0);	//get a name of the set using from_set variable
				
				//create a new set from the selected set
				MySet myset2 = new MySet(created_sets.get(from_set-65));
				//add the new set to the ArrayList created_sets
				created_sets.add(myset2);	
				
				System.out.print("\n=> Set "+(char)set_name+" is created");	//notify the new set is created
				set_name++;	//increase the ASCII code of set_name variable for the next new set
				break; //exit the switch statement
				
			case 3:	//insert a number to a set
				System.out.print("- Type a number: ");  	//get a number
				int insert_num = input.nextInt();		    //using insert_num variable
				System.out.print("- Which set?: ");		    //get a set name
				char insert_set = input.next().charAt(0);	//using insert_set variable
				
				//insert a number to the selected set, using Insert method in MySEt class
				(created_sets.get(insert_set-65)).Insert(insert_num);
				
				System.out.print("\n=> Set "+insert_set+" is updated");	//notify the selected set is updated
				break; //exit the switch statement
				
			case 4:	//delete a number from a set
				System.out.print("- Type a number: ");		//get a number
				int delete_num = input.nextInt();			//using delete_num variable
				System.out.print("- Which set?: ");			//get a set name
				char delete_set = input.next().charAt(0);	//using delete_set variable
				
				//delete a number from the selected set, using Delete method in MySEt class
				(created_sets.get(delete_set-65)).Delete(delete_num);
				
				System.out.print("\n=> Set "+delete_set+" is updated");	//notify the selected set is updated
				break; //exit the switch statement
				
			case 5:	//query the union of two sets
				System.out.print("- Specify two sets: ");	//get name of two sets
				char union_set1 = input.next().charAt(0);	//using union_set1
				char union_set2 = input.next().charAt(0);	//and union_set2
				
				MySet union = new MySet();	//create a union set(MySet instance)
				
				//find a union set of two selected sets using Union method in MySet class 
				union = (created_sets.get(union_set1-65)).Union(created_sets.get(union_set2-65));
				
				//print the union set of two sets
				System.out.print("\n=> "+union_set1+" U "+union_set2+" = ");	
				union.Print();	//using Print() method
				break; //exit the switch statement
				
			case 6:	//query the intersection of two sets
				System.out.print("- Specify two sets: ");		//get name of two sets
				char intersec_set1 = input.next().charAt(0);	//using intersec_set1
				char intersec_set2 = input.next().charAt(0);	//and intersec_set2
				
				MySet intersec = new MySet();	//create a intersection set(MySet instance)
				
				//find a union set of two selected sets using Intersection method in MySet class
				intersec = (created_sets.get(intersec_set1-65)).Intersection(created_sets.get(intersec_set2-65));
				
				//print the intersection set
				System.out.print("\n=> "+intersec_set1+" ¡û "+intersec_set2+" = ");	
				intersec.Print();	//using Print() method												
				break; //exit the switch statement
				
			case 7:	//query the difference of two sets
				System.out.print("- Specify two sets: ");	//get name of two sets
				char diff_set1 = input.next().charAt(0);	//using diff_set1
				char diff_set2 = input.next().charAt(0);	//and diff_set2
				
				MySet diff = new MySet();	//create a difference of two sets(MySet instance)
				
				//find a difference of two selected sets using Diff method in MySet class
				diff = (created_sets.get(diff_set1-65)).Diff(created_sets.get(diff_set2-65));
				
				//print the difference of the two sets
				System.out.print("\n=> "+diff_set1+" - "+diff_set2+" = ");	
				diff.Print();	//using Print() method
				break; //exit the switch statement
				
			case 8:	//query the size of a set
				System.out.print("- Which set?: ");		//get a set name
				char size_set = input.next().charAt(0);	//using size_set variable
				
				//get a size of the set using Size() method in MySet class
				int size = (created_sets.get(size_set-65)).Size();
				
				System.out.print("\n=> The size of set "+size);	//print the size of the set
				break; //exit the switch statement
				
			case 9:	//print all the elements in a set
				System.out.print("- Which set?: ");		//get a set name
				char print_set = input.next().charAt(0);//using print_set variable
				
				System.out.print("\n=> ");				//print all the elements in the set
				created_sets.get(print_set-65).Print();	//using Print() method in MySet class
				break; //exit the switch statement
				
			case 10:	//exit the program
				System.out.print("You exit the program");	//print "You exit the program"
				break; //exit the switch statement
				
			default:	//if user entered invalid number, notify that
				System.out.print("You entered an invalid number");	//print "You entered an invalid number"
				break; //exit the switch statement
				
			}
			
		} while(menu_num!=10);	//when menu_num is 10, exit the do-while loop
		
	}

}
