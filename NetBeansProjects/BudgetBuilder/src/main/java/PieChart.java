import javax.swing.*;
import java.awt.*;

class Part {
    double value;
    Color color;
    String category;

    public Part(double value, Color color, String category) {
        this.value = value;
        this.color = color;
        this.category = category;
    }
}
class PieChart extends JComponent {
    private Part[] slices;
    private int size;
    private int numCurrentSlice;
//  = {new Part(15, Color.yellow), new Part(30, Color.white), new Part(25, Color.blue), new Part(30, Color.red)};
    PieChart(int numCategory) {
        this.size = numCategory;
        slices = new Part[size];
        numCurrentSlice = 0;
    }

    public void addSlice (int percentage, Color color, String category) {
        slices[numCurrentSlice++] = new Part(percentage, color, category);
    }

    public void paint(Graphics g) {
        drawPie((Graphics2D) g, getBounds(), slices);
    }
    void drawPie(Graphics2D g, Rectangle area, Part[] slices) {
        double total = 0.0D;
        for (int i = 0; i < slices.length; i++) {
            total += slices[i].value;
        }
        double curValue = 0.0D;
        int startAngle = 0;
        for (int i = 0; i < slices.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slices[i].value * 360 / total);

            g.setColor(slices[i].color);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += slices[i].value;
        }
    }
}
