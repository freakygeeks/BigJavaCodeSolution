//Chapter7 - Exercise P7.2

class RandomWalk 
{
	private int x; 
	private int y;
	
    RandomWalk () 
	{
    x = 0; 
    y = 0;
    } 
    
	public void moveNorth() 
	{
    y = y + 1; 
    }
	
    public void moveSouth() 
	{
    y = y - 1; 
    }
	
    public void moveEast() 
	{
    x = x + 1; 
    }
	
    public void moveWest() 
	{
    x = x - 1; 
    }
	
    public void getDrunk() 
	{
    System.out.println("Location: " + x + ", " + y); 
    } 
} 