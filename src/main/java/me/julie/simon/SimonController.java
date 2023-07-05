package me.julie.simon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SimonController {
    @FXML
    private Label scoreLabel;
    @FXML
    private Button newGameButton;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;

    @FXML
    public void initialize() {
        newGameButton.setOnAction(e -> handleNewGame());
        button1.setStyle("-fx-background-color: #56c032");
        button2.setStyle("-fx-background-color: #d72b2b");
        button3.setStyle("-fx-background-color: #d7cb35");
        button4.setStyle("-fx-background-color: #3297da");
        button1.setOnMouseEntered(e -> button1.setStyle("-fx-background-color: #6dea42"));
        button1.setOnMouseExited(e -> button1.setStyle("-fx-background-color: #56c032"));
        button2.setOnMouseEntered(e -> button2.setStyle("-fx-background-color: #e35252"));
        button2.setOnMouseExited(e -> button2.setStyle("-fx-background-color: #d72b2b"));
        button3.setOnMouseEntered(e -> button3.setStyle("-fx-background-color: #eadd63"));
        button3.setOnMouseExited(e -> button3.setStyle("-fx-background-color: #d7cb35"));
        button4.setOnMouseEntered(e -> button4.setStyle("-fx-background-color: #5aa9e1"));
        button4.setOnMouseExited(e -> button4.setStyle("-fx-background-color: #3297da"));
        run();
    }

    private void run() {
        scoreLabel.setText("0");
    }

    private void handleNewGame() {
        run();
    }
}