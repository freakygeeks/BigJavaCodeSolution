package gol.ui;

import gol.data.IMap;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.VolatileImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class J2DGUI extends JFrame implements UI {
	public static final int DEFAULT_FIELD_SIZE = 5;
	public static final Color COLOR_ALIVE = new Color(100, 100, 100);
	public static final Color COLOR_DEAD  = new Color(255, 255, 255);

	private JPanel panel;
	private boolean available;
	private int fieldSize;
	private VolatileImage buffer;

	public J2DGUI(int width, int height, int fieldSize) {
		this.fieldSize = fieldSize > 0 ? fieldSize : DEFAULT_FIELD_SIZE;
		panel = new JPanel();
		panel.setSize(width * fieldSize, height * fieldSize);
		panel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));
		add(panel);
		pack();
		createBuffer();
		setResizable(false);
		setTitle("Game of Life");

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				available = false;
			}
		});
	}
	
	@Override
	public void init() {
		setVisible(true);
		available = true;
	}

	public void render(IMap map) {
		if (map == null || !available)
			return;

		do {
			if (buffer.validate(getGraphicsConfiguration())
					== VolatileImage.IMAGE_INCOMPATIBLE)
				createBuffer();

			Graphics2D g2d = (Graphics2D) buffer.getGraphics();

			for (int x = 0; x < map.getWidth(); x++) {
				for (int y = 0; y < map.getHeight(); y++) {
					if (map.get(x, y))
						g2d.setPaint(COLOR_ALIVE);
					else
						g2d.setPaint(COLOR_DEAD);
					g2d.fillRect(x * fieldSize, y * fieldSize, fieldSize, fieldSize);
				}
			}
		} while(buffer.contentsLost());
		
		repaint();
	}

	public void createBuffer() {
		GraphicsConfiguration gc = getGraphicsConfiguration();
		buffer = gc.createCompatibleVolatileImage(getWidth(), getHeight());
	}

	@Override
	public void paint(Graphics g) {
		panel.getGraphics().drawImage(buffer, 0, 0, this);
	}

	@Override
	public void update(Graphics g) {
		this.paint(g);
	}

	@Override
	public boolean isDoubleBuffered() {
		return true;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public void quit() {
		available = false;
		dispose();
	}
}
