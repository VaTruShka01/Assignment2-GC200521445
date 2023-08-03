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
