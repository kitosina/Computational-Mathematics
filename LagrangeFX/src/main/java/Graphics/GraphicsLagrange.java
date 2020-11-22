package Graphics;

import Lagrange.LagrangeCalculations;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class GraphicsLagrange extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LagrangeCalculations lagrangeCalculations = new LagrangeCalculations();
        lagrangeCalculations.calculationValuesLagrange();
        primaryStage.setTitle("Lagrange Graphics");

        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
        numberLineChart.setTitle("1) y = tg(x)\n2) Lagrange");
        numberLineChart.setCreateSymbols(false);
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        series1.setName("y = tg(x)");
        series2.setName("Lagrange");
        ObservableList<XYChart.Data> pointsTg = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> pointsLagrange = FXCollections.observableArrayList();
        for(int i = 0; i < lagrangeCalculations.getQuantityPoint(); i++) {
            pointsTg.add(new XYChart.Data(lagrangeCalculations.getxResult()[i], lagrangeCalculations.getResult()[i]));
            pointsLagrange.add(new XYChart.Data(lagrangeCalculations.getXPolimomial()[i], lagrangeCalculations.getPolynomial()[i]));
        }

        series1.setData(pointsTg);
        series2.setData(pointsLagrange);

        Scene scene = new Scene(numberLineChart, 600,600);
        numberLineChart.getData().add(series1);
        numberLineChart.getData().add(series2);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
