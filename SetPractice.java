import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetPractice {
	public static void main (String args[]) {
		
		/*HashSet implements only [Set] interface
		Uses HashMap to store the objects
		Does NOT maintain insertion order
		Performance is better than LinkedHashSet and TreeSet
		HashSet allows only one null objects
		None of HashSet, LinkedHashSet and TreeSet are Thread safe	*/
		
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		System.out.println(s.isEmpty());
		System.out.println(s.contains(2));
		System.out.println(s.size());		
		System.out.println(s);
		
		/*LinkedHashSet implements only [Set] interface
		Uses LinkedHashMap to store the objects
		Maintains insertin order 
		Performace is slower than TreeSet
		LinkedHashSet allows only one null objects.*/
		
		Set<Integer> s1 = new LinkedHashSet<Integer>();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		System.out.println(s1);
		
		
		/*TreeSet implements [Set, SortedSet] interfaces
		Uses TreeMap to store the objects
		Stores objects in ascending order by default
		TreeSet not allow a any null objects. If you insert null objects into TreeSet, it throws NullPointerException*/
		
		Set<Integer> s2 = new TreeSet<Integer>();
		s2.add(5);
		s2.add(6);
		s2.add(7);
		System.out.println(s2);				
	}

}
