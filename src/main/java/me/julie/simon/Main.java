package me.julie.simon;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("simon.fxml"));
        System.out.println("loading");
        Scene scene = fxmlLoader.load();
        System.out.println("loaded");
        stage.setTitle("Simon Says");
        stage.setScene(scene);
        System.out.println("showing");
        stage.show();
        System.out.println("show");
    }

    public static void main(String[] args) {
        launch();
    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<>() {
            @Override
            protected Void call() {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
}