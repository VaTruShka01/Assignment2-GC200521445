package com.example.assignment2gc200521445.Utilities;

import com.example.assignment2gc200521445.Controllers.DetailsController;
import com.example.assignment2gc200521445.Main;
import com.example.assignment2gc200521445.Models.Data;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    /**
     * Changes the current scene to the specified FXML view file.
     * Optionally, passes data to the new scene's controller and updates the stage title.
     *
     * @param event The action event triggered by the user.
     * @param fxmlFile The path to the FXML file for the new scene.
     * @param data The Data object to be passed to the new scene's controller (can be null).
     */

        public static void changeScene(ActionEvent event, String fxmlFile, Data data) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            if (data != null){
                DetailsController controller = fxmlLoader.getController();
                controller.displayDetails(data);
                stage.setTitle("Job Description");
            }

            else {
                stage.setTitle("Job Search");
            }

            stage.setScene(scene);
            stage.show();
    }

}
