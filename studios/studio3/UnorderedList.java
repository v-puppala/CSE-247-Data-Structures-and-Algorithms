package studio3;

import java.util.LinkedList;
import java.util.List;

public class UnorderedList<T extends Comparable<T>> implements PriorityQueue<T> {

	public LinkedList<T> list;
	
	public UnorderedList() {
		list = new LinkedList<T>();
	}
	
	@Override
	public boolean isEmpty() {
		
		if(list.size()==0) {
			return true;
		}
		//
		// FIXME
		//
		return false;
	}

	@Override
	public void insert(T thing) {
		list.add(thing);
		//
		// FIXME
		//
	}

	@Override
	
	public T extractMin() {
		
		T a=list.getFirst();
		for(T element: list) {
			if(element.compareTo(a)<0) {
				a= element;
			}
			
		}
		list.remove(a);
		//
		
		// FIXME
		//
		return a;
	}

}
