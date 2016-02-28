//Chapter 21 - Example 21.5

public class BinarySearchTree
{
	private Node root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	//insert a new node into the tree
	public void add (Comparable obj)
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
			root.addNode(newNode);
		}
	}
	
	//tries to find an object in the tree
	public boolean find(Comparable obj)
	{
		Node current = root;
		while (current != null)
		{
			int d = current.data.compareTo(obj);
			if (d == 0)
			{
				return true;
			}
			
			else if (d > 0)
			{
				current = current.left;
			}
			
			else
			{
				current = current.right;
			}
		}
		
		return false;
	}
	
	//tries to remove an object from a tree
	public void remove (Comparable obj)
	{
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		
		while (!found && toBeRemoved != null)
		{
			int d = toBeRemoved.data.compareTo(obj);
			if (d == 0)
			{
				found = true;
			}
			
			else
			{
				parent = toBeRemoved;
				if(d > 0)
				{
					toBeRemoved = toBeRemoved.left;
				}
				
				else
				{
					toBeRemoved = toBeRemoved.right;
				}
			}
		}
		
		if (!found)
		{
			return;
		}
		
		//toBeRemoved contains obj
		//If one the children is empty, use the other
		
		if (toBeRemoved.left == null || toBeRemoved.right == null)
		{
			Node newChild;
			
			if (toBeRemoved.left == null)
			{
				newChild = toBeRemoved.right;
			}
			
			else
			{
				newChild = toBeRemoved.left;
			}
			
			if (parent == null)
			{
				root = newChild;
			}
			
			else if (parent.left == toBeRemoved)
			{
				parent.left = newChild;
			}
			
			else
			{
				parent.right = newChild;
			}
			
			return;
		}
		
		//neither subtree is empty
		//find smallest element of the right subtree
		
		Node smallestParent = toBeRemoved;
		Node smallest = toBeRemoved.right;
		
		while (smallest.left != null)
		{
			smallestParent = smallest;
			smallest = smallest.left;
		}
		
		//smallest contains smallest child in right subtree
		//move contents unlink child
		
		toBeRemoved.data = smallest.data;
		smallestParent.left = smallest.right;		
	}
	
	//print the content of the tree in sorted order
	public void print()
	{
		if (root != null)
		{
			root.printNodes();
		}
	}
	
	//a node of tree stores a data item and references to the child nodes to the left and right
	class Node
	{
		public Comparable data;
		public Node left;
		public Node right;
		
		public void addNode(Node newNode)
		{
			if (newNode.data.compareTo(data) < 0)
			{
				if (left == null)
				{
					left = newNode;
				}
				
				else
				{
					left.addNode(newNode);
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
					right.addNode(newNode);
				}
			}
		}
		
		//print this node and all of its descendants in sorted order
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
















