import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

import javafx.geometry.Insets; // Import Insets for setting margins

class Scene1 {
    public static Scene createScene(Stage primaryStage) {
        HBox header = new HBox();
        header.setSpacing(10);

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        for (String day : daysOfWeek) {
            Label label = new Label(day);
            label.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
            header.getChildren().add(label);
        }

        GridPane planner = new GridPane();
        int days = 7;
        int time = 16;
        int[] hours = {420};

        VBox RHours = new VBox(10);
        Label track = new Label("Remaining hours: " + hours[0]); // Declare and initialize track before the loop
        track.setAlignment(Pos.CENTER_RIGHT);
        RHours.getChildren().add(track); // Add the track label to the RHours VBox

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < time; j++) {
                Button button = new Button();
                button.setMinSize(80, 40);
                button.setStyle("-fx-base: grey");

                planner.add(button, i, j);

                button.setOnAction(event -> {
                    if (button.getStyle().contains("grey")) {
                        button.setStyle("-fx-base: red");
                        hours[0]--;
                        track.setText("Remaining hours: " + hours[0]);
                    } else {
                        button.setStyle("-fx-base: grey");
                        hours[0]++; // Increment the hours when the button turns grey again
                        track.setText("Remaining hours: " + hours[0]);
                    }
                });
            }
        }


        StackPane root = new StackPane();
        root.getChildren().addAll(header, planner, RHours);

        StackPane.setMargin(planner, new Insets(50, 0, 0, 0));
        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setMaximized(true);

        return scene;
    }

}
