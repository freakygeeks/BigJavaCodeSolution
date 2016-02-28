package gol.data;

public class InefficientBooleanMap extends AbstractMap {
	
	protected boolean[][] map;

	public InefficientBooleanMap(int width, int height) {
		width = width > MIN_WIDTH ? width : DEFAULT_WIDTH;
		height = height > MIN_HEIGHT ? height : DEFAULT_HEIGHT;
		
		initializeMap(width, height);
	}
	
	@Override
	protected void initializeMap(int width, int height) {
		map = new boolean[width][height];
	}
	
	protected int countNeighbours(int x, int y) {
		int count = 0;
		
		// top neighbours
		if (x > 0 && y > 0 && map[x-1][y-1])
			count++;
		if (y > 0 && map[x][y-1])
			count++;
		if (x < getWidth() - 1 && y > 0 && map[x+1][y-1])
			count++;
		
		// left and right neighbours
		if (x > 0 && map[x-1][y])
			count++;
		if (x < getWidth() - 1 && map[x+1][y])
			count++;
		
		// bottom neighbours
		if (x > 0 && y < getHeight() - 1 && map[x-1][y+1])
			count++;
		if (y < getHeight() - 1 && map[x][y+1])
			count++;
		if (x < getWidth() - 1 && y < getHeight() - 1 && map[x+1][y+1])
			count++;
		
		return count;
	}

	@Override
	public void calcNextGeneration() {
		boolean[][] nextGenMap = new boolean[getWidth()][getHeight()];
		int neighbourCount;
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				neighbourCount = countNeighbours(x, y);
				nextGenMap[x][y] = neighbourCount == 3
						|| (map[x][y] && neighbourCount == 2);
			}
		}
		
		map = nextGenMap;
	}

	@Override
	public boolean get(int x, int y) {
		return map[x][y];
	}

	@Override
	public void set(int x, int y, boolean value) {
		map[x][y] = value;
	}

	@Override
	public int getWidth() {
		return map.length;
	}

	@Override
	public int getHeight() {
		return map[0].length;
	}
}
