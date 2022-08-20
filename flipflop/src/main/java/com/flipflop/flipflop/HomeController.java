package com.flipflop.flipflop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button btnCharts;
    @FXML
    private Button btnDataEntry;
    @FXML
    private Button btnInsights;
    @FXML
    private Button btnSettings;
    @FXML
    private Pane rightPane;

    @FXML
    void handleButtonClick(ActionEvent event) throws IOException {
        Object source = event.getSource();
        if (btnDataEntry.equals(source)) {
            showDataPane();
            // rightPane.setBackground(new Background(new BackgroundFill(Color.color(0,0,0), CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (btnCharts.equals(source)) {
            showChartsPane();
            // rightPane.setBackground(new Background(new BackgroundFill(Color.color(0,1,1), CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (btnInsights.equals(source)) {
            rightPane.setBackground(new Background(new BackgroundFill(Color.color(1,0,1), CornerRadii.EMPTY, Insets.EMPTY)));
        } else if (btnSettings.equals(source)) {
            rightPane.setBackground(new Background(new BackgroundFill(Color.color(0.5,0.5,1), CornerRadii.EMPTY, Insets.EMPTY)));
        } else {
            // TODO
        }
    }

    public void showDataPane() throws IOException {
        Pane dataPane = FXMLLoader.load(getClass().getResource("data-pane.fxml"));
        rightPane.getChildren().clear();
        rightPane.getChildren().add(dataPane);
    }

    public void showChartsPane() throws IOException {
        Pane dataPane = FXMLLoader.load(getClass().getResource("charts-pane.fxml"));
        rightPane.getChildren().clear();
        rightPane.getChildren().add(dataPane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}