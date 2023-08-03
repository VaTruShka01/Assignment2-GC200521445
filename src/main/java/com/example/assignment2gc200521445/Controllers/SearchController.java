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

    private ApiResponse apiResponse;


    /**
     * Handles the event when the user requests to view details of a selected item.
     * Retrieves the selected data from the list view and initiates a scene change to the details view.
     *
     * @param event The action event triggered by the user.
     */

    @FXML
    void getDetails(ActionEvent event) throws IOException {

    Data selectedData = listView.getSelectionModel().getSelectedItem();
    SceneChanger sceneChanger = new SceneChanger();
    sceneChanger.changeScene(event, "Views/details_view.fxml", selectedData, apiResponse );

    }


    /**
     * Handles the event when the user initiates a search.
     * Clears the list view, retrieves data from an API based on the search text,
     * and updates the list view with the retrieved data.
     *
     * @param event The action event triggered by the user.
     */

    @FXML
    void searchData(ActionEvent event) {

        listView.getItems().clear();
        String searchText = textField.getText();
        apiResponse = ApiUtility.getDataFromApi(searchText);
        if (apiResponse.getData().length == 0) {
            chosenLabel.setText("No Jobs were found!");
            detailsButton.setVisible(false);
        }
        else {
            chosenLabel.setText("");
            listView.getItems().addAll(apiResponse.getData());
        }
    }


    /**
     * Updates the search page with data from the provided ApiResponse.
     *
     * @param apiResponse The ApiResponse containing data to be displayed.
     */

    public void getSearchPageBack(ApiResponse apiResponse){
        this.apiResponse = apiResponse;
        if (apiResponse != null){
            listView.getItems().addAll(apiResponse.getData());

        }
    }


    /**
     * Initializes the controller and sets up a listener for the selected item in the list view.
     * When an item is selected, this method updates the image view, visibility of a button,
     * and the label to display relevant information about the selected item.
     *
     * @param url The location used to resolve relative paths for the root object.
     * @param resourceBundle The resources used to localize the root object.
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            try {
                chosenLabel.setText("Information not found");
                detailsButton.setVisible(true);
                chosenLabel.setText(newValue.toString());
                imageView.setImage(new Image(newValue.getEmployerLogo()));


            } catch (Exception e){
                imageView.setImage(new Image("https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-1-scaled.png"));
            }
        });
    }
}