import javax.swing.JFrame;

/**
   Displays a cloud of circles.
*/
public class CloudViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();

      final int FRAME_WIDTH = 300;
      final int FRAME_HEIGHT = 300;

      frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
      frame.setTitle("Cloud : 3 Files Class");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CloudComponent component = new CloudComponent();
      frame.add(component);

      frame.setVisible(true);
   }
}