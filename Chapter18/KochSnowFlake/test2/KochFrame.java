import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class KochFrame extends JFrame
{
   public KochFrame()
   {
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
      setTitle("KochViewer");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel panel = new JPanel();
      panel.add(makeNextButton());
      component = new KochComponent();
      component.setPreferredSize(new Dimension(
            COMPONENT_WIDTH, COMPONENT_HEIGHT));
      panel.add(component);
      add(panel);
   }
   private JButton makeNextButton()
   {
      JButton button = new JButton("Next");
      class ButtonListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            component.next();
         }
      }
      button.addActionListener(new ButtonListener());
      return button;
   }
   
   private static final int FRAME_WIDTH = 360;
   private static final int FRAME_HEIGHT  =  500;
 
   private static final int COMPONENT_WIDTH = 300;
   private static final int COMPONENT_HEIGHT = 400;
   private KochComponent component;
}