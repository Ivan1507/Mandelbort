package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        Button bt=new Button();

        Group root=new Group();
        root.getChildren().add(bt);
        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
        numberLineChart.setTitle("Время построения от количества итераций");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Mandelbort");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        int[] param={1000,10000,100000,1000000};
        Mandelbort md=new Mandelbort();
        ArrayList<Long> as=md.count();
        for(int i=0; i<param.length; i++){
           datas.add(new XYChart.Data(param[i], as.get(i)));
        }

        series1.setData(datas);


        Scene scene = new Scene(numberLineChart, 900,800);
        numberLineChart.getData().add(series1);

        stage.setScene(scene);
        stage.setTitle("Визуализация Мандельборта");
        stage.show();
    }
    @Override
    public void init() throws Exception {
         System.out.println("Application init!");
         super.init();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
