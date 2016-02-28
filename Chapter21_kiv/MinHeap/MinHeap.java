//Chapter 21 - Example 21.9

import java.util.*;

public class MinHeap
{
	private ArrayList<Comparable> elements;
	
	public MinHeap()
	{
		elements = new ArrayList<Comparable>();
		elements.add(null);
	}
	
	//add new element to this heap
	public void add (Comparable newElement)
	{
		//add new leaf
		elements.add(null);
		int index = elements.size() - 1;
		
		//demote parents that are larger than a new element
		while (index > 1 && getParent(index).compareTo(newElement) > 0)
		{
			elements.set(index, getParent(index));
			index = getParentIndex(index);
		}
		
		//store new element in vacant slot
		elements.set(index, newElement);
	}
	
	//get minimum element stored in heap
	public Comparable peek()
	{
		return elements.get(1);
	}
	
	//remove minimum element from this heap
	public Comparable remove()
	{	
		Comparable minimum = elements.get(1);
		
		//remove last element
		int lastIndex = elements.size() - 1;
		Comparable last = elements.remove(lastIndex);
		
		if (lastIndex > 1)
		{
			elements.set(1, last);
			fixHeap();
		}
		
		return minimum;
	}
	
	//turns the tree back into a heap, provided only the root node violates the heap condition
	private void fixHeap()
	{
		Comparable root = elements.get(1);
		
		int lastIndex = elements.size() - 1;
		
		//promote children of removed root while they are larger than last
		
		int index = 1;
		boolean more = true;
		while (more)
		{
			int childIndex = getLeftChildIndex(index);
			
			if (childIndex <= lastIndex)
			{
				//get left child first
				Comparable child = getLeftChild(index);
				
				//use right child instead if it is smaller
				if (getRightChildIndex(index) <= lastIndex && getRightChild(index).compareTo(child) < 0)
				{
					childIndex = getRightChildIndex(index);
					child = getRightChild(index);
				}
				
				//check if larger child is smaller than root
				if (child.compareTo(root) < 0)
				{
					//promote child
					elements.set(index, child);
					index = childIndex;
				}
				
				else
				{
					//root is smaller that both children
					more = false;
				}
			}
			
			else
			{
				//no children
				more = false;
			}
		}
		
		//store root elements in vacant slot
		elements.set(index, root);
	}
	
	//return number of elements in this heap
	public int size()
	{
		return elements.size() - 1;
	}
	
	//return index of left child
	private static int getLeftChildIndex (int index)
	{
		return 2*index;
	}
	
	//return index of right child
	public static int getRightChildIndex (int index)
	{
		return 2*index+1;
	}
	
	//return the index of parent
	private static int getParentIndex (int index)
	{
		return index/2;
	}
	
	//return value of left child
	private Comparable getLeftChild (int index)
	{
		return elements.get(2*index);
	}
	
	//return value of right child
	private Comparable getRightChild (int index)
	{
		return elements.get(2*index+1);
	}
	
	//return the value of parent
	public Comparable getParent (int index)
	{
		return elements.get(index/2);
	}
}













