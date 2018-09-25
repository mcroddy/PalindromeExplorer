
public class Queue<T> implements QueueInterface<T>
{
	LinkedList<T> list;
	
	public Queue()
	{
		list = new LinkedList<T>();
	}

  public void enqueue(T data)
  {
	list.add(data, size());
  }

  public T dequeue()
  {
	  if(size() == 0)
	  {
		throw new QueueException("No items left in queue");
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
  
  public T peekEnd()
  {
	  return list.get(size());
  }
  
  public String toString()
  {
	return list.toString();
  }
}
