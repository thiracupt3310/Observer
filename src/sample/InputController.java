package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class InputController implements Subject{
    @FXML
    TextField inputText;
    @FXML
    ChoiceBox unitSelector;
    @FXML
    Button submitBtn;
    private ArrayList<Observer> observers = new ArrayList<Observer>();


    public void initialize(){


        createEnglishStage();
        createMetricStage();
        unitSelector.getItems().addAll("kg", "lb");
        unitSelector.setValue("kg");

        submitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                notifyObserver();
            }
        });


    }

    public void createEnglishStage(){
        Stage engStage = new Stage();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("englishSystem.fxml"));
            engStage.setTitle("EnglishSystem");
            engStage.setScene(new Scene((Parent) loader.load(), 300, 275));
            engStage.setX(0);
            engStage.setY(0);
            addObserver((Observer) loader.getController());
            engStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createMetricStage(){
        Stage metricStage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("metricSystem.fxml"));
            metricStage.setTitle("MetricSystem");
            metricStage.setScene(new Scene((Parent) loader.load(), 300, 275));
            metricStage.setX(0);
            metricStage.setY(310);
            addObserver((Observer) loader.getController());
            metricStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers){
                o.update(Double.parseDouble(inputText.getText()), unitSelector.getValue().toString());
        }
        inputText.setText("");
        unitSelector.getSelectionModel().clearAndSelect(0);
    }
}
