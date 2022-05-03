package com.example.p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public Integer TryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        Text label = new Text("Результат 1, якщо точка з координатами (x,y) потрапляє всередину прямокутника");
        label.setLayoutX(50);
        label.setLayoutY(70);

        //---------------------- Точка ----------------------
        Text text_point = new Text("Точка:");
        text_point.setLayoutX(80);
        text_point.setLayoutY(100);

        Text text_x = new Text("X:");
        text_x.setLayoutX(65);
        text_x.setLayoutY(125);

        Text text_y = new Text("Y:");
        text_y.setLayoutX(65);
        text_y.setLayoutY(155);

        TextField tbx_x = new TextField();
        tbx_x.setLayoutX(80);
        tbx_x.setLayoutY(110);

        TextField tbx_y = new TextField();
        tbx_y.setLayoutX(80);
        tbx_y.setLayoutY(140);

        Group group_point = new Group(text_point, text_x, text_y, tbx_x, tbx_y);

        //---------------------- Прямокутник ----------------------
        Text text_sq = new Text("Прямокутник:");
        text_sq.setLayoutX(280);
        text_sq.setLayoutY(100);

        Text text_sq_x1 = new Text("X1:");
        text_sq_x1.setLayoutX(260);
        text_sq_x1.setLayoutY(125);

        Text text_sq_y1 = new Text("Y1:");
        text_sq_y1.setLayoutX(260);
        text_sq_y1.setLayoutY(155);

        TextField tbx_sq_x1 = new TextField();
        tbx_sq_x1.setLayoutX(280);
        tbx_sq_x1.setLayoutY(110);

        TextField tbx_sq_y1 = new TextField();
        tbx_sq_y1.setLayoutX(280);
        tbx_sq_y1.setLayoutY(140);



        Text text_sq_x2 = new Text("X2:");
        text_sq_x2.setLayoutX(260);
        text_sq_x2.setLayoutY(195);

        Text text_sq_y2 = new Text("Y2:");
        text_sq_y2.setLayoutX(260);
        text_sq_y2.setLayoutY(225);

        TextField tbx_sq_x2 = new TextField();
        tbx_sq_x2.setLayoutX(280);
        tbx_sq_x2.setLayoutY(180);

        TextField tbx_sq_y2 = new TextField();
        tbx_sq_y2.setLayoutX(280);
        tbx_sq_y2.setLayoutY(210);

        Group group_rectangle = new Group(text_sq, text_sq_x1, text_sq_y1, tbx_sq_x1, tbx_sq_y1, text_sq_x2, text_sq_y2, tbx_sq_x2, tbx_sq_y2);

        //---------------------- Результат ----------------------
        Button button = new Button("Виконати");
        button.setLayoutX(80);
        button.setLayoutY(240);

        Text text_res = new Text("Результат:");
        text_res.setLayoutX(65);
        text_res.setLayoutY(305);

        TextField tbx_res = new TextField();
        tbx_res.setLayoutX(130);
        tbx_res.setLayoutY(290);
        tbx_res.setPrefWidth(30);
        tbx_res.setEditable(false);

        Text text_res_error = new Text("Помилка:");
        text_res_error.setLayoutX(200);
        text_res_error.setLayoutY(305);


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    text_res_error.setText("");

                    if(tbx_x.getText().isEmpty()) throw new Exception("Точка Х не введена!");
                    if(tbx_y.getText().isEmpty()) throw new Exception("Точка Y не введена!");
                    if(tbx_sq_x1.getText().isEmpty()) throw new Exception("Точка прямокутника Х1 не введена!");
                    if(tbx_sq_y1.getText().isEmpty()) throw new Exception("Точка прямокутника Y1 не введена!");
                    if(tbx_sq_x2.getText().isEmpty()) throw new Exception("Точка прямокутника Х2 не введена!");
                    if(tbx_sq_y2.getText().isEmpty()) throw new Exception("Точка прямокутника Y2 не введена!");

                    Integer px = TryParseInt(tbx_x.getText());
                    Integer py = TryParseInt(tbx_y.getText());

                    Integer sqx1 = TryParseInt(tbx_sq_x1.getText());
                    Integer sqy1 = TryParseInt(tbx_sq_y1.getText());

                    Integer sqx2 = TryParseInt(tbx_sq_x2.getText());
                    Integer sqy2 = TryParseInt(tbx_sq_y2.getText());

                    if(px == null) throw new Exception("Точка Х введена некоректно!");
                    if(py == null) throw new Exception("Точка Y введена некоректно!");
                    if(sqx1 == null) throw new Exception("Точка прямокутника Х1 введена некоректно!");
                    if(sqy1 == null) throw new Exception("Точка прямокутника Y1 введена некоректно!");
                    if(sqx2 == null) throw new Exception("Точка прямокутника Х2 введена некоректно!");
                    if(sqy2 == null) throw new Exception("Точка прямокутника Y2 введена некоректно!");



                    boolean res = (px > sqx1 && px < sqx2) && (py > sqy1 && py < sqy2);

                    tbx_res.setText(res ? "1" : "0");

                }
                catch (Exception e)
                {
                    text_res_error.setText(e.getMessage());
                }
            }
        });

        Group group_res = new Group(button, text_res, tbx_res, text_res_error);


        //---------------------- Сцена ----------------------
        Group group = new Group(label, group_point, group_rectangle, group_res);
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Практична 1");
        stage.setWidth(540);
        stage.setHeight(380);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}