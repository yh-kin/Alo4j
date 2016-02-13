package resources.variable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class IterableVariable {
	private List<String> stringList = new ArrayList<String>();
	
	private Collection<Integer> intCollection = new HashSet<Integer>();
	
	private final Iterable<Double> doubleIterable;
	
	public IterableVariable(){
		stringList.add("abc");
		stringList.add("def");
		stringList.add("ghi");
		
		intCollection.add(1);
		intCollection.add(2);
		intCollection.add(3);
		
		List<Double> doubleList = new ArrayList<Double>();
		doubleList.add(1.2);
		doubleList.add(3.4);
		doubleList.add(5.6);
		doubleIterable = doubleList;
	}

	public List<String> getStringList() {
		return stringList;
	}

	public Collection<Integer> getIntCollection() {
		return intCollection;
	}

	public Iterable<Double> getDoubleIterable() {
		return doubleIterable;
	}
}
