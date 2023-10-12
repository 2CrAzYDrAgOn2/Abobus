package com.example.abobus;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;

public class HelloController {

    Seat[][] seats = new Seat[3][11];

    @FXML
    void ButtonClick(ActionEvent event) {
        Button btn = (Button)event.getSource();
        int rowIndex = GridPane.getRowIndex(btn) == null ? 0 : GridPane.getRowIndex(btn);
        int columnIndex = GridPane.getColumnIndex(btn) == null ? 0 : GridPane.getColumnIndex(btn);
        if (seats[rowIndex][columnIndex].GetEmpty()){
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Ввод данных");
            dialog.setHeaderText("Пожалуйста, введите имя:");
            dialog.setContentText("Имя:");
            Optional<String> result = dialog.showAndWait();
            result.ifPresent(s -> seats[rowIndex][columnIndex].SetName(s));
            seats[rowIndex][columnIndex].SetEmpty(false);
            btn.setStyle("-fx-background-color: red");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Это место уже занято!");
            alert.setHeaderText("Это место уже занято!");
            alert.setContentText("Имя: " + seats[rowIndex][columnIndex].GetName());
            alert.showAndWait();
        }
    }

    @FXML
    void initialize(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 11; j++) {
                seats[i][j] = new Seat(true, "");
            }
        }
    }
}
