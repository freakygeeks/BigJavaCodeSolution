package gol.ui;

import gol.data.IMap;

public interface UI {
	public void init();
	public void render(IMap map);
	public boolean isAvailable();
	public void quit();
}
