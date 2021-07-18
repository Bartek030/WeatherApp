package pl.bartlomiej_swies;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Button button = new Button("LALA");
        button.setOnAction(e -> {
            System.out.println("LALA");
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);

        Scene scene = new Scene(stackPane, 300, 300);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}