//Chapter 18 - Project 18.2

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class TowerPanel extends JPanel
{
	private DiskMover mover;
	private Tower[] tower;
	private static final int DISK_WIDTH = 20;
	private static final int DISK_HEIGHT = 10;
	private static final int GAP = 20;
	
	public TowerPanel(int n)
	{
		tower = new Tower[3];
		mover = new DiskMover(1, 3, n);
		
		for (int i = 0; i < tower.length; i++)
		{
			tower[i] = new Tower(new Rectangle(i*n*DISK_WIDTH + n*DISK_WIDTH / 2 + i*GAP, 0, n*DISK_WIDTH, n*DISK_HEIGHT));//the size of tower
		}
		
		for (int i = n; i >= 1; i--)
		{
			tower[0].addDisk(new Rectangle(0, 0, i*DISK_WIDTH, DISK_HEIGHT));
		}
	}
	
	public void paintComponent (Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		for (int i = 0; i < tower.length; i++)
		{
			tower[i].draw(g2);
		}
	}
	
	public void drawNextMove()
	{
		if (!mover.hasMoreMove())
		{
			return;
		}
		
		int[] move = mover.nextMove();
		
		tower[move[1]-1].addDisk(tower[move[0]-1].removeDisk());//array of tower[]
		repaint();
	}
}






























