package searchengine.dictionary;

import java.io.Serializable;
class Node<String,V> 
{
    String key;
    V value;
    Node<String,V> parent;
    Node<String,V> left;
    Node<String,V> right;
    
    public Node(String k,V val)
    {
        key=k;
        value=val;
    }
}


public class BSTDictionary <K extends Comparable<K>, V> implements DictionaryInterface <K,V>,Serializable
{

	Node<String,V> root;
        String a[];
        int size=0;
        int i=0;
        public BSTDictionary()          
        {
            root=null;
        }
    
        public boolean isEmpty()          
        {
            return root==null;
        }
        
        
        public String[] traverse(Node<String,V> root)      
        {
            if(root!=null)                                   
            {
                traverse(root.left);                       
                a[i++]=root.key;                           
                traverse(root.right);                     
            }
                return a;
        }
        
           
        @Override
	public K[] getKeys() 
        {
		// TODO Auto-generated method stub
                if(isEmpty())
                {
                    System.out.println(" Binary tree is empty ");  
                    return null;
                }
                else
                {
                i=0;                                   
                a=new String[size];                    
                a=traverse(root);                      
		return (K[])a;                                 
		}
	}

	@Override
	public V getValue(K str)
	{
		// TODO Auto-generated method stub
            Node<String,V> cur=root;  
            String ch=(String)str;
            while(cur!=null)
            {
                if((ch.compareTo(cur.key))>0)
                {
                    
                    cur=cur.right;                   
                }
                else if((ch.compareTo(cur.key))<0)
                {
                    
                    cur=cur.left;                           
                    }
                else
                {
                    return cur.value;                         
                    }
            }
                
		return null;
	}

	
        
        @Override
	public void insert(K key, V value) {
		// TODO Auto-generated method stub
            
            root=insert((String)key,root,value);
		
	}
        
        public Node<String,V> insert(String ke,Node<String,V> t,V val)
        {
            if(t==null)
            {
                size++;
                return new Node<String,V>(ke,val);
            }
            int result=ke.compareTo(t.key);
            if(result<0)
            {
                t.left=insert(ke,t.left,val);
            }
            else if(result>0)
            {
                t.right=insert(ke,t.right,val);
            }
            else
            {
            	t.value=val;
            }
           
               return t;
        }

	/*public Node<String,V> find(String ke)                  
        {
            Node<String,V> cur=root;
            
            while(cur!=null)
            {
                if((ke.compareTo(cur.key))>0)
                {
                    
                    cur=cur.right;
                }
                else if((ke.compareTo(cur.key))<0)
                {
                    
                    cur=cur.left;
                }
                else
                {
                    return cur;
                }
            }
                
		return null;
        }*/
        
        public Node<String,V> successor(Node<String,V> pre)         // To get successor of key for deletion
        {
            Node<String,V> cur=pre;
            if(cur.right!=null)
            {
                cur=cur.right;
            
            while(cur.left!=null)
            {
                cur=cur.left;
            }
                return cur;
            }
            else
            {
                while(cur.parent!=null && cur.parent.right==cur)
                {
                    cur=cur.parent;
                }
                    return cur.parent;
            }
            
        }
        
        
        @Override
	public void remove(K key) {
		// TODO Auto-generated method stub
            Node<String,V> cur=remove((String)key,root);
             if(cur!=null)
             {
                 size--;
             }
		
	}
        
        public Node<String,V> remove(String ke,Node<String,V> t)
        {
            if(t==null)
            {
                System.out.println(" The required value doesnot exist in the bucket ");
                return t;
            }
            int result=ke.compareTo(t.key);
            if(result<0)
            {
                t.left=remove(ke,t.left);
            }
            else if(result>0)
            {
                t.right=remove(ke,t.right);
            }
            else if(t.left!=null && t.right!=null)
            {
                t.key=findMin(t.right).key;
                t.right=remove(t.key,t.right);
            }
            else
            {
                t=(t.left!=null)?t.left:t.right;
            }
                return t;
        }
        
        public Node<String,V> findMin(Node<String,V> t)
        {
            Node<String,V> cur=t;
            while(cur.left!=null)
            {
                cur=cur.left;
            }
            return cur;
        }

		@Override
		public int noofkeys() {
			// TODO Auto-generated method stub
			return 0;
		}

}