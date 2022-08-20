package com.flipflop.flipflop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    private CheckBox checkData3;
    @FXML
    private TextField textData1;
    @FXML
    private PasswordField textData2;

    private static Connection database;

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

    public void handleDataSubmit() {
        String data1 = textData1.getText();
        String data2 = textData2.getText();
        Boolean check = checkData3.isSelected();
        if (check) {
            System.out.println(data1 + " " + data2);
        } else {
            System.out.println("Not selected");
        }

        try {
            System.out.println("Query db!");
            String query = "select * from maindata;";
            Statement statement = database.createStatement();
            ResultSet queryOutput = statement.executeQuery(query);
            System.out.println("Result retrived");
            while (queryOutput.next()) {
                String dbData1 = queryOutput.getString("data1");
                String dbData2 = queryOutput.getString("data2");
                System.out.println(dbData1 + " " + dbData2);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
