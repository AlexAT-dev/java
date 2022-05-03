package com.example.lab9;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

    public void Task1(Stage stage){
        Text t1label = new Text("Середнє арифметичне та середнє геометричне");
        t1label.setLayoutX(30);
        t1label.setLayoutY(70);
        t1label.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Text text_val = new Text("Дані:");
        text_val.setLayoutX(80);
        text_val.setLayoutY(100);

        Text text_a = new Text("a:");
        text_a.setLayoutX(65);
        text_a.setLayoutY(125);

        Text text_b = new Text("b:");
        text_b.setLayoutX(65);
        text_b.setLayoutY(155);

        TextField tbx_a = new TextField();
        tbx_a.setLayoutX(80);
        tbx_a.setLayoutY(110);

        TextField tbx_b = new TextField();
        tbx_b.setLayoutX(80);
        tbx_b.setLayoutY(140);

        Text text_res = new Text("Результат:");
        text_res.setLayoutX(80);
        text_res.setLayoutY(240);

        Button button_task1 = new Button("Виконати");
        button_task1.setLayoutX(80);
        button_task1.setLayoutY(180);
        button_task1.setOnAction(event -> {
            try{
                if(tbx_a.getText().isEmpty()) throw new Exception("Значення а не введене!");
                if(tbx_b.getText().isEmpty()) throw new Exception("Значення b не введене!");

                Integer a = TryParseInt(tbx_a.getText());
                Integer b = TryParseInt(tbx_b.getText());

                if(a == null) throw new Exception("Значення а введене некоректно!");
                if(b == null) throw new Exception("Значення b введене некоректно!");

                double sa = (a+b) / 2.0;
                double sg = Math.sqrt(a*b);

                text_res.setText("Результат: \n\tsa = " + String.format("%.2f",sa) + "\n\tsg = " + String.format("%.2f",sg));
            }
            catch (Exception e)
            {
                text_res.setText(e.getMessage());
            }
        });

        Group group_task1 = new Group(t1label, text_val, text_a, text_b, tbx_a, tbx_b, text_res, button_task1);
        Scene scene_task1 = new Scene(group_task1);

        stage.setScene(scene_task1);
        stage.setTitle("ЛР 9. Завдання 1");
        stage.setWidth(540);
        stage.setHeight(380);
        stage.show();
    }

    public void SetAlert(Alert.AlertType type, String title, String content)
    {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

    public void Task2(Stage stage) {
        Text t1label = new Text("Пошук поверху по номеру кімнати");
        t1label.setLayoutX(80);
        t1label.setLayoutY(70);
        t1label.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        Text text_val = new Text("Поверх:");
        text_val.setLayoutX(160);
        text_val.setLayoutY(100);

        TextField tbx_a = new TextField();
        tbx_a.setLayoutX(160);
        tbx_a.setLayoutY(110);

        Button button_task1 = new Button("Виконати");
        button_task1.setLayoutX(200);
        button_task1.setLayoutY(180);
        button_task1.setOnAction(event -> {
            try{
                if(tbx_a.getText().isEmpty()) throw new Exception("Значення не введене!");

                Integer n = TryParseInt(tbx_a.getText());

                if(n == null) throw new Exception("Значення введене некоректно!");

                switch (n) {
                    case 1, 2, 3, 4, 5 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на першому поверсі.");
                    case 6, 7, 8, 9, 10 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на другому поверсі.");
                    case 11, 12, 13, 14, 15 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на третьому поверсі.");
                    case 16, 17, 18, 19, 20 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на четвертому поверсі.");
                    case 21, 22, 23, 24, 25 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на п'ятому поверсі.");
                    case 26, 27, 28, 29, 30 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на шостому поверсі.");
                    case 31, 32, 33, 34, 35 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на сьомому поверсі.");
                    case 36, 37, 38, 39, 40 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на восьмому поверсі.");
                    case 41, 42, 43, 44, 45 -> SetAlert(Alert.AlertType.INFORMATION, "Знайдено!", "Кімната №" + n + " знаходиться на дев'ятому поверсі.");
                    default -> SetAlert(Alert.AlertType.WARNING, "Не знайдено!", "Кімнати №" + n + " немає в даному будинку.");
                }
                System.out.println();


            }
            catch (Exception e)
            {
                SetAlert(Alert.AlertType.ERROR, "ПОМИЛКА!", e.getMessage());
            }
        });

        Group group_task2 = new Group(t1label, text_val, tbx_a, button_task1);
        Scene scene_task2 = new Scene(group_task2);

        stage.setScene(scene_task2);
        stage.setTitle("ЛР 9. Завдання 2");
        stage.setWidth(540);
        stage.setHeight(380);
        stage.show();
    }

    @Override
    public void start(Stage stage) throws IOException {


        //---------------------- Головна форма ----------------------
        Text label = new Text("Оберіть завдання!");
        label.setLayoutX(150);
        label.setLayoutY(70);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Text label1 = new Text("Завдання 1 - середнє арифметичне та середнє геометричне.");
        label1.setLayoutX(70);
        label1.setLayoutY(100);

        Text label2 = new Text("Завдання 2 - будинки.");
        label2.setLayoutX(70);
        label2.setLayoutY(130);

        Button button1 = new Button("Завдання 1");
        button1.setLayoutX(200);
        button1.setLayoutY(160);
        button1.setOnAction(event -> {
            Stage stage1 = new Stage();
            Task1(stage1);
        });

        Button button2 = new Button("Завдання 2");
        button2.setLayoutX(200);
        button2.setLayoutY(200);
        button2.setOnAction(event -> {
            Stage stage2 = new Stage();
            Task2(stage2);
        });



        Group group = new Group(label, label1, label2, button1, button2);
        Scene scene_main = new Scene(group);
        stage.setScene(scene_main);
        stage.setTitle("ЛР 9");
        stage.setWidth(540);
        stage.setHeight(380);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}