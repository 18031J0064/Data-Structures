package searchengine.dictionary;

import java.util.ArrayList;
class HNode<K,V>
{
	K key;
	V value;
	HNode<K,V> next;
	public HNode(K k,V v)
	{
		key=k;
		value=v;
	}
}

public class MyHashDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>
{
	ArrayList<HNode<K, V>> bucketArray; 
	
    int numBuckets; 
    int size; 
   public MyHashDictionary() 
   { 
       bucketArray = new ArrayList<>(); 
       numBuckets = 10; 
       size = 0;  
       for(int i=0;i<numBuckets;i++) 
       {
           bucketArray.add(null); 
       }
   } 
   private int getBucketIndex(K key) 
   { 
       int hashCode = key.hashCode(); 
       int index = hashCode % numBuckets; 
       return index; 
   } 

	@Override
	public K[] getKeys() 
	{
		// TODO Auto-generated method stub
		System.out.println();
		K[] keys=(K[]) new String[bucketArray.size()];
      
		for(int i=0;i<bucketArray.size();i++)
        {
            HNode start=bucketArray.get(i);
            while(start != null)
            {
                keys[i]=(K) start.key;
                start = start.next;
            }
           
        }
		return keys;

	}

	@Override
	public V getValue(K str) {
		// TODO Auto-generated method stub
		int bucketIndex = getBucketIndex(str); 
        HNode<K, V> head = bucketArray.get(bucketIndex); 
  
        // Search key in chain 
        while (head != null) 
        { 
            if (head.key.equals(str)) 
                return head.value; 
            head = head.next; 
        } 
        System.out.println("over");

		return null;
	}

	@Override
	public void insert(K key, V value)
	{
		// TODO Auto-generated method stub
		int bucketIndex = getBucketIndex(key); 
	     HNode<K, V> head = bucketArray.get(bucketIndex); 
	     HNode<K, V> current=head;
	     
	     if(head!=null) 
	     {
	    	 while (head != null) 
	         { 

	             head = head.next; 
	         } 
	     	 System.out.println("=====exist key======");
	    	  HNode<K, V> newNode = new HNode<K, V>(key, value); 
	    	    newNode.next=current;
	    	     current=newNode;
	    	     bucketArray.set(bucketIndex, current); 
	     }
	     else 
	     {
	    	 size++; 
	    	 head = bucketArray.get(bucketIndex); 
	         HNode<K, V> newNode = new HNode<K, V>(key, value); 
	         newNode.next = head; 
	         bucketArray.set(bucketIndex, newNode); 
	     }
	   
	     if ((1.0*size)/numBuckets >= 0.7) 
	     { 
	         ArrayList<HNode<K, V>> temp = bucketArray; 
	         bucketArray = new ArrayList<>(); 
	         numBuckets = 2 * numBuckets; 
	         size = 0; 
	         for(int i=0;i<numBuckets;i++)
	         {
	               bucketArray.add(null); 
	         }
	         for(HNode<K,V> headNode:temp) 
	         { 
	             while (headNode != null) 
	             { 
	                 insert(headNode.key, headNode.value); 
	                 headNode = headNode.next; 
	             } 
	         } 
	     } 

		
	}

	@Override
	public void remove(K key)
	{
		// TODO Auto-generated method stub
		int bucketIndex = getBucketIndex(key); 

	     // Get head of chain 
	     HNode<K, V> head = bucketArray.get(bucketIndex); 
	     
	     if(head!=null)
	     {
	    	 bucketArray.set(bucketIndex,null);
	    	 System.out.println("Removed key"+ head.key);
	    	 size--; 
	     }
	     else 
	     {
	    	 System.out.println("No key found");
	     }
	}
	public HNode getNode(K key) 
	{
		 int bucketIndex = getBucketIndex(key); 
	     HNode<K, V> head = bucketArray.get(bucketIndex);
		return head;
	}
	@Override
	public int noofkeys() {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
