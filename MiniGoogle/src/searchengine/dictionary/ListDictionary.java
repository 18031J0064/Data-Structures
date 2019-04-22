package searchengine.dictionary;
class LNode<K,V>
{
	K Key;
	V Value;
	LNode<K,V> next;
	public LNode(K k,V v)
	{
		Key=k;
		Value=v;
	}
}

public class ListDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>{
LNode<K,V> head;
	@Override
	public int noofkeys()
	{
		LNode<K,V> current=head;
		int count=0;
		while(current!=null)
		{
			current=current.next;
			count++;
		}
		return count;
		
	}
	public K[] getKeys() {
		LNode<K,V> current=head;
		int n;
		n=noofkeys();
		String a[]=new String[n];
		if(n==0)
		{
			return null;
		}
		else
		{
			for(int i=0;i<n;i++)
			{
				a[i]=(String)current.Key;
				System.out.println("The keys are"+a[i]);
				current=current.next;
			}

		}
		return (K[])a;
			
		// TODO Auto-generated method stub
		
	}

	@Override
	public V getValue(K str) {
		LNode<K,V> current=head;
		while((!(current.Key.equals(str))))
		{
			if(current.next==null)
			{
				return null;
			}
			current=current.next;
		}
		if(current.Key.equals(str))
		{
			return current.Value;
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	@Override
	public void insert(K key, V value) {
		LNode<K,V> newnode=new LNode<K,V>(key,value);
		if(isEmpty())
		{
			head=newnode;
		}
		else
		{
			LNode<K,V> current=head;
			int flag=1;
			while(current!=null)
			{
				if(current.Key.equals(key))
				{
					flag=0;
					break;
				}
				else
				{
					flag=1;
					
				}
				current=current.next;
			}
			if(flag==0)
			{
				System.out.println("Inserting values");
				current.Value=value;
			}
			else
			{
				newnode.next=head;
				head=newnode;
			}
			
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		LNode<K,V> current=head;
		LNode<K,V> previous=head;
		if(current.Key.equals(key))
		{
			if(current==head)
			{
				head=current.next;
				return;
			}
		}
		while(!(current.Key.equals(key)))
		{
			if(current.next==null)
			{
				System.out.println("not delete");
				return;
			}
			//System.out.println("key is"+current.Key+"with"+key);
			previous=current;
			current=current.next;
			//System.out.println("sdsa");
		}
		
			
				previous.next=current.next;
			
		}
	}


