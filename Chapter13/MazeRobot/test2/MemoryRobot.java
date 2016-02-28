import java.util.ArrayList;

public class MemoryRobot extends Robot {

	boolean deadEndTracking;

	public MemoryRobot(Robot r) {
		this.x = r.getX();
		this.y = r.getY();
		this.dx = r.dx;
		this.dy = r.dy;
		this.direction = r.direction;
		this.image = r.image;
		deadEndTracking = false;
	}

	public void move(Maze m) {

		if (checkIfFinished(m))
			return;

		checkIfAtDeadEnd(m);

		if (isAtJunction(m))
			deadEndTracking = false;

		if (isAtJunction(m)) {
			makeDecisionAtJunction(m);
		} else {

			if (!m.isValid(forwardLocation()))

				if (m.isValid(rightLocation())) {
					spinClockwise();

				} else {
					spinCounterClockwise();

				}

		}

		System.out.println(nextMove() + "   " + deadEndTracking);

		blankCurrentLocation(m);
		moveForward();
		System.out.println(getX() + "," + getY());
		checkIfFinished(m);
		m.setXY(getX(), getY(), toString());
	}

	private void makeDecisionAtJunction(Maze m) {
		ArrayList<Integer> primaryChoices = new ArrayList<Integer>();
		ArrayList<Integer> secondaryChoices = new ArrayList<Integer>();

		if (m.isValid(forwardLocation())) {

			if (m.getXY(forwardLocation()) == ' ')
				primaryChoices.add(direction);
			else
				secondaryChoices.add(direction);
		}
		if (m.isValid(rightLocation())) {
			if (m.getXY(rightLocation()) == ' ')
				primaryChoices.add((direction + 1) % 4);
			else
				secondaryChoices.add((direction + 1) % 4);
		}
		if (m.isValid(leftLocation())) {
			if (m.getXY(leftLocation()) == ' ')
				primaryChoices.add((direction + 3) % 4);
			else
				secondaryChoices.add((direction + 3) % 4);
		}
		if (primaryChoices.size() == 0) {
			int randInt = (int) (Math.random() * (secondaryChoices.size()));
			setDirection(secondaryChoices.get(randInt));
		} else {
			int randInt = (int) (Math.random() * (primaryChoices.size()));
			setDirection(primaryChoices.get(randInt));
		}

	}

	private void blankCurrentLocation(Maze m) {

		if (deadEndTracking)
			m.setXY(getX(), getY(), "*");
		else
			m.setXY(getX(), getY(), "@");
	}

	private void checkIfAtDeadEnd(Maze m) {
		if (isAtDeadEnd(m)) {
			deadEndTracking = true;
			spinAround();
		}
	}

	private boolean checkIfFinished(Maze m) {
		if (m.isExitLocation(getX(), getY())) {
			isFinished = true;
			return isFinished;
		}

		return false;
	}

	public boolean isAtJunction(Maze m) {

		int numChoices = 0;

		if (m.isValid(forwardLocation()))
			numChoices++;

		if (m.isValid(rightLocation()))
			numChoices++;

		if (m.isValid(leftLocation()))
			numChoices++;

		return (numChoices > 1);
	}

	public boolean isAtDeadEnd(Maze m) {
		return m.getXY(forwardLocation()) == '*'
				&& m.getXY(rightLocation()) == '*'
				&& m.getXY(leftLocation()) == '*';
	}

}
