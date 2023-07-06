package me.julie.simon;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;

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
    private VBox buttonsVBox;
    @FXML
    private Button startButton;
    @FXML
    private Label gameOverLabel;
    private int score;
    private ArrayList<Integer> sequence;
    private ArrayList<Integer> guess;
    private Random random;

    @FXML
    public void initialize() {
        scoreLabel.setText("0");
        score = 0;
        sequence = new ArrayList<>();
        guess = new ArrayList<>();
        random = new Random();
        newGameButton.setOnAction(e -> handleNewGame());
        startButton.setOnAction(e -> run());
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
        buttonStyles();
    }

    private void buttonStyles() {
        buttonsVBox.setStyle("-fx-background-color: #000000");
        button1.setStyle("-fx-background-color: #56c032");
        button2.setStyle("-fx-background-color: #d72b2b");
        button3.setStyle("-fx-background-color: #d7cb35");
        button4.setStyle("-fx-background-color: #3297da");
    }

    private void run() {
        int i = random.nextInt(4) + 1;
        sequence.add(i);
        displayAnswer();

        if (guess.size() == sequence.size() && !(guess.equals(sequence))) {
            endGame();
        } else if (guess.size() == sequence.size() && guess.equals(sequence)) {
            score++;
            scoreLabel.setText(Integer.toString(score));
            run();
        }
    }

    private void endGame() {
        gameOverLabel.setText("Game Over");
    }

    private void displayAnswer() {
        Main.delay(500, () -> {
            for (int j : sequence) {
                Main.delay(500, () -> {
                    switch (j) {
                        case 1 -> button1.setStyle("-fx-background-color: #6dea42");
                        case 2 -> button2.setStyle("-fx-background-color: #e35252");
                        case 3 -> button3.setStyle("-fx-background-color: #eadd63");
                        case 4 -> button4.setStyle("-fx-background-color: #5aa9e1");
                    }

                    Main.delay(500, () -> {
                        button1.setStyle("-fx-background-color: #56c032");
                        button2.setStyle("-fx-background-color: #d72b2b");
                        button3.setStyle("-fx-background-color: #d7cb35");
                        button4.setStyle("-fx-background-color: #3297da");
                    });
                });
            }
        });
        System.out.println(sequence);
    }

    private void handleNewGame() {
        scoreLabel.setText("0");
        score = 0;
        sequence = new ArrayList<>();
        guess = new ArrayList<>();
        run();
    }

    private void handleButton1() throws InterruptedException {
        System.out.println("Button 1 pressed");
        button1.setStyle("-fx-background-color: #78f34d");
        Main.delay(500, () -> {
            button1.setStyle("-fx-background-color: #56c032");
            guess.add(1);
        });
    }

    private void handleButton2() throws InterruptedException {
        System.out.println("Button 2 pressed");
        button2.setStyle("-fx-background-color: #fa5858");
        Main.delay(500, () -> {
            button2.setStyle("-fx-background-color: #d72b2b");
            guess.add(2);
        });
    }

    private void handleButton3() throws InterruptedException {
        System.out.println("Button 3 pressed");
        button3.setStyle("-fx-background-color: #fff05e");
        Main.delay(500, () -> {
            button3.setStyle("-fx-background-color: #d7cb35");
            guess.add(3);
        });
    }

    private void handleButton4() throws InterruptedException {
        System.out.println("Button 4 pressed");
        button4.setStyle("-fx-background-color: #5db6f6");
        Main.delay(500, () -> {
            button4.setStyle("-fx-background-color: #3297da");
            guess.add(4);
        });
    }
}