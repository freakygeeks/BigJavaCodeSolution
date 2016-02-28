import java.awt.*;
import java.applet.*;
import java.util.*;

public class life extends Applet implements Runnable
{
	Thread runner; 
	boolean gRunning;
	Panel mpanUserControls;
	Button butStart, butStop, butSingle, butClear;
	private Image Buffer;
	private Graphics gBuffer;

	int nXCells;
	int nYCells;
	int cellwidth=5;
	int gridlinewidth=1;
	
	boolean mabLifeCells[][];
	int manLifeScores[][];

	public void run() { 

		while(true){	
			if(gRunning) {
				runlife();
				try {runner.sleep(50);}
				catch (Exception e) { }	
			}
			else {
				try {runner.sleep(50);}
				catch (Exception e) { }	
			}
		}
	}
	
	public void start() {	
		if (runner == null){
			runner = new Thread (this);
			runner.start();
		}
	}
	
	public void stop() {
		if (runner != null) {
			runner.stop();
			runner = null;
		}
	} 

	public void update(Graphics g) {
		paint(g);
	} 

	public void paint (Graphics g) {
		g.drawImage (Buffer,0,0, this);
	}

	public void init() {

		int x,y,xPos,yPos;

		mabLifeCells=new boolean[101][101];
		manLifeScores=new int[101][101];

		Buffer=createImage(size().width,size().height);
		gBuffer=Buffer.getGraphics();

		gBuffer.setColor(Color.white);
		gBuffer.fillRect(0,0,size().width,size().height);

		//draw the gridlines
		gBuffer.setColor(new Color(247,155,194));
		for(x=0;x<size().width;x+=gridlinewidth+cellwidth)
			gBuffer.drawLine(x,0,x,size().height); 
		for(y=0;y<size().height;y+=gridlinewidth+cellwidth)
			gBuffer.drawLine(0,y,size().width,y); 

		gBuffer.setColor(Color.black);
		for(x=1;x<100;x+=1){
			xPos=(x-1)*(cellwidth+gridlinewidth)+gridlinewidth;
			for(y=1;y<100;y+=1){
				yPos=(y-1)*(cellwidth+gridlinewidth)+gridlinewidth;
				if (mabLifeCells[x][y]) gBuffer.fillRect(xPos,yPos,cellwidth,cellwidth); 
			}
		}
			
		setLayout(new BorderLayout());
		mpanUserControls = new Panel();
		mpanUserControls.setLayout(new FlowLayout());
	
		butSingle = new Button("Single");
		mpanUserControls.add(butSingle);
		butStart = new Button("Start");
		mpanUserControls.add(butStart);
		butStop = new Button("Stop");
		mpanUserControls.add(butStop);
		butClear = new Button("Clear");
		mpanUserControls.add(butClear);
		add("South",mpanUserControls);

	}
	
	public boolean mouseDown(Event evt,int x,int y) {
		int xCell, yCell;
		if (gRunning==false){ 
			xCell = (x/(gridlinewidth+cellwidth))+1;
			yCell = (y/(gridlinewidth+cellwidth))+1;
			if (mabLifeCells[xCell][yCell])
				mabLifeCells[xCell][yCell] = false;
			else
				mabLifeCells[xCell][yCell]= true;
			repaintcell(xCell,yCell);
		}
		return true;
	} 

	public void repaintcell(int xCell, int yCell) {
		int xPos, yPos;
		xPos=(xCell-1)*(cellwidth+gridlinewidth)+gridlinewidth;
		yPos=(yCell-1)*(cellwidth+gridlinewidth)+gridlinewidth;
		if (mabLifeCells[xCell][yCell]) {
			gBuffer.setColor(Color.black);
			gBuffer.fillRect(xPos,yPos,cellwidth,cellwidth);
		}
		else {
			gBuffer.setColor(Color.white);
			gBuffer.fillRect(xPos,yPos,cellwidth,cellwidth);
		}
		repaint();
	}

	public boolean action(Event ev, Object arg) {
		if (ev.target==butStart) gRunning=true;
		if (ev.target==butStop) gRunning=false;
		if (ev.target==butClear && gRunning==false) clearlifearea();
		if (ev.target==butSingle && gRunning==false) runlife();
		return true;	
	}
	
	public void runlife() {
		calculatenewgeneration();
		displaynewgeneration();
		repaint();
	}
	
	public void clearlifearea() {
		int x,y;
		for(x=1;x<100;x+=1){
			for(y=1;y<100;y+=1){
				if (mabLifeCells[x][y]){
					mabLifeCells[x][y]=false;
					repaintcell(x,y);
				}
			}
		}
	}
	
	public void calculatenewgeneration(){
		int x,y;
		for(x=1;x<100;x+=1){
			for(y=1;y<100;y+=1){
				manLifeScores[x][y]=0;
				if (mabLifeCells[x-1][y-1]) manLifeScores[x][y]+=1;
				if (mabLifeCells[x-1][y]) manLifeScores[x][y]+=1;
				if (mabLifeCells[x-1][y+1]) manLifeScores[x][y]+=1;
				if (mabLifeCells[x][y-1]) manLifeScores[x][y]+=1;
				if (mabLifeCells[x][y+1]) manLifeScores[x][y]+=1;
				if (mabLifeCells[x+1][y-1]) manLifeScores[x][y]+=1;
				if (mabLifeCells[x+1][y]) manLifeScores[x][y]+=1;
				if (mabLifeCells[x+1][y+1]) manLifeScores[x][y]+=1;
			}
		}
	}
	
	public void displaynewgeneration(){

		int x,y,xPos,yPos;
		boolean bChange;

		bChange=false;

		for(x=1;x<100;x+=1){
			for(y=1;y<100;y+=1){
				switch (manLifeScores[x][y]) {
					case 2:
						break;
					case 3:
						if (mabLifeCells[x][y]==false) {
							mabLifeCells[x][y]=true;
							gBuffer.setColor(Color.black);
							xPos=(x-1)*(cellwidth+gridlinewidth)+gridlinewidth;
							yPos=(y-1)*(cellwidth+gridlinewidth)+gridlinewidth;
							gBuffer.fillRect(xPos,yPos,cellwidth,cellwidth);
						}
						bChange=true;
						break;
					default:
						if (mabLifeCells[x][y]) {
							mabLifeCells[x][y]=false;
							gBuffer.setColor(Color.white);
							xPos=(x-1)*(cellwidth+gridlinewidth)+gridlinewidth;
							yPos=(y-1)*(cellwidth+gridlinewidth)+gridlinewidth;
							gBuffer.fillRect(xPos,yPos,cellwidth,cellwidth);
						}									
						bChange=true;
						break;
				}
			}
		}
		
		if(bChange==false){
			gRunning=false;
			if(lifestillleft()){
//				Game stopped with only static lifeforms remaining
			}
			else {
//				Game stopped with no lifeforms remaining
			}
		}
	}
	
	public boolean lifestillleft(){
		int x, y;
		for(x=1;x<100;x+=1){
			for(y=1;y<100;y+=1){
				if (mabLifeCells[x][y]){
					return true;
				}
			}
		}
		return false;
	}

}
