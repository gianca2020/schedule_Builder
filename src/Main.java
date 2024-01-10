import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    private Scene mainScene; // Declare mainScene as an instance variable, this declases that this class is the most important

    @Override
    public void start(Stage primaryStage) {
        // Create a button to switch to Scene1
        Button switchToScene1Button = new Button("Switch to Scene 1");
        StackPane root = new StackPane(switchToScene1Button);
        mainScene = new Scene(root, 400, 300); // Assign to the instance variable

        // Set the main scene
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Main Scene");

        // When the button is clicked, switch to Scene1
        switchToScene1Button.setOnAction(e -> {
            primaryStage.setScene(Scene1.createScene(primaryStage)); // Pass mainScene to Scene1
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

