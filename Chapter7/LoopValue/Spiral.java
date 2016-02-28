import java.awt.*;

public class Spiral {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(170, 170);
        Graphics g = panel.getGraphics();
        for (int i = 0; i < 8; i++) {
            g.drawLine(      10*i,   10 + 10*i, 160 - 10*i,  10 + 10*i);  // top
            g.drawLine(160 - 10*i,   10 + 10*i, 160 - 10*i, 160 - 10*i);  // right
            g.drawLine( 10 + 10*i,  160 - 10*i, 160 - 10*i, 160 - 10*i);  // bottom
            g.drawLine( 10 + 10*i,   20 + 10*i,  10 + 10*i, 160 - 10*i);  // left
        }
    }
}