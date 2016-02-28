import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Maze extends JFrame {

	JTextPane display;

	JScrollPane displayWrapper;

	JPanel jp;

	private String fileName;

	private int fileLocation = -1;

	static final int LOADFROMJAR = 0;

	static final int LOADFROMFILE = 1;

	static final int RUNFROMAPPLET = 1;

	static final int RUNFROMAPPLICATION = 2;

	private int runningMode;

	private JMenuBar menuBar;

	private JMenu fileMenu;

	private JMenuItem openMenuItem;

	private JMenuItem go;

	private JMenuItem exit;

	private JMenuItem reset;

	private JMenu optionMenu;

	private JMenuItem debugOption;

	private JMenuItem randomR;
	private JMenuItem rightHandR;
	private JMenuItem memoryR;

	private JMenu helpMenu;

	private JMenuItem help;

	private JMenuItem about;

	public BufferedImage imgBuffer;

	public Image wall, trail, floor;

	public String textMaze;

	public int height, width;

	public RunMazeThread rmt;

	public double zoom = 1.5;
	public boolean DEBUG = false;
	// public RandomRobot rob;
	public MemoryRobot rob;
	// public RightHandRobot rob;

	public RunMazeThread mazeThread;

	/**
	 * @param file
	 *            that you want the maze to be initialized with eg. "maze2.txt"
	 */
	public Maze(String file) {
		super("Super Maze Game");

		runningMode = RUNFROMAPPLICATION;

		initMenu();
		initImages();

		initDrawingPanel();

		add(jp);

		initMaze(file);
		fileName = file;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Initializes the drawing panel that the maze will be drawn on
	 */
	private void initDrawingPanel() {
		jp = new JPanel() {

			public void paint(Graphics g) {
				g.drawImage(
						imgBuffer.getScaledInstance(
								(int) (imgBuffer.getWidth() * zoom),
								(int) (imgBuffer.getHeight() * zoom),
								Image.SCALE_FAST), 0, 0, this);

			}
		};
	}

	/**
	 * Sets the JFrames dimensions to match the
	 */
	private void setFrameDimensions() {
		setSize(imgBuffer.getWidth() + 10, imgBuffer.getHeight() + 48);
		centerWindow();
	}

	/**
	 * Initializes the buffered image to the current size of the maze assuming
	 * 16x16px tiles
	 */
	private void initBufferedImage() {
		imgBuffer = new BufferedImage((int) (zoom * ((width - 1) * 16)),
				(int) (zoom * (height * 16)), BufferedImage.TYPE_INT_RGB);
	}

	/**
	 * Loads all of the images that will be used in the maze except for the
	 * robots images
	 */
	private void initImages() {
		wall = Toolkit.getDefaultToolkit().createImage("wall.gif");
		trail = Toolkit.getDefaultToolkit().createImage("trail.gif");
		floor = (Image) (new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB));
		floor.getGraphics().setColor(Color.WHITE);
		floor.getGraphics().fillRect(0, 0, 16, 16);
	}

	/**
	 * Uses the default toolkit to center the frame in the middle of the screen
	 */
	private void centerWindow() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((int) (d.width - getWidth()) / 2,
				(int) (d.height - getHeight()) / 2);
	}

	/**
	 * Handles all of the manual drawing of the maze using the current maze and
	 * robot parameters
	 */
	private void drawInitialMaze() {
		Graphics g = imgBuffer.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, (width - 1) * 16, height * 16);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {

				char c = textMaze.charAt(y * width + x);

				if (isARobotChar(c)) {
					System.out.println(rob.direction);
					g.drawImage(rob.getRealImage(), x * 16, y * 16, this);
				}
				if (c == '*') {
					g.drawImage(wall, x * 16, y * 16, this);
				} else if (c == ' ' || c == '\n') {
					g.drawImage(floor, x * 16, y * 16, this);
				}

			}
		}
	}

	/**
	 * A method for checking whether or not a char is a robot or not
	 * 
	 * @param c
	 *            is the char that you are checking
	 * @return returns true if it is a possible robot, accounts for all
	 *         directions
	 */
	private boolean isARobotChar(char c) {
		return (c == '>' || c == '<' || c == '^' || c == 'V' || c == 'v');
	}

	public boolean isExitLocation(int x, int y) {
		boolean flag = false;

		if ((x == 0 || x == width - 1 || y == 0 || y == height - 1))
			flag = (getXY(x, y) == ' ');

		return flag;
	}

	/**
	 * Given unformatted text of a maze. parseMaze will take the necessary
	 * meausurements, width and height and also initialize the robot that will
	 * be currently running the maze
	 * 
	 * @param s
	 *            the unformatted text maze
	 */
	private void parseMaze(String s) {

		StringTokenizer st = new StringTokenizer(s, "\n");

		height = 0;

		while (st.hasMoreTokens()) {
			textMaze += st.nextToken() + "\n";
			height++;
		}
		width = textMaze.indexOf("\n") + 1;

		// rob = new RandomRobot(getStartingRobotInfo());
		// rob = new RightHandRobot(getStartingRobotInfo());
		System.out.println(textMaze);
		rob = new MemoryRobot(getStartingRobotInfo());
		System.out.println(rob.nextMove());
	}

	/**
	 * Extracts the starting info of the current robot in the maze.
	 * 
	 * @return returns a robot that represent the location and direction of the
	 *         starting robot in the maze
	 */
	private Robot getStartingRobotInfo() {
		Robot r = new Robot();

		for (int i = 0; i < textMaze.length(); i++)
			if (isARobotChar(textMaze.charAt(i))) {

				r.image = textMaze.charAt(i) + "";
				r.setDirection(r.image);
				r.setX(i % width);
				r.setY((i - r.getX()) / width);
			}
		return r;
	}

	/**
	 * Main method of Maze.
	 * 
	 * @param args
	 *            arguments such as the file you wish to open
	 */
	public static void main(String args[]) {
		Maze m;
		if (args.length > 0)
			m = new Maze(args[0]);
		else
			m = new Maze("maze1.txt");
		m.runningMode = Maze.RUNFROMAPPLICATION;
		m.drawInitialMaze();
//		m.runningMode = Maze.RUNFROMAPPLICATION;
		// m.rmt = new RunMazeThread(m, 200);
		// m.rmt.start();
	}

	/**
	 * Method for debugging that prints the current neighbors of the robot
	 * 
	 * @return a string representation of the current neighbors of the robot
	 */
	public String printNeighbors() {

		String s = rob.nextMove() + "\n";

		s += "To the forward is " + getXY(rob.forwardLocation()) + "\n";
		s += "To the right is " + getXY(rob.rightLocation()) + "\n";
		s += "To the left is " + getXY(rob.leftLocation()) + "\n";

		return s;
	}

	/**
	 * Updates the maze, moves the robot appropriately and redraws the maze
	 */
	public void updateMaze() {
		rob.move(this);
		jp.repaint();
	}

	/**
	 * A helper method to set a location (x,y) in the maze to a given String.
	 * Works on two levels, textually and graphically
	 * 
	 * @param x
	 *            the x value 0 counted
	 * @param y
	 *            the y value 0 counted
	 * @param s
	 *            the String to set (x,y) in the maze to
	 */
	public void setXY(int x, int y, String s) {
		setXYText(x, y, s);
		setXYGraphical(x, y, s);
	}

	/**
	 * Draws the supplied image the given location
	 * 
	 * @param x
	 *            the x value 0 counted
	 * @param y
	 *            the y value 0 counted
	 * @param s
	 *            the String to set(x,y) in the maze to corresponds to a
	 *            different image depending on the supplied string
	 */
	private void setXYGraphical(int x, int y, String s) {
		Graphics g = imgBuffer.getGraphics();
		if (s.equals("*")) {
			if (DEBUG == true)
				g.drawImage(wall, x * 16, y * 16, this);
			else
				g.drawImage(floor, x * 16, y * 16, this);
		} else if (s.equals(" ")) {
			g.drawImage(floor, x * 16, y * 16, this);
		} else if (s.equals("@")) {
			if (DEBUG == true)
				g.drawImage(trail, x * 16, y * 16, this);
			else
				g.drawImage(floor, x * 16, y * 16, this);
		} else {
			g.drawImage(rob.getRealImage(), x * 16, y * 16, this);
		}
	}

	/**
	 * A method to set an (x,y) location in the maze to a given String
	 * 
	 * @param x
	 *            the x value location 0 counted
	 * @param y
	 *            the y value location 0 counted
	 * @param s
	 *            the String that is going to be inserted into the maze
	 */
	private void setXYText(int x, int y, String s) {
		if (x < 0 || x > width || y < 0 || y > height)
			System.err.println("setXY is being used incorrectly");

		String temp = "";

		temp = textMaze.substring(0, (x + width * y)) + s
				+ textMaze.substring(x + width * y + 1);

		textMaze = temp;
	}

	/**
	 * A method that returns the char at a given location (x,y)
	 * 
	 * @param x
	 *            the x value location 0 counted
	 * @param y
	 *            the y value location 0 counted
	 * @return the char at location (x,y)
	 */
	public char getXY(int x, int y) {
		return textMaze.charAt(x + y * width);
	}

	/**
	 * A method that returns the char at a given location (Point)
	 * 
	 * @param p
	 *            the location that you wish to retrieve the char from
	 * @return the char at the location (Point)
	 */
	public char getXY(Point p) {
		return textMaze.charAt((int) (p.getX() + p.getY() * width));
	}

	/**
	 * A method for debugging that prints out info about the maze and the
	 * contained robot
	 * 
	 * @return a String of info about the maze and the containing robot
	 */
	public String printVerbose() {
		String s = "";
		s = "<Maze>\n" + width + "x" + height + "\n" + "Rob is at ("
				+ rob.getX() + "," + rob.getY() + ")";
		return s;
	}

	/**
	 * A method to determine whether a given location (x,y) is valid to move to
	 * or not
	 * 
	 * @param x
	 *            the x location 0 counted
	 * @param y
	 *            the y location 0 counted
	 * @return true if space is not a wall
	 */
	public boolean isValid(int x, int y) {
		return (getXY(x, y) != '*' && getXY(x, y) != '\n');
	}

	/**
	 * A method to determine whether a given location (Point) is valid to move
	 * to or not
	 * 
	 * @param p
	 * @return true if given location is not a wall
	 */
	public boolean isValid(Point p) {
		return (getXY(p.x, p.y) != '*' && getXY(p.x, p.y) != '\n');
	}

	/**
	 * Initializes the JMenuBar and all of it's components
	 */
	private void initMenu() {
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		openMenuItem = new JMenuItem("Open");
		go = new JMenuItem("Run the maze!");
		exit = new JMenuItem("Quit");
		reset = new JMenuItem("Reset Board");

		optionMenu = new JMenu("Options");
		debugOption = new JCheckBoxMenuItem("Enable Debugging");

		helpMenu = new JMenu("Help");
		help = new JMenuItem("Help Contents");
		about = new JMenuItem("About");

		fileMenu.add(openMenuItem);
		fileMenu.add(reset);
		fileMenu.add(go);
		fileMenu.addSeparator();
		fileMenu.add(exit);

		optionMenu.add(debugOption);

		helpMenu.add(help);
		helpMenu.add(about);

		menuBar.add(fileMenu);
		menuBar.add(optionMenu);
		menuBar.add(helpMenu);

		this.setJMenuBar(menuBar);

		openMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(runningMode);

				try {
					ArrayList<String> fileList;

					if (runningMode == Maze.RUNFROMAPPLET) {
						fileList = extractFileNames();
					} else {
						fileList = extractLocalFileNames();
					}

					String s = (String) JOptionPane
							.showInputDialog(
									jp,
									"Please choose the board you would like to open from the choices below",
									"Open Board", JOptionPane.PLAIN_MESSAGE,
									null, fileList.toArray(), null);

					if (s != null) {
						initMaze(s);
					}

				} catch (IOException exe) {
					System.err.println(exe.getMessage());
				} catch (URISyntaxException exe2) {
					System.err.println(exe2.getMessage());
				}
			}

			private ArrayList<String> extractLocalFileNames()
					throws IOException, URISyntaxException {

				ArrayList<String> fileList = new ArrayList<String>();

				ZipFile signSudoku;

				URL url = new URL(
						"jar:file:signedMaze.jar!/META-INF/MANIFEST.MF");
				JarURLConnection jarConnection = (JarURLConnection) url
						.openConnection();

				String manList = loadFromJar((InputStream) jarConnection
						.getContent());

				StringTokenizer in = new StringTokenizer(manList);

				while (in.hasMoreTokens()) {
					String s = in.nextToken();
					if (s.substring(s.length() - 3).equals("txt")
							&& !s.equals("readme.txt")
							&& !s.equals("readme2.txt"))
						fileList.add(s);
				}
				return fileList;

			}

			private ArrayList<String> extractFileNames() throws IOException,
					URISyntaxException {

				ArrayList<String> fileList = new ArrayList<String>();

				ZipFile signSudoku;

				URL url = new URL(
						"jar:http://www.students.bucknell.edu/tak017/Java%20Projects/signSudoku.jar!/META-INF/MANIFEST.MF");
				JarURLConnection jarConnection = (JarURLConnection) url
						.openConnection();

				String manList = loadFromJar((InputStream) jarConnection
						.getContent());

				StringTokenizer in = new StringTokenizer(manList);

				while (in.hasMoreTokens()) {
					String s = in.nextToken();
					if (s.substring(s.length() - 3).equals("txt")
							&& !s.equals("readme.txt")
							&& !s.equals("readme2.txt"))
						fileList.add(s);
				}
				return fileList;
			}
		});

		reset.setEnabled(false);

		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initMaze(fileName);
			}
		});

		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String delay = JOptionPane
						.showInputDialog(
								"Enter the delay would like to add to the solver (0-50 milliseconds)",
								"0");
				runTheMaze(delay);
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (runningMode == Maze.RUNFROMAPPLICATION)
					System.exit(0);
				else if (runningMode == Maze.RUNFROMAPPLET)
					dispose();
			}
		});

		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog((JMenuItem) e.getSource(), Maze
						.helpMenuText(), "About",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		about.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog((JMenuItem) e.getSource(), Maze
						.aboutMenuText(), "About",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}

	/**
	 * A method to start the maze running thread
	 * 
	 * @param delay
	 *            the string value supplied by the user
	 */
	protected void runTheMaze(String delay) {
		long iDelay = parseDelayInput(delay);
		rmt = new RunMazeThread(this, iDelay);
		rmt.start();
	}

	/**
	 * A method to parse the input from a user for delay time
	 * 
	 * @param delay
	 *            a String of user input
	 * @return the modified inpnut of the user in int form
	 */
	private long parseDelayInput(String delay) {

		if (delay == null || delay.equals(""))
			delay = "" + 0;

		int iDelay = Integer.parseInt(delay);

		if (iDelay > 1000)
			iDelay = 1000;
		else if (iDelay < 0)
			iDelay = 0;

		return iDelay;
	}

	/**
	 * @return A string with all of the text to be displayed in the Help menu.
	 */
	public static Object helpMenuText() {
		return "For more information on our program goto www.students.bucknell.edu/tak017/ \n";
	}

	/**
	 * @return A string with all of the text to be displayed in the About menu.
	 */
	protected static Object aboutMenuText() {
		return "Maze is a collaborative project for CS204 at Bucknell University\nIt was written by Tommy Krisch and Brian\n\nCurrent version is 0.5";
	}

	/**
	 * A method exclusivley used to retreive the manifest from a given Jar File
	 * 
	 * @param input
	 *            the InputStream of the manifest file of the jar
	 * @return a string that is the manifest for the given jar
	 * @throws IOException
	 */
	private String loadFromJar(InputStream input) throws IOException {

		ByteArrayOutputStream output = new ByteArrayOutputStream(1024);

		byte[] buffer = new byte[512];

		int bytes;

		while ((bytes = input.read(buffer)) > 0) {
			output.write(buffer, 0, bytes);
		}

		input.close();
		fileLocation = Maze.LOADFROMJAR;
		reset.setEnabled(true);

		return new String(output.toByteArray());
	}

	/**
	 * A method to load a text resource from a jar
	 * 
	 * @param jarName
	 *            the name of the jar to open. This includes the location e.g.
	 *            locally "bin/maze.jar" or "www.students.bucknell/maze.jar"
	 * @param file
	 *            the name of the text file you wish to retrieve from the jar
	 * @return
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public String getTextFromJar(String jarName, String file)
			throws MalformedURLException, IOException {

		System.out.println(jarName + "   " + file);

		URL url;

		if (runningMode == Maze.RUNFROMAPPLET) {
			url = new URL("jar:http://" + "!/" + file);
		} else {
			url = new URL("jar:file:" + jarName + "!/" + file);
		}

		JarURLConnection jarConnection = (JarURLConnection) url
				.openConnection();

		InputStream input = jarConnection.getInputStream();

		ByteArrayOutputStream output = new ByteArrayOutputStream(1024);

		byte[] buffer = new byte[512];

		int bytes;

		while ((bytes = input.read(buffer)) > 0) {
			output.write(buffer, 0, bytes);
		}

		input.close();
		fileLocation = Maze.LOADFROMJAR;
		reset.setEnabled(true);

		return new String(output.toByteArray());
	}

	/**
	 * Handles all the initializing of the maze
	 * 
	 * @param fileName
	 *            the name of the file you wish use e.g. "maze1.txt"
	 */
	private void initMaze(String fileName) {

		textMaze = "";
		String maze = "";

		try {
			if (runningMode == Maze.RUNFROMAPPLICATION)
				maze = getTextFromJar("signedMaze.jar", fileName);
			else
				maze = getTextFromJar(
						"http:www.students.bucknell.edu/tak017/Java%20Projects/signedMaze.jar",
						fileName);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		this.fileName = fileName;

		parseMaze(maze);
		initBufferedImage();
		setFrameDimensions();
		centerWindow();
		drawInitialMaze();
	}
}
