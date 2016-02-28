package gol;

import gol.data.IMap;
import gol.ui.UI;

public class GameOfLife implements Runnable {
	private IMap map;
	private UI ui;
	double fps;
	
	public GameOfLife(IMap map, UI gui, double fps) {
		this.map = map;
		this.ui = gui;
		this.fps = fps;
	}
	
	public void run() {
		ui.init();
		
		long nspf;
		if (fps == 0)
			nspf = 0;
		else
			nspf = (long) (1000000000.0 / fps);
		
		long startTime, frameTime;
		do {
			startTime = System.nanoTime();
			ui.render(map);
			map.calcNextGeneration();
			frameTime = System.nanoTime() - startTime;
			if (nspf - frameTime > 0) {
				try {
					Thread.sleep((nspf - frameTime) / 1000000);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.exit(1);
				}
			}
		} while(ui.isAvailable());
		
		ui.quit();
	}
}
