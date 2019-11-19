import java.util.ArrayList;
import java.util.Iterator;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.PieStyler;
import org.knowm.xchart.style.Styler.ChartTheme;

/**
 * Pie Chart GGPlot2 Theme
 *
 * <p>Demonstrates the following:
 *
 * <ul>
 *   <li>Pie Chart
 *   <li>PieChartBuilder
 *   <li>GGPlot2 Theme
 *   <li>Setting start angle
 */
public class SpendingPieChart implements ExampleChart<PieChart> {

    public static void main(String[] args) {
    	
    	BudgetProfile profile = new BudgetProfile("Chris", "Gilmore");
    	BudgetEditor editor = new BudgetEditor(profile);
    	Spending spending = new Spending("Car", 500);
    	Spending spending2 = new Spending("House", 2000);
    	Income income = new Income("Work", 100);
    	editor.addSpending(spending);
    	editor.addSpending(spending2);
    	editor.addIncome(income);
    	profile.setSavings(50);
    	
        ExampleChart<PieChart> exampleChart = new SpendingPieChart(profile, "UtilityBudget");
        PieChart chart = exampleChart.getChart();
        new SwingWrapper<PieChart>(chart).displayChart();
    }
    
    private BudgetProfile profile;
    private String chartType;
    
    public SpendingPieChart(BudgetProfile profile, String type) {
    	this.profile = profile;
    	this.chartType = type;
    }
    
    //IncomeNeeded, SavingsGoal, UtilityBudget valid input
    public void setChartType(String type) {
    	this.chartType = type;
    }
    
    
    @Override
    public PieChart getChart() {
    	
    	BudgetAnalysis budgetAnalysis = new BudgetAnalysis(profile);
    		
        // Create Chart
        PieChart chart =
                new PieChartBuilder()
                        .width(800)
                        .height(600)
                        .title("Budget Builder")
                        .theme(ChartTheme.GGPlot2)
                        .build();

        // Customize Chart
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setAnnotationDistance(1.15);
        chart.getStyler().setPlotContentSize(.7);
        chart.getStyler().setStartAngleInDegrees(90);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.LabelAndPercentage);

        // Series
        if(chartType == "IncomeNeeded") {
    		Iterator<Spending> it = profile.spendingIterator();
    		
    		while (it.hasNext()) {
    			Spending spendingInstance = it.next();
    			//addSeries() adds all of the $ values and divides in order to get percentages
    			chart.addSeries(spendingInstance.getCategory(),spendingInstance.getAmount());
    		}
    		chart.addSeries("Savings", profile.getSavings());
    	}
        
        if(chartType == "SavingsGoal") {
    		Iterator<Spending> it = profile.spendingIterator();
    		
    		while (it.hasNext()) {
    			Spending spendingInstance = it.next();
    			//addSeries() adds all of the $ values and divides in order to get percentages
    			chart.addSeries(spendingInstance.getCategory(),spendingInstance.getAmount());
    		}
    		chart.addSeries("Savings", budgetAnalysis.calculateSavings());
    	}
        
        if(chartType == "UtilityBudget") {
        	
        	//find the total amount of income
        	double incomeTotal = budgetAnalysis.totalIncome();
    		chart.addSeries("Utitilies",  incomeTotal - profile.getSavings());
    		chart.addSeries("Savings", profile.getSavings());
    		System.out.println(budgetAnalysis.calculateIncome() - profile.getSavings());
    	}
        
        return chart;
    }
    
    
}