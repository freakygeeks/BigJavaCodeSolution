//Chapter 21 - Exercise 21.13

public class BinaryTreeSmallest
{
	public Node root;
	
	public BinaryTreeSmallest()
	{
		root = null;
	}
	
	public Comparable smallest()
	{
		if (root == null)
		{
			return null;
		}
		
		else
		{
			return root.smallest();
		}
	}
	
	public void insert (Comparable obj)
	{
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		
		if (root == null)
		{
			root = newNode;
		}
		
		else
		{
			root.insertNode(newNode);
		}
	}
	
	public void print()
	{
		if (root != null)
		{
			root.printNodes();
		}
	}
	
	class Node
	{
		public Comparable data;
		public Node left;
		public Node right;
		
		public Comparable smallest()
		{
			if (left == null)
			{
				return data;
			}
			
			else
			{
				return left.smallest();
			}
		}
		
		public void insertNode (Node newNode)
		{
			if (newNode.data.compareTo(data) < 0)
			{
				if (left == null)
				{
					left = newNode;
				}
				
				else
				{
					left.insertNode(newNode);
				}
			}
			
			else
			{
				if (right == null)
				{
					right = newNode;
				}
				
				else
				{
					right.insertNode(newNode);
				}
			}
		}
		
		public void printNodes()
		{
			if (left != null)
			{
				left.printNodes();
			}
			
			System.out.println(data);
			
			if (right != null)
			{
				right.printNodes();
			}
		}
	}
}





















