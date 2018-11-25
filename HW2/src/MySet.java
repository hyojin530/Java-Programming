import java.util.ArrayList;

public class MySet {

	/* when user makes an instance of MySet class,
	 * make an ArrayList for each instance to save and manage integer values
	 */
	ArrayList<Integer> this_set = new ArrayList<Integer>();
	
	//default constructor
	public MySet() {
		//construct an empty set
	}
	
	//constructor with int num parameter
	public MySet(int num) {
		this_set.add(num);	//construct a set that contains one element
	}
	
	//constructor with MySet s parameters
	public MySet(MySet s) {
		for(int i=0; i<s.Size(); i++) {			//copy all the elements in MySet s
			this_set.add(s.this_set.get(i));	//save the elements in this_set
		}
	}
	
	//method that deletes all the elements of this_set
	public void Empty() {
		//save the size of the this_set first, because the size would be changed continuously in for loop
		int size = this_set.size();	
		
		for(int i=0; i<size; i++) {	//in all indexes
			this_set.remove(0);		//remove the elements
		}
	}
	
	//method that inserts integer value into this_set
	public void Insert(int num) {
		for(int i=0; i<this_set.size(); i++) {	//check if the num is in this_set
			if(this_set.get(i) == num)			//if there is the num in this_set,
				return;							//exit the method
		}
		
		//when the num is not in this_set
		//if size of this_set is 0 or the num is larger than the value in the last index of this_set
		if(this_set.size()==0 || num>this_set.get(this_set.size()-1)) {	
			this_set.add(num);	//just add the num in this_set
		} 
		//otherwise, make the num be inserted in ascending order
		else {
			for(int i=0; i<this_set.size(); i++) {	//compare the num to the values in this_set
				if(num<this_set.get(i)) {			//find the index where the num will be inserted
					this_set.add(i, num);			//insert the num according to the index
					return;							//after insert the num, exit the method
				}
			}
		}
		
	}
	
	//method that delete the integer value from this_set
	public void Delete(int num) {
		for(int i=0; i<this_set.size(); i++) {	//check if the num is in this_set
			if(this_set.get(i) == num)			//if there is an element equal to the num in this_set,
				this_set.remove(i);				//remove the element
		}
	}
	
	//method that check whether the element equal to the num is present in this_set or not
	public boolean IsPresent(int num) {
		for(int i=0; i<this_set.size(); i++) {	//check if the num is in this_set
			if(this_set.get(i) == num)			//if there is an element equal to the num in this_set,
				return true;					//return true
		}
		
		return false;	//otherwise, return false
	}
	
	//method that check whether MySet s is subset of this_set or not
	public boolean IsSubset(MySet s) {
		if(s.Size()==0) {	//if the size of MySet s is zero, all sets have an empty set as a subset
			return true;	//so, return true
		} 
		else {													//otherwise,
			for(int i=0; i<s.Size(); i++) {						//check all the elements in MySet s is in this_set
				if(this.IsPresent(s.this_set.get(i))==false){	//if method finds the element of s not in this_set
					return false;								//return false
				}										
			}
		}
		
		return true;	//if all elements in MySet s is in this_set, return true
	}
	
	//method that check whether this_set and MySet s have the same elements
	public boolean IsEqual(MySet s) {
		for(int i=0; i<s.Size(); i++) {	//check all the elements in MySet s is in this_set
			if(this.IsPresent(s.this_set.get(i))==false) {	//if method finds the element of s not in this_set
				return false;								//return false
			}
		}
		if(this.Size()==s.Size()) {		//if all elements of s is in this_set and the size of two sets are the same
			return true;				//return true
		}
		
		return false;	//all elements of s is in this_set but the size of two set are not the same, return false
	}
	
	//method that returns the size of this_set
	public int Size() {
		return this_set.size();	//return the size of this_set
	}
	
	//method that print out all the elements in this_set
	public void Print() {
		System.out.print("{");							//print "{"
		for(int i=0; i<this.Size(); i++) {				//print out all the elements in this_set
			if((i+1) == this.Size())					//if an element is in the last index of this_set
				System.out.print(this_set.get(i));		//print the element without ", " 
			else										//otherwise
				System.out.print(this_set.get(i)+", ");	//print the element and ", "
		}
		
		System.out.print("}");							//print "}"
	}
	
	//method that returns the union set of two sets
	public MySet Union(MySet s) {
		MySet union = new MySet(this);	//make MySet union with this_set
		
		for(int i=0; i<s.Size(); i++) {	//check if there are any elements in MySet s that are not in this_set 
			if(this.IsPresent(s.this_set.get(i))==false)//if method finds that elements
				union.Insert(s.this_set.get(i));		//insert the elements into union
		}
		
		return union;	//return MySet union
	}
	
	//method that returns the intersection set of two sets
	public MySet Intersection(MySet s) {
		MySet intersec = new MySet();	//make MySet intersec
		
		for(int i=0; i<s.Size(); i++) {					//compare elements of MySets to elements of this_set
			if(this.IsPresent(s.this_set.get(i))==true)	//if elements of MySet s is in this_set
				intersec.Insert(s.this_set.get(i));		//insert the elements into intersec
		}

		return intersec;	//return MySet intersec
	}
	
	//method that returns the difference set(this_set - s)
	public MySet Diff(MySet s) {
		MySet diff = new MySet(this);	//make MySet diff with this_set
		
		for(int i=0; i<s.Size(); i++) {					//compare elements of MySet to elements of this_set
			if(this.IsPresent(s.this_set.get(i))==true)	//if there are any elements in MySet that are in this_set
				diff.Delete(s.this_set.get(i));			//delete the elements from diff
		}
		
		return diff;	//return MySet diff
	}
	
}
