package gol.data;

public interface IMap {
	public static final int MIN_WIDTH = 3;
	public static final int MIN_HEIGHT = 3;
	public static final int DEFAULT_WIDTH = 160;
	public static final int DEFAULT_HEIGHT = 90;
	public static final double DEFAULT_RATIO = 0.5;
	
	public void calcNextGeneration();
	
	public boolean get(int x, int y);
	public void set(int x, int y, boolean value);
	
	public int getWidth();
	public int getHeight();
	
	public void setMapData(IMap map) throws IllegalArgumentException;
	public void randomize();
	public void randomize(double ratio);
}
