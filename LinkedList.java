public class LinkedList<T> implements ListInterface<T> 
//https://www.cs.cmu.edu/~adamchik/15-121/lectures/Linked%20Lists/linked%20lists.html
// Help from: Professor Summerville, Nicholas, Meet
// https://stackoverflow.com/questions/21940032/linked-lists-head-and-tail-references
{
		
	public Node<T> head;
	public Node<T> tail;
	public int size;

	
		public class Node<T>
	{
		public T data;
		public Node<T> next;
	

		public Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}
	}
	


  public void add(T data, int index) throws ListException
  {
	
	// SIZE IS NOT SupPOSED TO BE ZERo
	if(index == 0)
	{ //add to empty list
		head = new Node<T>(data, head);
		if(size == 0)
		{
			tail = head;
		}
		size++;
		//System.out.println("add " + data + " to index 0"); //test
	}
	else if(size > 0 && index == size)
	{
		//add to the end
		//tail's next should be pointing to null
		tail.next = new Node<T>(data, null);
		
		tail = tail.next;
		
		size++;
		//System.out.println("add " + data + " to index " + size()); //test
	}
	else if(index < size)
	{
		if(index < 0)
		{
			throw new ListException("Can't add at negative number");
		}
			
		Node<T> current = head;
		while(index > 1)
		{
			current = current.next;
			index--;
		}
		current.next = new Node<T>(data, current.next);
		
		size++;
		
	}
	else if(index > size)
	{
		
		//figure out how to throw it
		throw new ListException("Tried to add too far ahead in index " + index);
	}
	
	//WHAT IS SIZE
		
		//	System.out.println("Size: " + size); //test

	}
	
  

  public T get(int index)
  {
	Node<T> current = head;
	if(index == 0 && size > 0)
	{
		//System.out.println("Getting at index " + index + ", size " + size); //test
		return head.data;
	}
	else if(index < 0)
	{
		throw new ListException("BIG OOPSIE");
	}
	else if(index == size)
	{
		//System.out.println("Getting at index " + index + ", size " + size); //test
		return tail.data;
	}
	else if(index > 0 && index <= size - 1)
	{
		//System.out.println("Getting at index " + index + ", size " + size); //test
		while(index > 0)
		{
		
			current = current.next;
			index--;
		}
	
	}
	else if(index >= size)
	{
		throw new ListException("Tried to get at an element that doesn't exist");
	}
	
	return current.data;
  }

  public void remove(int index) throws ListException
  {
	  
	Node<T> current = head;
	if(index < 0)
	{
		throw new ListException("Nothing in the list");
	}
	else if(index >= size)
		//try to remove a bigger index 
	{
		if(size == 0)
		{
			throw new ListException("Nothing in this list.");
		}
		else
		{
			throw new ListException("Index is out of bounds");
		}
	}
	else if(index == size - 1 && index != 0)
		//remove from last
	{
		//System.out.println("removing at the end of the list"); //test
		current = head;
			while(index > 1)
			{
			current = current.next;
			index--;
			}
		tail = current;
		tail.next = null;
		size--;
	}
	else if(index > 0 && index < size - 1 )
	{
		//System.out.println("Regular remove"); //test
		while(index > 1)
		{
			current = current.next;
			index--;
			//keeping track of size 
			//System.out.println(size + "" + index); //test
		}
		current.next = current.next.next;
		size--;
	}
	//remove from 0
	else if(index == 0)
	{
	
		head = head.next;
		size--;
	}
	else 
	{
		throw new ListException("Tried to remove something that doesn't exist at index " + index);
	}

		//where size was before, decremented
		
		//System.out.println("Size: " + size); //test
	
	}

	
 
  

  public int size()
  {
	  //GET METHOD 
	return size;
  }

  public String toString()
  {
	  //iterate through whole list to print
	  Node<T> current = head;
	  String toReturn = "";
	  for(int i = 0; i < size(); i++)
	  {
		toReturn = toReturn + current.data + " ";
		
		current = current.next;
	  }
	  
	  return toReturn;
  }
}
 