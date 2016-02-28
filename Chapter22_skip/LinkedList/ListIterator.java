//Chapter 22 - Example 22.2

public interface ListIterator<E>
{
	E next();
	boolean hasNext();
	void add (E element);
	void remove();
	void set (E element);
}