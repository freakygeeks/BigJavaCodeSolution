//Chapter 21 - Exercise 21.15

public class PrePostOrder
{
	private Node root;
	
	public PrePostOrder()
	{
		root = null;
	}
	
	public void insert (Comparable obj)
	{
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		
		if (root == null)
		{
			root =  newNode;
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
	
	
	public void printPreOrder()
	{
		if (root != null)
		{
			root.printPreOrder();
		}
	}
	
	public void printPostOrder()
	{
		if (root != null)
		{
			root.printPostOrder();
		}
	}
	
	class Node
	{
		public Comparable data;
		public Node left;
		public Node right;
		
		public void insertNode(Node newNode)
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
		
		public void printPreOrder()
		{
			System.out.println(data);
			
			if (left != null)
			{
				left.printPreOrder();
			}
			
			if (right != null)
			{
				right.printPreOrder();
			}
		}
		
		public void printPostOrder()
		{
			if (left != null)
			{
				left.printPostOrder();
			}
			
			if (right != null)
			{
				right.printPostOrder();
			}
			
			System.out.println(data);
		}
	}
}



















