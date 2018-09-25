
public class Stack<T> implements StackInterface<T>
{
	LinkedList<T> list;
	
	public Stack()
	{
		list = new LinkedList<T>();
	}
	
	public void push(T data)
	{
		list.add(data, 0);
	}
	public T pop()
	{
		if(size() == 0)
		{
			throw new StackException("Tried to remove from empty stack");
		}
		T toReturn = list.get(0);
		list.remove(0);
		return toReturn;
		
		
	}
	public int size()
	{
		
		return list.size();
	}
	public T peek()
	{
		return list.get(0);
	}
	
	public String toString()
	{
		return list.toString();
	}
}
