public class RightHandRobot extends Robot {

	public RightHandRobot(Robot r) {
		super(r);
	}

	public void move(Maze m) {

		m.setXY(getX(), getY(), " ");

		if (m.getXY(forwardLocation()) == ' ') {

			if (m.getXY(rightLocation()) == ' ') {
				moveForward();
			} else {
				if (m.getXY(rightLocation()) == '*') {
					moveForward();
					if (m.getXY(rightLocation()) != '*') {
						spinClockwise();
					}
				}
			}

		} else {

			if (m.getXY(rightLocation()) == '*'
					&& m.getXY(leftLocation()) == '*') {
				spinAround();
				moveForward();
			} else if (m.getXY(rightLocation()) == '*') {
				spinCounterClockwise();
				moveForward();
			} else if (m.getXY(leftLocation()) == '*') {
				spinAround();
				moveForward();
			}
		}

		if (m.isExitLocation(getX(), getY()))
			isFinished = true;

		m.setXY(getX(), getY(), toString());
	}
}
