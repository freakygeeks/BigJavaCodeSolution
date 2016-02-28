//Chapter8 - Exercise P8.12

import javax.swing.JFrame;

/**
   Tester class to display a stick chart.
*/
public class ChartViewer
{  
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 300;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("ChartViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      ChartComponent component = new ChartComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}