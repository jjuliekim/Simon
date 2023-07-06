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
    private String lightRed = "-fx-background-color: #fa5858";
    private String lightGreen = "-fx-background-color: #78f34d";
    private String lightYellow = "-fx-background-color: #fff05e";
    private String lightBlue = "-fx-background-color: #5db6f6";
    private String darkRed = "-fx-background-color: #9d1818";
    private String darkGreen = "-fx-background-color: #399919";
    private String darkYellow = "-fx-background-color: #a59b16";
    private String darkBlue = "-fx-background-color: #1a6597";

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
        buttonsVBox.setStyle("-fx-background-color: black");
        button1.setStyle(darkGreen);
        button2.setStyle(darkRed);
        button3.setStyle(darkYellow);
        button4.setStyle(darkBlue);
    }

    private void run() {
        int i = random.nextInt(4) + 1;
        sequence.add(i);
        displayAnswer();
    }

    private void endGame() {
        gameOverLabel.setText("Game Over");
    }

    private void displayAnswer() {
        Main.delay(500, () -> {
            for (int j : sequence) {
                Main.delay(500, () -> {
                    switch (j) {
                        case 1 -> button1.setStyle(lightGreen);
                        case 2 -> button2.setStyle(lightRed);
                        case 3 -> button3.setStyle(lightYellow);
                        case 4 -> button4.setStyle(lightBlue);
                    }

                    Main.delay(500, () -> {
                        button1.setStyle(darkGreen);
                        button2.setStyle(darkRed);
                        button3.setStyle(darkYellow);
                        button4.setStyle(darkBlue);
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
        button1.setStyle(lightGreen);
        Main.delay(500, () -> {
            button1.setStyle(darkGreen);
            guess.add(1);
        });
        if (guess.size() == sequence.size() && !(guess.equals(sequence))) {
            endGame();
        } else if (guess.size() == sequence.size() && guess.equals(sequence)) {
            score++;
            scoreLabel.setText(Integer.toString(score));
            run();
        }
    }

    private void handleButton2() throws InterruptedException {
        System.out.println("Button 2 pressed");
        button2.setStyle(lightRed);
        Main.delay(500, () -> {
            button2.setStyle(darkRed);
            guess.add(2);
        });
        if (guess.size() == sequence.size() && !(guess.equals(sequence))) {
            endGame();
        } else if (guess.size() == sequence.size() && guess.equals(sequence)) {
            score++;
            scoreLabel.setText(Integer.toString(score));
            run();
        }
    }

    private void handleButton3() throws InterruptedException {
        System.out.println("Button 3 pressed");
        button3.setStyle(lightYellow);
        Main.delay(500, () -> {
            button3.setStyle(darkYellow);
            guess.add(3);
        });
        if (guess.size() == sequence.size() && !(guess.equals(sequence))) {
            endGame();
        } else if (guess.size() == sequence.size() && guess.equals(sequence)) {
            score++;
            scoreLabel.setText(Integer.toString(score));
            run();
        }
    }

    private void handleButton4() throws InterruptedException {
        System.out.println("Button 4 pressed");
        button4.setStyle(lightBlue);
        Main.delay(500, () -> {
            button4.setStyle(darkBlue);
            guess.add(4);
        });
        if (guess.size() == sequence.size() && !(guess.equals(sequence))) {
            endGame();
        } else if (guess.size() == sequence.size() && guess.equals(sequence)) {
            score++;
            scoreLabel.setText(Integer.toString(score));
            run();
        }
    }
}