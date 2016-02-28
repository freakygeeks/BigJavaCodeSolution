package gol.data;

public class BooleanMap extends AbstractMap {
	protected boolean[][] mapData;
	protected boolean[][] nextGenMapData;
	
	public BooleanMap(int width, int height) {
		// use default values if the given values are invalid
		width = width >= MIN_WIDTH ? width : DEFAULT_WIDTH;
		height = height >= MIN_HEIGHT ? height : DEFAULT_HEIGHT;
		
		// add a border around the map; makes calculations faster
		width += 2;
		height += 2;
		
		initializeMap(width, height);
	}
	
	protected void initializeMap(int width, int height) {
		mapData = new boolean[width][height];
		nextGenMapData = new boolean[width][height];
	}
	
	@Override
	public boolean get(int x, int y) {
		// I assume, that x and y are correct for efficiency reasons
		return mapData[x+1][y+1];	
	}

	@Override
	public void set(int x, int y, boolean value) {
		// I assume, that x and y are correct for efficiency reasons
		mapData[x+1][y+1] = value;
	}

	@Override
	public int getWidth() {
		return mapData.length - 2;
	}

	@Override
	public int getHeight() {
		return mapData[0].length - 2;
	}

	@Override
	public void calcNextGeneration() {
		int neighbourCount;
		
		for (int x = 1; x < mapData.length - 1; x++) {
			for (int y = 1; y < mapData[0].length - 1; y++) {
				neighbourCount = countNeighbours(x, y);
				nextGenMapData[x][y] =
						neighbourCount == 3 || (mapData[x][y] && neighbourCount == 2);
			}
		}
		
		boolean[][] tmp = mapData;
		mapData = nextGenMapData;
		nextGenMapData = tmp;
	}
	
	protected int countNeighbours(int x, int y) {
		// I assume, that x and y are correct for efficiency reasons
		int count = 0;
		int xl = x-1, xr = x+1, yt = y-1, yb = y+1;
		
		// top neighbours
		if (mapData[xl][yt])
			count++;
		if (mapData[x][yt])
			count++;
		if (mapData[xr][yt])
			count++;
		
		// left and right neighbour
		if (mapData[xl][y])
			count++;
		if (mapData[xr][y])
			count++;
		
		// bottom neightbours
		if (mapData[xl][yb])
			count++;
		if (mapData[x][yb])
			count++;
		if (mapData[xr][yb])
			count++;
		
		return count;
	}
}
