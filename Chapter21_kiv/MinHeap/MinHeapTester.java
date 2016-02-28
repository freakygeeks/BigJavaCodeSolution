//Chapter 21 - Example 21.9

public class MinHeapTester
{
	public static void main (String[] args)
	{
		//use heap as priority queue
		MinHeap q = new MinHeap();
		q.add(new WorkOrder(3, "Shampoo carpets"));
		q.add(new WorkOrder(7, "Empty trash"));
		q.add(new WorkOrder(8, "Water plant"));
		q.add(new WorkOrder(10, "Remove pencil"));
		q.add(new WorkOrder(6, "Replace light bulb"));
		q.add(new WorkOrder(1, "Fix broken sink"));
		q.add(new WorkOrder(9, "Clean coffee maker"));
		q.add(new WorkOrder(2, "Order cleaning supplies"));
		
		while (q.size() > 0)
		{
			System.out.println(q.remove());
		}
	}
}