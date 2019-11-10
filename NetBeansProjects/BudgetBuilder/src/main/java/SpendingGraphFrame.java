import javax.swing.*;
import java.awt.*;

public class SpendingGraphFrame extends JFrame {
    private PieChart piechart;

    public SpendingGraphFrame() throws HeadlessException {
        piechart = new PieChart(3);
        piechart.addSlice(33, Color.LIGHT_GRAY, "Insurance");
        piechart.addSlice(33, Color.BLUE, "Groceries");
        piechart.addSlice(34, Color.YELLOW, "Savings");
        this.setTitle("Spending Graph");
        this.setPreferredSize(new Dimension(1200,900));
        this.add(piechart, BorderLayout.CENTER);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
