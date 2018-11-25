
public class HW2_Test1 {

	public static void main(String[] args) {
		System.out.println("[HW #2_Test1]\n");
		System.out.println("Student ID 1771022: Hyojin Moon\n");
		
		MySet a = new MySet();	//create MySet a with default constructor
		a.Insert(2);			//insert 2 into a
		a.Insert(3);			//insert 3 into a
		
		
		MySet b = new MySet(a);	//create MySet b with MySet a
		b.Insert(5);			//insert 5 into b
		
		MySet c = a.Intersection(b);	//put intersection set of a and b into c
		MySet d = b.Intersection(a);	//put intersection set of b and a into d
		MySet e = a.Diff(b);			//put difference set 'a-b' into e
		MySet f = b.Diff(a);			//put difference set 'b-a' into f
		System.out.print("MySet c = ");
		c.Print();						//print MySet c
		System.out.println();
		
		MySet g = new MySet(1);			//create MySet g with 1
		g.Empty();						//remove all the elements of g
		g.Insert(7);					//insert 1 into g
		g.Insert(4);					//insert 4 into g
		System.out.print("MySet g = ");	//print MySet g
		g.Print();		
		System.out.println();
		
		e.IsPresent(3);	//check that 3 is in e
		f.Delete(5);	//delete 5 from f
		b.IsSubset(f);	//check that f is a subset of b
		g.IsEqual(a);	//check that a is equal to g
		
		System.out.println("the size of a = "+a.Size());	//print the size of a
		System.out.println("the size of b = "+b.Size());	//print the size of b
		
		MySet h = a.Union(b);			//put union set of a and b into h
		System.out.print("MySet h = ");	//print MySet h
		h.Print();				
		System.out.println();

	}

}
