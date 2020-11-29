import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Chart (Series)");
        EulerLogic eulerLogic = new EulerLogic();
        eulerLogic.Euler();
        Double[] X = eulerLogic.getX();
        Double[] Y = eulerLogic.getF();
        Integer N = eulerLogic.getN();

        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();

        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
        numberLineChart.setTitle("Series");
        numberLineChart.setCreateSymbols(false);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("F");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        for(Integer i=0; i<N; i++){
            datas.add(new XYChart.Data(X[i],Y[i]));
        }

        series1.setData(datas);

        Scene scene = new Scene(numberLineChart, 600,600);
        numberLineChart.getData().add(series1);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
