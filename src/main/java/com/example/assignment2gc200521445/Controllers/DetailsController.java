package com.example.assignment2gc200521445.Controllers;

import com.example.assignment2gc200521445.Models.Data;
import com.example.assignment2gc200521445.Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private Text detailsText;

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

    @FXML
    void goBack(ActionEvent event) throws IOException {

        SceneChanger sceneChanger = new SceneChanger();
        sceneChanger.changeScene(event, "search_view.fxml", null);
    }


    public void displayDetails(Data data) {


        applyLinkLabel.setText(data.getApplyLink());
        cityLabel.setText(data.getJobCity());
        countryLabel.setText(data.getJobCountry());
        detailsText.setText(data.getJobDescription());
        employerNameLabel.setText(data.getEmployerName());
        jobTitleLabel.setText(data.getJobTitle());
        publisherLabel.setText(data.getJobPublisher());
        stateLabel.setText(data.getJobState());

        try {
            jobImageView.setImage(new Image(data.getEmployerLogo()));
        }
        catch (Exception e) {
            jobImageView.setImage(new Image("https://www.salonlfc.com/wp-content/uploads/2018/01/image-not-found-1-scaled.png"));
        }
    }
}