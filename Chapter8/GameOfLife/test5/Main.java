package gol;

import gol.config.Configurator;
import gol.data.BooleanMap;
import gol.data.IMap;
import gol.ui.LWJGLUI;
import gol.ui.UI;

public class Main {

	public static void main(String[] args) {
		Configurator cfg = new Configurator();
		cfg.open();
		
		// HACK: using events instead of this breaks the J2DGUI
		// waiting for the user input to be finished...
		while (!cfg.areValuesReady()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		IMap map = new BooleanMap(cfg.getWidthValue(), cfg.getHeightValue());
		map.randomize();
		UI ui = new LWJGLUI(cfg.getWidthValue(), cfg.getHeightValue(), 
				cfg.getFieldSizeValue());
		GameOfLife gol = new GameOfLife(map, ui, cfg.getFpsValue());
		gol.run();
	}
}
