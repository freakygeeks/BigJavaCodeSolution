//Chapter8 - Exercise P8.15

import javax.swing.JFrame;

/**
   Displays a pie chart.
*/
public class PieChartViewer
{  
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 300;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("ChartViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      PieChartComponent component = new PieChartComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}