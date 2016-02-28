//Chapter8 - Exercise P8.14
//http://go.code-check.org/codecheck/files?repo=bj4fp&problem=ch07/c07_exp_7_21


import javax.swing.JFrame;
 
public class BarChartNegativeViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
 
      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 400;
 
      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("BarChart");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
      BarChartNegativeComponent component = new BarChartNegativeComponent();
      frame.add(component);
 
      frame.setVisible(true);
   }
}