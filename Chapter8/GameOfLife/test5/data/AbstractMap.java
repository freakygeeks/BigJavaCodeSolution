package gol.data;

import java.util.Random;

public abstract class AbstractMap implements IMap {
	protected abstract void initializeMap(int width, int height);
	
	@Override
	public void setMapData(IMap map) throws IllegalArgumentException {
		if (map == null)
			throw new IllegalArgumentException("Given map was null");
		if (map.getWidth() < MIN_WIDTH)
			throw new IllegalArgumentException(
					"Given map had invalid width: " + map.getWidth());
		if (map.getHeight() < MIN_HEIGHT)
			throw new IllegalArgumentException(
					"Given map had invalid height: " + map.getHeight());
		
		initializeMap(map.getWidth(), map.getHeight());
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
				this.set(x, y, map.get(x,y));
			}
		}
	}

	@Override
	public void randomize() {
		randomize(DEFAULT_RATIO);
	}

	@Override
	public void randomize(double ratio) {
		Random random = new Random();
		for (int x = 0; x < getWidth(); x++) {
			for (int y = 0; y < getHeight(); y++) {
				set(x, y, random.nextDouble() > ratio);
			}
		}
	}
}
