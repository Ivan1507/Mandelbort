package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
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
        NumberAxis x1=new NumberAxis();
        CategoryAxis y1=new CategoryAxis();
        Button bt=new Button();
        int Border=0;
        int Empty=0;
        int Inside=0;
        int Sum=6241;

        Mandelbort md=new Mandelbort();
        ArrayList<Long> as=md.count();
        boolean[][] f=md.Mas;
        for(int i=1;i<80;i++){
            for(int j=1;j<80;j++){
                if((f[i][j])&&(!f[i-1][j-1])||(f[i][j])&&!(f[i][j-1])||(f[i][j])&&!(f[i-1][j])||(f[i][j])&&!(f[i-1][j+1])||
                        (f[i][j])&&!(f[i][j+1])||(f[i][j])&&!(f[i+1][j+1])||(f[i][j])&&!(f[i+1][j])||(f[i][j])&&!(f[i+1][j-1])){
                    Border+=1;
                }
                else if(!f[i][j]){
                    Empty+=1;
                }
                else{
                    Inside+=1;
                }
            }
        }

        Group root=new Group();
        LineChart<Number, Number> numberLineChart = new LineChart<Number, Number>(x,y);
        BarChart<Number,String> bc=new BarChart<Number, String>(x1,y1);
        bc.setTranslateY(400);
        bc.setTitle("Процессорное время от положения точки");
        numberLineChart.setTitle("Время построения от количества итераций");
        XYChart.Series series1 = new XYChart.Series();

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Sum");
        series2.getData().add(new XYChart.Data(Sum, "Sum"));

        XYChart.Series series3 = new XYChart.Series();
        series3.getData().add(new XYChart.Data(Empty,"Empty"));
        series3.setName("Empty");
        XYChart.Series series4 = new XYChart.Series();
        series4.getData().add(new XYChart.Data(Inside,"Inside"));
        series4.setName("Border");
        XYChart.Series series5 = new XYChart.Series();
        series5.setName("Inside");
        series5.getData().add(new XYChart.Data(Border,"Border"));
        series1.setName("Mandelbort");
        ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
        ObservableList<XYChart.Data> data1 = FXCollections.observableArrayList();
        int[] param={1000,10000,100000,1000000};
        for(int i=0; i<param.length; i++){
           series1.getData().addAll(new XYChart.Data(param[i],Math.log(as.get(i))));
        }
        bc.getData().addAll(series2,series3,series4,series5);
        root.getChildren().addAll(numberLineChart);
        root.getChildren().addAll(bc);
        Scene scene = new Scene(root,600,800);
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
