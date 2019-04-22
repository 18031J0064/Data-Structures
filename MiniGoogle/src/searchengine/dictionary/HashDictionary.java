package searchengine.dictionary;
import java.util.HashMap;
import java.util.Set;
public class HashDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>
{
  HashMap<K,V> ht = new HashMap<>();
	@Override
	public K[] getKeys() 
	{
		// TODO Auto-generated method stub
		String[] k = new String[ht.size()];
		Set<String> keys = (Set<String>) ht.keySet();
		int i=0;
		for(String ob:keys)
		{
			k[i++] = ob;
		}
		return (K[]) k;
	}

	@Override
	public V getValue(K str) 
	{
		// TODO Auto-generated method stub
		V s=ht.get(str);
		if(s!=null)
			return s;
		else
		return null;
	}

	@Override
	public void insert(K key, V value) 
	{
		// TODO Auto-generated method stub
		ht.put(key, value);
	}

	@Override
	public void remove(K key) 
	{
		// TODO Auto-generated method stub
		ht.remove(key);
	}

	@Override
	public int noofkeys() {
		// TODO Auto-generated method stub
		return 0;
	}

}
