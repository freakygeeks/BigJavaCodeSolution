//Chapter11 - Exercise P11.12

import javax.swing.JFrame;

public class RandomShapesViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 800;
      final int FRAME_HEIGHT = 800;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("RandomShapeViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      RandomShapesComponent component = new RandomShapesComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}