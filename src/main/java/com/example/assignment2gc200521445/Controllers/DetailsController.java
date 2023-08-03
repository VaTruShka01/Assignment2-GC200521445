package com.example.assignment2gc200521445.Controllers;

import com.example.assignment2gc200521445.Models.ApiResponse;
import com.example.assignment2gc200521445.Models.Data;
import com.example.assignment2gc200521445.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class DetailsController {

    @FXML
    private Label applyLinkLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private ListView<String> detailsText;

    @FXML
    private Label employerNameLabel;

    @FXML
    private ImageView jobImageView;

    @FXML
    private Label jobTitleLabel;

    @FXML
    private Label publisherLabel;

    @FXML
    private Label stateLabel;
    private ApiResponse apiResponse;


    /**
     * Handles the event when the user requests to go back to the search view.
     * Initiates a scene change to the search view.
     *
     * @param event The action event triggered by the user.
     */

    @FXML
    void goBack(ActionEvent event) throws IOException {

        SceneChanger sceneChanger = new SceneChanger();
        SceneChanger.changeScene(event, "Views/search_view.fxml", null, this.apiResponse);
    }


    /**
     * Displays the details of a given data object in the UI.
     *
     * @param data The Data object containing details to be displayed.
     */

    public void displayDetails(Data data, ApiResponse jobs) {

        applyLinkLabel.setText(data.getApplyLink());
        cityLabel.setText(data.getJobCity());
        countryLabel.setText(data.getJobCountry());
        detailsText.getItems().add(data.getJobDescription());
        employerNameLabel.setText(data.getEmployerName());
        jobTitleLabel.setText(data.getJobTitle());
        publisherLabel.setText(data.getJobPublisher());
        stateLabel.setText(data.getJobState());
        this.apiResponse = jobs;

        try {
            jobImageView.setImage(new Image(data.getEmployerLogo()));
        }
        catch (Exception e) {
            jobImageView.setImage(new Image("https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-1-scaled.png"));
        }
    }
}
