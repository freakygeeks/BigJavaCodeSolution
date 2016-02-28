package gol.ui;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import gol.data.IMap;

public class LWJGLUI implements UI {
	public static final int DEFAULT_FIELD_SIZE = 5;
	public static final float COLOR_ALIVE = 0.4f;
	public static final float COLOR_DEAD = 1.0f;
	
	private int fieldSize, width, height;
	private boolean available;
	
	public LWJGLUI(int width, int height, int fieldSize) {
		this.fieldSize = fieldSize > 0 ? fieldSize : DEFAULT_FIELD_SIZE;
		this.width = width;
		this.height = height;
	}

	@Override
	public void init() {
		try {
			Display.setTitle("Game of Life");
			Display.setResizable(false);
			Display.setDisplayMode(new DisplayMode(width * fieldSize, height * fieldSize));
			Display.create();
			
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, width * fieldSize, 0, height * fieldSize, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			
			available = true;
		} catch (LWJGLException e) {
			e.printStackTrace();
			available = false;
		}
	}

	@Override
	public void render(IMap map) {
		if (Display.isCloseRequested()) {
			available = false;
			return;
		}
		
		// Clear the screen and depth buffer
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
		for (int x = 0; x < map.getWidth(); x++) {
			for (int y = 0; y < map.getHeight(); y++) {
				// Set the color of the quad, depending on cell state
				if (map.get(x, y))
					GL11.glColor3f(COLOR_ALIVE, COLOR_ALIVE, COLOR_ALIVE);
				else
					GL11.glColor3f(COLOR_DEAD, COLOR_DEAD, COLOR_DEAD);
				
				GL11.glBegin(GL11.GL_QUADS);
					GL11.glVertex2f(x * fieldSize, y * fieldSize);
					GL11.glVertex2f(x * fieldSize + fieldSize, y * fieldSize);
					GL11.glVertex2f(x * fieldSize + fieldSize, y * fieldSize + fieldSize);
					GL11.glVertex2f(x * fieldSize, y * fieldSize + fieldSize);
				GL11.glEnd();
			}
		}
		
		Display.update();
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public void quit() {
		Display.destroy();
	}

}
