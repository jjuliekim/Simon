package me.julie.simon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SimonController {
    @FXML
    private Label scoreLabel;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private VBox buttonsVBox;
    @FXML
    private Button startButton;
    @FXML
    private Label gameOverLabel;
    @FXML
    private VBox mainVbox;
    private int score;
    private ArrayList<Integer> sequence;
    private ArrayList<Integer> guess;
    private Random random;
    private final String lightRed = "-fx-background-color: #fa5858";
    private final String lightGreen = "-fx-background-color: #78f34d";
    private final String lightYellow = "-fx-background-color: #fff05e";
    private final String lightBlue = "-fx-background-color: #5db6f6";
    private final String darkRed = "-fx-background-color: #9d1818";
    private final String darkGreen = "-fx-background-color: #399919";
    private final String darkYellow = "-fx-background-color: #a59b16";
    private final String darkBlue = "-fx-background-color: #1a6597";

    @FXML
    public void initialize() {
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        mainVbox.setStyle("-fx-background-color: #dccbf8");
        scoreLabel.setText("0");
        score = 0;
        sequence = new ArrayList<>();
        guess = new ArrayList<>();
        random = new Random();
        buttonStyles();
        startButton.setOnAction(e -> handleNewGame());
        button1.setOnAction(e -> {
            try {
                handleButton1();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        button2.setOnAction(e -> {
            try {
                handleButton2();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        button3.setOnAction(e -> {
            try {
                handleButton3();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        button4.setOnAction(e -> {
            try {
                handleButton4();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void buttonStyles() {
        buttonsVBox.setStyle("-fx-background-color: black");
        startButton.setStyle("-fx-focus-color: #f675f4");
        button1.setStyle(darkGreen);
        button2.setStyle(darkRed);
        button3.setStyle(darkYellow);
        button4.setStyle(darkBlue);
    }

    private void run() {
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        guess.clear();
        int i = random.nextInt(4) + 1;
        sequence.add(i);
        displayAnswer();
    }

    private void endGame() {
        gameOverLabel.setText("Game Over!");
    }

    private void displayAnswer() {
        Main.delay(500, () -> {
            int delay = 500;
            for (int i : sequence) {
                Main.delay(delay, () -> {
                    switch (i) {
                        case 1 -> button1.setStyle(lightGreen);
                        case 2 -> button2.setStyle(lightRed);
                        case 3 -> button3.setStyle(lightYellow);
                        case 4 -> button4.setStyle(lightBlue);
                    }

                    Main.delay(500, () -> {
                        switch (i) {
                            case 1 -> button1.setStyle(darkGreen);
                            case 2 -> button2.setStyle(darkRed);
                            case 3 -> button3.setStyle(darkYellow);
                            case 4 -> button4.setStyle(darkBlue);
                        }
                    });
                });
                delay += 1000;
            }
        });
    }

    private void handleNewGame() {
        scoreLabel.setText("0");
        score = 0;
        gameOverLabel.setText("");
        sequence = new ArrayList<>();
        guess = new ArrayList<>();
        run();
    }

    private void handleButton1() throws InterruptedException {
        button1.setStyle(lightGreen);
        Main.delay(500, () -> {
            button1.setStyle(darkGreen);
            guess.add(1);
            checkAnswer();
        });
    }

    private void handleButton2() throws InterruptedException {
        button2.setStyle(lightRed);
        Main.delay(500, () -> {
            button2.setStyle(darkRed);
            guess.add(2);
            checkAnswer();
        });
    }

    private void handleButton3() throws InterruptedException {
        button3.setStyle(lightYellow);
        Main.delay(500, () -> {
            button3.setStyle(darkYellow);
            guess.add(3);
            checkAnswer();
        });
    }

    private void handleButton4() throws InterruptedException {
        button4.setStyle(lightBlue);
        Main.delay(500, () -> {
            button4.setStyle(darkBlue);
            guess.add(4);
            checkAnswer();
        });
    }

    private void checkAnswer() {
        for (int i = 0; i < guess.size(); i++) {
            if (!Objects.equals(guess.get(i), sequence.get(i))) {
                endGame();
            }
        }

        if (guess.equals(sequence)) {
            score++;
            scoreLabel.setText(Integer.toString(score));
            run();
        }
    }
}