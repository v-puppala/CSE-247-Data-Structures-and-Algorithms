package hash;

import java.util.LinkedList;

//
// STRINGTABLE.JAVA
// A hash table mapping Strings to their positions in the the pattern sequence
// You get to fill in the methods for this part.
//
public class StringTable {
    
    private LinkedList<Record>[] buckets;
    private int nBuckets;

    //
    // number of records currently stored in table --
    // must be maintained by all operations
    //
    public int size;
    
    
    //
    // Create an empty table with nBuckets buckets
    //
    @SuppressWarnings("unchecked")
	public StringTable(int nBuckets)
    {
    	this.nBuckets = nBuckets;
    	buckets = new LinkedList[nBuckets];
    	size=0;
    	//iterate through the linked list
	
    	// TODO - fill in the rest of this method to initialize your table
    }
    
    
    /**
     * insert - inserts a record to the StringTable
     *
     * @param r
     * @return true if the insertion was successful, or false if a
     *         record with the same key is already present in the table.
     */
    public boolean insert(Record r) 
    {  
    	String target=r.key;
    	int code=stringToHashCode(target);
    	int index= toIndex(code);
    	
    		if (buckets[index]==(null)) {
    			buckets[index]=new LinkedList<Record>();
    			buckets[index].add(r);
    			size++;
    			return true;
    		}
    		else {
    			for(Record a: buckets[index]) {
    				
    			//for(int i=0;i<buckets[index].size();i++) {
    				
    				if (a.key.equals(r.key)) {
    					return false;
    				}
    			//	if(i==buckets[index].size()-1) {
    				//	//buckets[index].add(r);
    				//	size++;
    				//	return true;
    				//}
    				
    			}
    			buckets[index].add(r);
    			size++;
    			return true;
    		}
    		
   
    	// TODO - implement this method
	
   
    }
    
    
    /**
     * find - finds the record with a key matching the input.
     *
     * @param key
     * @return the record matching this key, or null if it does not exist.
     */
    public Record find(String key)
    {
    	String target=key;
    	int code=stringToHashCode(target);
    	int index= toIndex(code);
    	// TODO - implement this method
    	if(buckets[index]==null) {
    	return null;
    }
    	else {
    		for(int i=0;i<buckets[index].size();i++) {
				if (buckets[index].get(i).key.equals(key)) {
					return buckets[index].get(i);
				}
				}
    		return null;
			}
    	}
    
    
    
    /**
     * remove - finds a record in the StringTable with the given key
     * and removes the record if it exists.
     *
     * @param key
     */
    public void remove(String key) {
    	int code=stringToHashCode(key);
    	int index= toIndex(code);
    	if(buckets[index]!=null) {
    		for(int i=0;i<buckets[index].size();i++) {
    			if(buckets[index].get(i).key.equals(key)) {
    				buckets[index].remove(buckets[index].get(i));
    				size--;
    				
    			}
    		}
    	}
    }
    
    {
    	// TODO - implement this method
    }
    

    /**
     * toIndex - convert a string's hashcode to a table index
     *
     * As part of your hashing computation, you need to convert the
     * hashcode of a key string (computed using the provided function
     * stringToHashCode) to a bucket index in the hash table.
     *
     * You should use a multiplicative hashing strategy to convert
     * hashcodes to indices.  If you want to use the fixed-point
     * computation with bit shifts, you may assume that nBuckets is a
     * power of 2 and compute its log at construction time.
     * Otherwise, you can use the floating-point computation.
     */
    private int toIndex(int hashcode)
    {
    	double A=(Math.sqrt(5)-1.0)/2.0;
    	int b=(int) Math.abs(((hashcode*A)%1.0)*nBuckets);
    	// Fill in your own hash function here
	
    	return b;
    }
    
    
    /**
     * stringToHashCode
     * Converts a String key into an integer that serves as input to
     * hash functions.  This mapping is based on the idea of integer
     * multiplicative hashing, where we do multiplies for successive
     * characters of the key (adding in the position to distinguish
     * permutations of the key from each other).
     *
     * @param string to hash
     * @returns hashcode
     */
    int stringToHashCode(String key)
    {
    	int A = 1952786893;
	
    	int v = A;
    	for (int j = 0; j < key.length(); j++)
	    {
    		char c = key.charAt(j);
    		v = A * (v + (int) c + j) >> 16;
	    }
	
    	return v;
    }

    /**
     * Use this function to print out your table for debugging
     * purposes.
     */
    public String toString() 
    {
    	StringBuilder sb = new StringBuilder();
	
    	for(int i = 0; i < nBuckets; i++) 
	    {
    		sb.append(i+ "  ");
    		if (buckets[i] == null) 
		    {
    			sb.append("\n");
    			continue;
		    }
    		for (Record r : buckets[i]) 
		    {
    			sb.append(r.key + "  ");
		    }
    		sb.append("\n");
	    }
    	return sb.toString();
    }
}
