package com.example.assignment2gc200521445.Controllers;

import com.example.assignment2gc200521445.Models.ApiResponse;
import com.example.assignment2gc200521445.Models.Data;
import com.example.assignment2gc200521445.Utilities.ApiUtility;
import com.example.assignment2gc200521445.Utilities.SceneChanger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SearchController implements Initializable {

    @FXML
    private Label chosenLabel;

    @FXML
    private Button detailsButton;

    @FXML
    private ImageView imageView;

    @FXML
    private ListView<Data> listView;

    @FXML
    private TextField textField;

    @FXML
    void getDetails(ActionEvent event) throws IOException {

    Data selectedData = listView.getSelectionModel().getSelectedItem();
    SceneChanger sceneChanger = new SceneChanger();
    sceneChanger.changeScene(event, "details_view.fxml", selectedData);

    }

    @FXML
    void searchData(ActionEvent event) {
        listView.getItems().clear();
        String searchText = textField.getText();
        ApiResponse apiResponse = ApiUtility.getDataFromApi(searchText);

        if (apiResponse.getData() == null) {
            chosenLabel.setText("No Jobs were found!");
        }
        else {

            chosenLabel.setText("");
            listView.getItems().addAll(apiResponse.getData());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                imageView.setImage(new Image(newValue.getEmployerLogo()));
                detailsButton.setVisible(true);
                chosenLabel.setText(newValue.toString());

            } catch (Exception e){
                imageView.setImage(new Image("https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-1-scaled.png"));
            }
        });

    }
}