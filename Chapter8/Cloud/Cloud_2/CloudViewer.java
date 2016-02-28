/** COPYRIGHT(C) 2008. Loc Phan. All Rights Reserved.
    A class that display cloud.
    @author Loc Phan
    @version 1.01 2008-11-11
*/
import javax.swing.JFrame;

public class CloudViewer
{
   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.setTitle("Cloud : 2 Files class");
      frame.setSize(500, 500);
      Cloud myComponent = new Cloud();
      frame.add(myComponent);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}