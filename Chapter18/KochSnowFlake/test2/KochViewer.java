import javax.swing.JFrame;
public class KochViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new KochFrame();
      frame.setTitle("KochViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}