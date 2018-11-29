package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EnglishSystemController implements Observer{
    @FXML
    Label ozLabel, lbLabel, stoneLabel;
    private EnglishSystem englishSystem;
    public void initialize(){
        englishSystem = new EnglishSystem();

    }


    @Override
    public void update(double value, String unit) {
        if (unit.equals("kg")){
            englishSystem.setFromMetricSystem(value);
        } else if (unit.equals("lb")){
            englishSystem.setPound(value);
        }
        ozLabel.setText(String.format("%.2f", englishSystem.getOz()));
        lbLabel.setText(String.format("%.2f", englishSystem.toPound()));
        stoneLabel.setText(String.format("%.2f", englishSystem.toStone()));
    }
}
