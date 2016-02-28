import java.awt.*;

public class Spiral2 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(170, 170);
        Graphics g = panel.getGraphics();
        int x = 0, y = 10;
        int len = 160;
        for (int i = 0; i < 8; i++) {
            g.drawLine(x, y, x + len, y);  // right
            x = x + len;
            len = len - 10;
            g.drawLine(x, y, x, y + len);  // down
            y = y + len;
            g.drawLine(x, y, x - len, y);  // left
            x = x - len;
            len = len - 10;
            g.drawLine(x, y, x, y - len);  // up
            y = y - len;
        }
    }
}