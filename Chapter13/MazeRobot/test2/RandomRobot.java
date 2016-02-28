public class RandomRobot extends Robot {

	public RandomRobot(Robot r) {
		super(r);
	}

	public void move(Maze m) {
		
		m.setXY(getX(), getY(), " ");
		
		do {
			setDirection((int)(Math.random() * 4));
		} while (!m.isValid(getX() + dx, getY() + dy));

		System.out.println(nextMove());
		
		moveForward();
		
		if(m.isExitLocation(getX(),getY()) )
			isFinished = true;
		
		m.setXY(getX(), getY(), toString());
	}
	
}