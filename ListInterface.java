import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListInterface {
	
	public static void main(String []ags) {
		
		/*ArrayList implements only [List] interface
		 *ArrayList is NOT Synchronized
		 *Good at get method, but bad at add, remove methods
		 *ArrayList is better for storing and accessing data.*/
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Chinni");
		arr.add("Krishna");
		System.out.println(arr);
		arr.add(1, "Venky");
		System.out.println(arr);		
		System.out.println(arr.size());
		System.out.println(arr.get(1));
		System.out.println(arr.contains("V5enky"));
		arr.set(1, "Rika");
		System.out.println(arr);		
		System.out.println(arr.getClass());		
		System.out.println(arr.indexOf("Rika"));
		
		/*LinkedList implements [List, Queue] interfaces
		 *LinkedList is NOT Synchronized
		 *Good at add or remove methods but bad at get/set methods
		 *LinkedList class can act as a list and queue both because it implements List and Deque interfaces
		 *LinkedList should be preferred if: there are no large number of random access of element AND there are a large number of add/remove operations
		 *LinkedList is better for manipulating data.	*/
		
		List<String> al2=new LinkedList<String>();//creating linkedlist    
		  al2.add("James");//adding object in linkedlist    
		  al2.add("Serena");    
		  al2.add("Swati");    
		  al2.add("Junaid");
		  al2.add(1, "rupee");
		 
		 /*Vector implements only [List] interface
		  *Vector is Synchronized
		  *Rest all similar to ArrayList*/
		  
		List<String> vec=new Vector<String>();
		  vec.add("Rika");
		  vec.add(1, "Krishi");
		  System.out.println(vec.isEmpty());
		  
		  System.out.println("arraylist: "+arr);
		  System.out.println("linkedlist: "+al2);
		  System.out.println("Vector: "+vec); 			
	}

}
